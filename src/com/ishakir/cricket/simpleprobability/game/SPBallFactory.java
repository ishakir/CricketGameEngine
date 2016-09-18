package com.ishakir.cricket.simpleprobability.game;

import com.ishakir.cricket.engine.ball.BallFactory;

import java.util.List;

/**
 * Created by imran on 07/02/16.
 */
public class SPBallFactory implements BallFactory<SPBatsman, MockBowler, SPBall> {
    @Override
    public SPBall newBall(SPBatsman batsman, MockBowler bowler, List<MockBowler> fielders) {
        return new SPBall(batsman, bowler, fielders);
    }
}
