package com.ishakir.cricket.simpleprobability.game;

/**
 * Created by imran on 07/02/16.
 */
public class SimpleBallResult {

    private int runs;
    private boolean isWicket;

    public SimpleBallResult(int runs, boolean isWicket) {
        this.runs = runs;
        this.isWicket = isWicket;
    }

    public int getRuns() {
        return runs;
    }

    public boolean isWicket() {
        return isWicket;
    }


}
