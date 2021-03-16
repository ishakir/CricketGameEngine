package com.ishakir.cricket.engine.ball.wicket;

import com.ishakir.cricket.engine.players.Batsman;
import com.ishakir.cricket.engine.players.Bowler;

import java.util.Optional;

/**
 * Created by imran on 10/02/16.
 */
public class Stumped<
        Ba extends Batsman,
        Bo extends Bowler> extends Wicket<Ba, Bo> {
    public Stumped(Ba batsman, Bo bowler, Bo wicketkeeper) {
        super(batsman, Optional.of(bowler), Optional.of(wicketkeeper));
    }

    @Override
    public String toString() {
        return "stumped";
    }
}
