package com.ishakir.cricket.engine.innings;

import com.ishakir.cricket.engine.players.Batsman;

import java.util.List;

/*
Todo: Perhaps a lot of this could be abstracted out into a listener, this isn't the only thing
      that might want to listen to these kind of events!
 */
public class Batsmen<Ba extends Batsman> {
    private List<Ba> batsmen;

    private int onStrike;
    private int offStrike;

    public Batsmen(List<Ba> batsmen) {
        this.batsmen = batsmen;

        this.onStrike = 0;
        this.offStrike = 1;
    }

    public Ba getOnStrike() {
        return batsmen.get(onStrike);
    }

    public Ba getOffStrike() {
        return batsmen.get(offStrike);
    }

    public void runs(int runs) {
        if(runs % 2 != 0) {
            invert();
        }
    }

    public void endOfOver() {
        invert();
    }

    public void onStrikeOut() {
        onStrike = nextIn();
    }

    public boolean areAllOut() {
        return onStrike >= batsmen.size() || offStrike >= batsmen.size();
    }

    private int nextIn() {
        return Math.max(onStrike, offStrike) + 1;
    }

    public List<Ba> getAll() {
        return batsmen;
    }

    private void invert() {
        int temp = onStrike;
        onStrike = offStrike;
        offStrike = temp;
    }
}
