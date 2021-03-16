package com.ishakir.cricket.engine.innings;

import com.ishakir.cricket.engine.players.Player;
import com.ishakir.cricket.engine.players.Team;
import com.ishakir.cricket.engine.ball.Ball;
import com.ishakir.cricket.engine.players.Batsman;
import com.ishakir.cricket.engine.players.Bowler;

/**
 * Created by imran on 09/02/16.
 */
public interface InningsFactory<
        Ba extends Batsman,
        Bo extends Bowler,
        B extends Ball<Ba, Bo>,
        P extends Player<Ba, Bo>> {
    public Innings<Ba, Bo, B, P> newInnings(Team<Ba, Bo, P> battingTeam, Team<Ba, Bo, P> bowlingTeam);
}
