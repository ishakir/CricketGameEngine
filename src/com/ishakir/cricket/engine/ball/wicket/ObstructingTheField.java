package com.ishakir.cricket.engine.ball.wicket;

import com.ishakir.cricket.engine.players.Batsman;
import com.ishakir.cricket.engine.players.Bowler;

import java.util.Optional;

/**
 * Created by imran on 10/02/16.
 */
public class ObstructingTheField<
        Ba extends Batsman,
        Bo extends Bowler> extends Wicket<Ba, Bo> {
    public ObstructingTheField(Ba batsman) {
        super(batsman, Optional.empty(), Optional.empty());
    }

    @Override
    public String toString() {
        return "obstructing the field";
    }
}
