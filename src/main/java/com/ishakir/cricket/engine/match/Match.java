package com.ishakir.cricket.engine.match;

import com.ishakir.cricket.engine.players.Team;
import com.ishakir.cricket.engine.ball.Ball;
import com.ishakir.cricket.engine.innings.Innings;
import com.ishakir.cricket.engine.innings.InningsFactory;
import com.ishakir.cricket.engine.over.Over;
import com.ishakir.cricket.engine.players.Batsman;
import com.ishakir.cricket.engine.players.Bowler;
import com.ishakir.cricket.engine.players.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imran on 06/02/16.
 */
public abstract class Match<
        Ba extends Batsman,
        Bo extends Bowler,
        B extends Ball<Ba, Bo>,
        P extends Player<Ba, Bo>> {

    private InningsFactory<Ba, Bo, B, P> inningsFactory;

    protected Team<Ba, Bo, P> teamBattingFirst;
    protected Team<Ba, Bo, P> teamBattingSecond;

    private List<Innings<Ba, Bo, B, P>> battingFirstInnings;
    private List<Innings<Ba, Bo, B, P>> battingSecondInnings;

    public Match(Team<Ba, Bo, P> teamA, Team<Ba, Bo, P> teamB, InningsFactory<Ba, Bo, B, P> inningsFactory) {
        teamBattingFirst = teamBattingFirstInternal(teamA, teamB);
        if(teamA == teamBattingFirst) {
            teamBattingSecond = teamB;
        } else {
            teamBattingSecond = teamA;
        }

        this.inningsFactory = inningsFactory;

        battingFirstInnings = new ArrayList<>();
        battingSecondInnings = new ArrayList<>();
    }

    public abstract Team<Ba, Bo, P> teamBattingFirstInternal(Team<Ba, Bo, P> teamA, Team<Ba, Bo, P> teamB);

    public List<Innings<Ba, Bo, B, P>> inningsFor(Team<Ba, Bo,P> team) {
        if(teamBattingFirst == team) {
            return battingFirstInnings;
        } else {
            return battingSecondInnings;
        }
    }

    public B nextBall() {
        return currentInningsOrCreateNext().nextBall();
    }

    public Over<Ba, Bo, B> completeCurrentOverOrNextOver() {
        return currentInningsOrCreateNext().completeOrFullNextOver();
    }

    public Innings<Ba, Bo, B, P> completeCurrentInningsOrNextInnings() {
        Innings<Ba, Bo, B, P> innings = currentInningsOrCreateNext();
        while(!innings.isComplete()) {
            innings.completeOrFullNextOver();
        }
        return innings;
    }

    public Innings<Ba, Bo, B, P> currentInningsOrCreateNext() {
        if(battingFirstInnings.isEmpty()) {
            Innings<Ba, Bo, B, P> innings = inningsFactory.newInnings(teamBattingFirst, teamBattingSecond);
            battingFirstInnings.add(innings);
            return innings;
        }

        Innings<Ba, Bo, B, P> mostRecent;
        boolean mostRecentIsBattingFirst;
        if(battingFirstInnings.size() > battingSecondInnings.size()) {
            mostRecent = battingFirstInnings.get(battingFirstInnings.size() - 1);
            mostRecentIsBattingFirst = true;
        } else {
            mostRecent = battingSecondInnings.get(battingSecondInnings.size() - 1);
            mostRecentIsBattingFirst = false;
        }

        if(!mostRecent.isComplete()) {
            return mostRecent;
        }

        if(mostRecentIsBattingFirst) {
            Innings<Ba, Bo, B, P> innings = inningsFactory.newInnings(teamBattingSecond, teamBattingFirst);
            battingSecondInnings.add(innings);
            return innings;
        } else {
            Innings<Ba, Bo, B, P> innings = inningsFactory.newInnings(teamBattingFirst, teamBattingSecond);
            battingFirstInnings.add(innings);
            return innings;
        }
    }

    public abstract boolean isComplete();

}
