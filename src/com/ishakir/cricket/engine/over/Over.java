package com.ishakir.cricket.engine.over;

import com.ishakir.cricket.engine.ball.Ball;
import com.ishakir.cricket.engine.ball.BallFactory;
import com.ishakir.cricket.engine.innings.Batsmen;
import com.ishakir.cricket.engine.players.Batsman;
import com.ishakir.cricket.engine.players.Bowler;

import java.util.ArrayList;
import java.util.List;

public abstract class Over<
        Ba extends Batsman,
        Bo extends Bowler,
        B  extends Ball<Ba, Bo>> {

    private Batsmen<Ba> batsmen;
    private Bo bowler;
    private List<Bo> fielders;

    protected List<B> balls;
    private BallFactory<Ba, Bo, B> ballFactory;

    protected Over(Batsmen<Ba> batsmen, Bo bowler, List<Bo> fielders, BallFactory<Ba, Bo, B> ballFactory) {
        this.batsmen = batsmen;
        this.bowler = bowler;
        this.fielders = fielders;
        this.ballFactory = ballFactory;

        this.balls = new ArrayList<>();
    }

    public B nextBall() {
        if(isComplete()) {
            throw new IllegalStateException("Why are we calling nextBall() on an over that's already completed!");
        }

        B ball = ballFactory.newBall(batsmen.getOnStrike(), bowler, fielders);
        ball.bowl();

        // Update the state of the batsmen
        batsmen.runs(ball.runs());
        if(ball.isWicket()) {
            batsmen.onStrikeOut();
        }

        balls.add(ball);

        return ball;
    }

    public void complete() {
        while(!isComplete()) {
            nextBall();
        }
    }

    public List<B> getBalls() {
        return balls;
    }

    // You can imagine having a kids cricket game or similar whereby perhaps everyone being all out doesn't end the innings
    // but it's a very minor edge case, let's assume this piece of behaviour is common for now. The Batsmen class will need
    // to be abstracted in that case and various other grossnesses
    public boolean isComplete() {
        return batsmen.areAllOut() || isCompleteImpl();
    }
    protected abstract boolean isCompleteImpl();

}
