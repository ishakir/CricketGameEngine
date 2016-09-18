package com.ishakir.cricket.engine.innings;

import com.ishakir.cricket.engine.players.Bowler;

import java.util.List;

public class Bowlers<Bo extends Bowler> {
    private List<Bo> bowlers;

    private int current;
    private int next;

    public Bowlers(List<Bo> bowlers) {
        this.bowlers = bowlers;
        this.current = 0;
        this.next = 1;
    }

    public Bo getCurrent() { return bowlers.get(current); }

    public void endOfOver() {
        invert();
    }

    public List<Bo> getAll() {
        return bowlers;
    }

    private void invert() {
        int temp = current;
        current = next;
        next = current;
    }
}
