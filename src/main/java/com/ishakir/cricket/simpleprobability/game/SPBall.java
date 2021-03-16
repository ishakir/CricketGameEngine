package com.ishakir.cricket.simpleprobability.game;

import com.ishakir.cricket.engine.ball.Ball;

import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Created by imran on 07/02/16.
 */
public class SPBall extends Ball<SPBatsman, MockBowler> {

    private SimpleBallResult result;

    public SPBall(SPBatsman batsman, MockBowler bowler, List<MockBowler> fielders) {
        super(batsman, bowler, fielders);
    }

    @Override
    protected void bowlImpl() {
        result = batsman.newResult();
    }

    @Override
    public int runs() {
        return result.getRuns();
    }

    @Override
    public Optional<Wicket<SPBatsman, MockBowler>> dismissal() {
        if(!result.isWicket()) {
            return Optional.empty();
        } else {
            Random random = new Random();
            int wicketRandom = random.nextInt(11);
            if(wicketRandom == 0) {
                return Optional.of(new RunOut<>(batsman, fielders.get(random.nextInt(fielders.size()))));
            } else if (wicketRandom < 3) {
                return Optional.of(new Bowled<>(batsman, bowler));
            } else if (wicketRandom < 7) {
                return Optional.of(new Caught<>(batsman, bowler, fielders.get(random.nextInt(fielders.size()))));
            } else if (wicketRandom < 9) {
                return Optional.of(new LBW<>(batsman, bowler));
            } else {
                return Optional.of(new Stumped<>(batsman, bowler, fielders.get(random.nextInt(fielders.size()))));
            }
        }
    }

}
