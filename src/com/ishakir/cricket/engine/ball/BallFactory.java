package com.ishakir.cricket.engine.ball;

import com.ishakir.cricket.engine.players.Batsman;
import com.ishakir.cricket.engine.players.Bowler;

import java.util.List;

/**
 * Created by imran on 06/02/16.
 */
public interface BallFactory<
        Ba extends Batsman,
        Bo extends Bowler,
        B extends Ball<Ba, Bo>> {
    public B newBall(Ba batsman, Bo bowler, List<Bo> fielders);
}
