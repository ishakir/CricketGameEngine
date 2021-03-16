package com.ishakir.cricket.engine.players;

import com.ishakir.cricket.engine.innings.Batsmen;
import com.ishakir.cricket.engine.innings.Bowlers;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by imran on 09/02/16.
 */
public class Team<
        Ba extends Batsman,
        Bo extends Bowler,
        P extends Player<Ba, Bo>> {
    private final List<P> players;

    public Team(List<P> players) {
        this.players = players;
    }

    public Batsmen<Ba> newBatsmen() {
        return new Batsmen<>(players.stream().map(x -> x.newBatsman()).collect(Collectors.toList()));
    }

    public Bowlers<Bo> newBowlers() {
        return new Bowlers<>(players.stream().map(x -> x.newBowler()).collect(Collectors.toList()));
    }
}
