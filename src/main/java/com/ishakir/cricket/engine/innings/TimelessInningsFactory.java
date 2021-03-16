package com.ishakir.cricket.engine.innings;

import com.ishakir.cricket.engine.ball.Ball;
import com.ishakir.cricket.engine.over.OverFactory;
import com.ishakir.cricket.engine.players.Batsman;
import com.ishakir.cricket.engine.players.Bowler;
import com.ishakir.cricket.engine.players.Player;
import com.ishakir.cricket.engine.players.Team;

/**
 * Created by imran on 09/02/16.
 */
public class TimelessInningsFactory<
        Ba extends Batsman,
        Bo extends Bowler,
        B extends Ball<Ba, Bo>,
        P extends Player<Ba, Bo>> implements InningsFactory<Ba, Bo, B, P> {

    private OverFactory<Ba, Bo, B> overFactory;

    public TimelessInningsFactory(OverFactory<Ba, Bo, B> overFactory) {
        this.overFactory = overFactory;
    }

    @Override
    public Innings<Ba, Bo, B, P> newInnings(Team<Ba, Bo, P> battingTeam, Team<Ba, Bo, P> bowlingTeam) {
        return new TimelessInnings<>(battingTeam, bowlingTeam, overFactory);
    }
}
