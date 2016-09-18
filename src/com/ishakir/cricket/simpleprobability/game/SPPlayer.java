package com.ishakir.cricket.simpleprobability.game;

import com.ishakir.cricket.engine.players.Player;
import com.ishakir.cricket.simpleprobability.probability.FiniteProbabilityDistribution;

/**
 * Created by imran on 09/02/16.
 */
public class SPPlayer implements Player<SPBatsman, MockBowler> {
    private String name;
    private FiniteProbabilityDistribution<SimpleBallResult> distribution;

    public SPPlayer(String name, FiniteProbabilityDistribution<SimpleBallResult> distribution) {
        this.name = name;
        this.distribution = distribution;
    }

    @Override
    public SPBatsman newBatsman() {
        return new SPBatsman(name, distribution);
    }

    @Override
    public MockBowler newBowler() {
        return new MockBowler();
    }
}
