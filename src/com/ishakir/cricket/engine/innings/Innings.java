package com.ishakir.cricket.engine.innings;

import com.ishakir.cricket.engine.ball.Ball;
import com.ishakir.cricket.engine.over.Over;
import com.ishakir.cricket.engine.over.OverFactory;
import com.ishakir.cricket.engine.players.Batsman;
import com.ishakir.cricket.engine.players.Bowler;
import com.ishakir.cricket.engine.players.Player;
import com.ishakir.cricket.engine.players.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Innings<
        Ba extends Batsman,
        Bo extends Bowler,
        B  extends Ball<Ba, Bo>,
        P extends Player<Ba, Bo>> {
    private Team<Ba, Bo, P> battingTeam;
    private Team<Ba, Bo, P> bowlingTeam;

    private Batsmen<Ba> batsmen;
    private Bowlers<Bo> bowlers;

    protected List<Over<Ba, Bo, B>> overs;
    private OverFactory<Ba, Bo, B> overFactory;

    public Innings(Team<Ba, Bo, P> battingTeam, Team<Ba, Bo, P> bowlingTeam, OverFactory<Ba, Bo, B> overFactory) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;

        this.batsmen = battingTeam.newBatsmen();
        this.bowlers = bowlingTeam.newBowlers();

        this.overFactory = overFactory;
        this.overs = new ArrayList<>();
    }

    public B nextBall() {
        if(isComplete()) {
            throw new IllegalStateException("Why are we calling nextBall() on a completed innings!");
        }

        Over<Ba, Bo, B> currentOver = getCurrentOverOrCreateNew();
        return currentOver.nextBall();
    }

    public Over<Ba, Bo, B> completeOrFullNextOver() {
        if(isComplete()) {
            throw new IllegalStateException("Why are we calling completeOrFullNextOver() on a completed innings!");
        }

        Over<Ba, Bo, B> currentOver = getCurrentOverOrCreateNew();
        currentOver.complete();
        return currentOver;
    }

    // Guarenteed not to return a completed over
    private Over<Ba, Bo, B> getCurrentOverOrCreateNew() {
        // Work out if we're mid over
        if(!overs.isEmpty()) {
            Over<Ba, Bo, B> mostRecentOver = overs.get(overs.size() - 1);
            if(!mostRecentOver.isComplete()) {
                return mostRecentOver;
            } else {
                batsmen.endOfOver();
                bowlers.endOfOver();
            }
        }

        Over<Ba, Bo, B> newOver = overFactory.newOver(batsmen, bowlers.getCurrent(), bowlers.getAll());
        overs.add(newOver);
        return newOver;
    }

    public List<Over<Ba, Bo, B>> getOvers() {
        return overs;
    }
    public int runs() {
        return overs.stream().mapToInt(o -> o.getBalls().stream().mapToInt(b -> b.runs()).sum()).sum();
    }
    public int wickets() {
        return (int) overs.stream().mapToLong(o -> o.getBalls().stream().filter(b -> b.isWicket()).count()).sum();
    }

    public List<BatsmanInnings<Ba, Bo, B>> batsmen() {
        return batsmen.getAll().stream().map(
                b -> batsman(b)
        ).collect(Collectors.toList());
    }

    public BatsmanInnings<Ba, Bo, B> batsman(Ba batsman) {
        return new BatsmanInnings<>(batsman, overs.stream().flatMap(o -> o.getBalls().stream()).filter(ball -> ball.getBatsman().equals(batsman)).collect(Collectors.toList()));
    }

    public Ba getOnStrikeBatsman() {
        // Make sure if we're at the end of an over, that we grab the new one and swap ends
        getCurrentOverOrCreateNew();
        return batsmen.getOnStrike();
    }

    public Ba getOffStrikeBatsman() {
        getCurrentOverOrCreateNew();
        return batsmen.getOffStrike();
    }

    protected abstract boolean isCompleteImpl();
    // See comment for equivalent method in Over.java We're going to ignore the case where batsmen being all out
    // isn't the end of the innings. Again, can probably factor out to something more general if needs be
    public boolean isComplete() {
        return batsmen.areAllOut() || isCompleteImpl();
    }
}
