package com.ishakir.cricket.engine.over;

import com.ishakir.cricket.engine.innings.Batsmen;
import com.ishakir.cricket.engine.ball.Ball;
import com.ishakir.cricket.engine.ball.BallFactory;
import com.ishakir.cricket.engine.players.Batsman;
import com.ishakir.cricket.engine.players.Bowler;

import java.util.List;

/**
 * Created by imran on 07/02/16.
 */
public class StandardSixBallOverFactory<
        Ba extends Batsman,
        Bo extends Bowler,
        B extends Ball<Ba, Bo>> implements OverFactory<Ba, Bo, B> {

    private BallFactory<Ba, Bo, B> ballFactory;

    public StandardSixBallOverFactory(BallFactory<Ba, Bo, B> ballFactory) {
        this.ballFactory = ballFactory;
    }

    @Override
    public FixedNumberOfBallsOver<Ba, Bo, B> newOver(Batsmen<Ba> batsmen, Bo bowler, List<Bo> fielders) {
        return FixedNumberOfBallsOver.standardSixBallOver(batsmen, bowler, fielders, ballFactory);
    }
}
