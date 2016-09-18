package com.ishakir.cricket.engine.innings;

import com.ishakir.cricket.engine.ball.Ball;
import com.ishakir.cricket.engine.over.OverFactory;
import com.ishakir.cricket.engine.players.Batsman;
import com.ishakir.cricket.engine.players.Bowler;
import com.ishakir.cricket.engine.players.Player;
import com.ishakir.cricket.engine.players.Team;

/**
 * Created by imran on 06/02/16.
 */
public class FixedLengthInnings<
        Ba extends Batsman,
        Bo extends Bowler,
        B extends Ball<Ba, Bo>,
        P extends Player<Ba, Bo>> extends Innings<Ba, Bo, B, P> {

    private int maxOvers;

    public FixedLengthInnings(Team<Ba, Bo, P> battingTeam, Team<Ba, Bo, P> bowlingTeam, OverFactory<Ba, Bo, B> overFactory, int maxOvers) {
        super(battingTeam, bowlingTeam, overFactory);
        this.maxOvers = maxOvers;
    }

    @Override
    protected boolean isCompleteImpl() {
        return overs.size() == maxOvers && overs.get(overs.size() - 1).isComplete();
    }
}
