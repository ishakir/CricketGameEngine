package com.ishakir.cricket.engine.ball.wicket;

import com.ishakir.cricket.engine.players.Batsman;
import com.ishakir.cricket.engine.players.Bowler;

import java.util.Optional;

/**
 * Created by imran on 10/02/16.
 */
public class RunOut<
        Ba extends Batsman,
        Bo extends Bowler> extends Wicket<Ba, Bo> {
    public RunOut(Ba batsman, Bo fielder) {
        super(batsman, Optional.empty(), Optional.of(fielder));
    }

    @Override
    public String toString() {
        return "run out";
    }
}
