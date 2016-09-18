package com.ishakir.cricket.engine.ball.wicket;

import com.ishakir.cricket.engine.players.Batsman;
import com.ishakir.cricket.engine.players.Bowler;

import java.util.Optional;

/**
 * Created by imran on 10/02/16.
 */
public class HandledBall<
        Ba extends Batsman,
        Bo extends Bowler> extends Wicket<Ba, Bo> {
    public HandledBall(Ba batsman) {
        super(batsman, Optional.empty(), Optional.empty());
    }

    @Override
    public String toString() {
        return "handled ball";
    }
}
