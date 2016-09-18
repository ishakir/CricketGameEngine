package com.ishakir.cricket.simpleprobability.game;

import com.ishakir.cricket.engine.players.Batsman;
import com.ishakir.cricket.simpleprobability.probability.FiniteProbabilityDistribution;

/**
 * Created by imran on 07/02/16.
 */
public class SPBatsman implements Batsman {
    private FiniteProbabilityDistribution<SimpleBallResult> distribution;
    private String name;

    public SPBatsman(String name, FiniteProbabilityDistribution<SimpleBallResult> distribution) {
        this.name = name;
        this.distribution = distribution;
    }

    public SimpleBallResult newResult() {
        return distribution.draw();
    }
    public String getName() { return name; }

}
