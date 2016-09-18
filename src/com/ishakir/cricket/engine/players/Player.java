package com.ishakir.cricket.engine.players;

/**
 * Created by imran on 09/02/16.
 */
public interface Player<
        Ba extends Batsman,
        Bo extends Bowler> {
    public Ba newBatsman();
    public Bo newBowler();
}
