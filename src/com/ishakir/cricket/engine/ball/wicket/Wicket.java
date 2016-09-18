package com.ishakir.cricket.engine.ball.wicket;

import com.ishakir.cricket.engine.players.Batsman;
import com.ishakir.cricket.engine.players.Bowler;

import java.util.Optional;

/**
 * Created by imran on 10/02/16.
 */
public abstract class Wicket<
        Ba extends Batsman,
        Bo extends Bowler> {

    private Ba batsman;
    private Optional<Bo> bowler;
    private Optional<Bo> fielder;

    public Wicket(Ba batsman, Optional<Bo> bowler, Optional<Bo> fielder) {
        this.batsman = batsman;
        this.bowler = bowler;
        this.fielder = fielder;
    }

    public Ba batsman() {
        return batsman;
    }

    public Optional<Bo> bowler() {
        return bowler;
    }

    public Optional<Bo> fielder() {
        return fielder;
    }

    public abstract String toString();

}
