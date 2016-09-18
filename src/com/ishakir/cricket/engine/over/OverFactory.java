package com.ishakir.cricket.engine.over;

import com.ishakir.cricket.engine.innings.Batsmen;
import com.ishakir.cricket.engine.ball.Ball;
import com.ishakir.cricket.engine.players.Batsman;
import com.ishakir.cricket.engine.players.Bowler;

import java.util.List;

/**
 * Created by imran on 06/02/16.
 */
public interface OverFactory<
        Ba extends Batsman,
        Bo extends Bowler,
        B  extends Ball<Ba, Bo>> {
    public abstract Over<Ba, Bo, B> newOver(Batsmen<Ba> batsmen, Bo bowler, List<Bo> fielders);
}
