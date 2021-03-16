package com.ishakir.cricket.engine.ball.wicket;

import com.ishakir.cricket.engine.players.Batsman;
import com.ishakir.cricket.engine.players.Bowler;

import java.util.Optional;

/**
 * Created by imran on 10/02/16.
 */
public class HitWicket<
        Ba extends Batsman,
        Bo extends Bowler> extends Wicket<Ba, Bo> {
    public HitWicket(Ba batsman, Bo bowler) {
        super(batsman, Optional.of(bowler), Optional.empty());
    }

    @Override
    public String toString() {
        return "hit wicket";
    }
}
