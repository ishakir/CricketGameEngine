package com.ishakir.cricket.engine.match;

import com.ishakir.cricket.engine.ball.Ball;
import com.ishakir.cricket.engine.innings.Innings;
import com.ishakir.cricket.engine.innings.InningsFactory;
import com.ishakir.cricket.engine.over.Over;
import com.ishakir.cricket.engine.players.Batsman;
import com.ishakir.cricket.engine.players.Bowler;
import com.ishakir.cricket.engine.players.Player;
import com.ishakir.cricket.engine.players.Team;

import java.util.List;

/**
 * Created by imran on 09/02/16.
 */
public abstract class FixedNumberOfInningsMatch<
        Ba extends Batsman,
        Bo extends Bowler,
        B extends Ball<Ba, Bo>,
        P extends Player<Ba, Bo>> extends Match<Ba, Bo, B, P> {

    private int inningsPerSide;

    public FixedNumberOfInningsMatch(Team<Ba, Bo, P> teamA, Team<Ba, Bo, P> teamB, int inningsPerSide, InningsFactory<Ba, Bo, B, P> inningsFactory) {
        super(teamA, teamB, inningsFactory);
        this.inningsPerSide = inningsPerSide;
    }

    @Override
    public abstract Team<Ba, Bo, P> teamBattingFirstInternal(Team<Ba, Bo, P> teamA, Team<Ba, Bo, P> teamB);

    @Override
    public boolean isComplete() {
        // If all but the final "teamBattingSecondInnings" is complete, then we need to do a runs comparison
        List<Innings<Ba, Bo, B, P>> teamBattingFirstInnings = inningsFor(teamBattingFirst);
        List<Innings<Ba, Bo, B, P>> teamBattingSecondsInnings = inningsFor(teamBattingSecond);

        if(teamBattingFirstInnings.size() < inningsPerSide) {
            return false;
        } else {
            // So we know that the team batting first have completed all their innings
            if(teamBattingSecondsInnings.size() < inningsPerSide - 1) {
                throw new IllegalArgumentException("WTF is going on here?");
            } else {
                int teamBattingFirstRuns = inningsFor(teamBattingFirst).stream().mapToInt(x -> x.runs()).sum();
                int teamBattingSecondRuns = inningsFor(teamBattingSecond).stream().mapToInt(x -> x.runs()).sum();
                return teamBattingSecondRuns > teamBattingFirstRuns;
            }
        }

    }
}
