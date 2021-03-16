package com.ishakir.cricket.engine.over;

import com.ishakir.cricket.engine.innings.Batsmen;
import com.ishakir.cricket.engine.ball.Ball;
import com.ishakir.cricket.engine.ball.BallFactory;
import com.ishakir.cricket.engine.players.Batsman;
import com.ishakir.cricket.engine.players.Bowler;

import java.util.List;

/**
 * Created by imran on 06/02/16.
 */
public class FixedNumberOfBallsOver<
        Ba extends Batsman,
        Bo extends Bowler,
        B extends Ball<Ba, Bo>> extends Over<Ba, Bo, B> {

    public static <
            Ba extends Batsman,
            Bo extends Bowler,
            B extends Ball<Ba, Bo>> FixedNumberOfBallsOver<Ba, Bo, B> standardSixBallOver(
                Batsmen<Ba> batsmen, Bo bowler, List<Bo> fielders, BallFactory<Ba, Bo, B> ballFactory) {
        return new FixedNumberOfBallsOver<>(batsmen, bowler, fielders, ballFactory, 6);
    }

    private final int maxBalls;

    public FixedNumberOfBallsOver(Batsmen<Ba> batsmen, Bo bowler, List<Bo> fielders, BallFactory<Ba, Bo, B> ballFactory, int noBalls) {
        super(batsmen, bowler, fielders, ballFactory);
        this.maxBalls = noBalls;
    }

    @Override
    public boolean isCompleteImpl() {
        return balls.size() == maxBalls;
    }
}
