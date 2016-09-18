package com.ishakir.cricket.engine.ball;

import com.ishakir.cricket.engine.ball.wicket.Wicket;
import com.ishakir.cricket.engine.players.Batsman;
import com.ishakir.cricket.engine.players.Bowler;

import java.util.List;
import java.util.Optional;

public abstract class Ball<Ba extends Batsman, Bo extends Bowler> {

    protected Ba batsman;
    protected Bo bowler;
    protected List<Bo> fielders;

    private boolean bowled = false;

    public Ball(Ba batsman, Bo bowler, List<Bo> fielders) {
        this.batsman = batsman;
        this.bowler = bowler;
        this.fielders = fielders;
    }

    public void bowl() {
        bowlImpl();
        this.bowled = true;
    }

    protected abstract void bowlImpl();

    private boolean hasBeenBowled() {
        return bowled;
    }

    public Ba getBatsman() {
        return batsman;
    }

    public abstract int runs();

    public boolean isWicket() {
        return dismissal().isPresent();
    }

    public abstract Optional<Wicket<Ba, Bo>> dismissal();

    @Override
    public String toString() {
        if(!bowled) {
            return "<not yet bowled>";
        } else {
            if(isWicket()) {
                if(runs() == 0) {
                    return "W";
                } else {
                    return runs() + "W";
                }
            } else {
                if(runs() == 0) {
                    return ".";
                } else {
                    return String.valueOf(runs());
                }
            }
        }
    }

}
