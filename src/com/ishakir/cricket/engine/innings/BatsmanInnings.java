package com.ishakir.cricket.engine.innings;

import com.ishakir.cricket.engine.ball.Ball;
import com.ishakir.cricket.engine.ball.wicket.Wicket;
import com.ishakir.cricket.engine.players.Batsman;
import com.ishakir.cricket.engine.players.Bowler;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by imran on 07/02/16.
 */
public class BatsmanInnings<Ba extends Batsman, Bo extends Bowler, B extends Ball<Ba, Bo>> {
    private Ba batsman;
    private List<B> balls;

    public BatsmanInnings(Ba batsman, List<B> balls) {
        this.batsman = batsman;
        this.balls = balls;
    }

    public int runs() {
        return balls.stream().mapToInt(b -> b.runs()).sum();
    }

    public int numberOfBalls() {
        return balls.size();
    }

    public Optional<Wicket<Ba, Bo>> wicket() {
        List<Ball<Ba, Bo>> wickets = balls.stream().filter(b -> b.isWicket()).collect(Collectors.toList());
        if(wickets.isEmpty()) {
            return Optional.empty();
        } else if(wickets.size() > 1) {
            throw new IllegalStateException("Batsman was out twice?!");
        } else {
            return wickets.get(0).dismissal();
        }
    }

    public boolean wasOut() {
        return wicket().isPresent();
    }

    public Ba getBatsman() {
        return batsman;
    }

}
