package com.ishakir.cricket.simpleprobability.game;

import com.ishakir.cricket.engine.innings.BatsmanInnings;
import com.ishakir.cricket.engine.innings.Innings;
import com.ishakir.cricket.engine.innings.TimelessInningsFactory;
import com.ishakir.cricket.engine.match.FixedNumberOfInningsMatch;
import com.ishakir.cricket.engine.match.Match;
import com.ishakir.cricket.engine.over.Over;
import com.ishakir.cricket.engine.over.StandardSixBallOverFactory;
import com.ishakir.cricket.engine.players.Team;
import com.ishakir.cricket.simpleprobability.probability.KnownPlayerDistributions;

import java.util.Arrays;

/**
 * Created by imran on 07/02/16.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Team<SPBatsman, MockBowler, SPPlayer> england = new Team<>(Arrays.asList(
                new SPPlayer("Andrew Strauss", KnownPlayerDistributions.andrewStrauss()),
                new SPPlayer("Alastair Cook", KnownPlayerDistributions.alastairCook()),
                new SPPlayer("Nick Compton", KnownPlayerDistributions.nickCompton()),
                new SPPlayer("Joe Root", KnownPlayerDistributions.joeRoot()),
                new SPPlayer("James Taylor", KnownPlayerDistributions.jamesTaylor()),
                new SPPlayer("Ben Stokes", KnownPlayerDistributions.benStokes()),
                new SPPlayer("Johnny Bairstow", KnownPlayerDistributions.johnnyBairstow()),
                new SPPlayer("Moeen Ali", KnownPlayerDistributions.moeenAli()),
                new SPPlayer("Chris Woakes", KnownPlayerDistributions.chrisWoakes()),
                new SPPlayer("Stuart Broad", KnownPlayerDistributions.stuartBroad()),
                new SPPlayer("Jimmy Anderson", KnownPlayerDistributions.jimmyAnderson())
        ));

        Team<SPBatsman, MockBowler, SPPlayer> southAfrica = new Team<>(Arrays.asList(
                new SPPlayer("Dean Elgar", KnownPlayerDistributions.deanElgar()),
                new SPPlayer("Stiaan Van Zyl", KnownPlayerDistributions.stiaanVanZyl()),
                new SPPlayer("Hashim Amla", KnownPlayerDistributions.hashimAmla()),
                new SPPlayer("AB De Villiers", KnownPlayerDistributions.abDeVilliers()),
                new SPPlayer("Faf Du Plessis", KnownPlayerDistributions.fafDuPlessis()),
                new SPPlayer("Temba Bavuma", KnownPlayerDistributions.tembaBavuma()),
                new SPPlayer("JP Duminy", KnownPlayerDistributions.jpDuminy()),
                new SPPlayer("Kyle Abbott", KnownPlayerDistributions.kyleAbbott()),
                new SPPlayer("Dale Steyn", KnownPlayerDistributions.daleSteyn()),
                new SPPlayer("Dane Piedt", KnownPlayerDistributions.danePiedt()),
                new SPPlayer("Morne Morkel", KnownPlayerDistributions.morneMorkel())
        ));

        Match m = new FixedNumberOfInningsMatch<SPBatsman, MockBowler, SPBall, SPPlayer>(england, southAfrica, 2, new TimelessInningsFactory<>(new StandardSixBallOverFactory<>(new SPBallFactory()))) {
            @Override
            public Team<SPBatsman, MockBowler, SPPlayer> teamBattingFirstInternal(Team<SPBatsman, MockBowler, SPPlayer> teamA, Team<SPBatsman, MockBowler, SPPlayer> teamB) {
                return teamA;
            }
        };

        Innings<SPBatsman, MockBowler, SPBall, SPPlayer> eng1 = m.currentInningsOrCreateNext();
        while(!eng1.isComplete()) {
            System.out.printf("%s on strike:%n", eng1.getOnStrikeBatsman().getName());
            Over<SPBatsman, MockBowler, SPBall> o = m.completeCurrentOverOrNextOver();
            for(SPBall b: o.getBalls()) {
                System.out.print(b);
                System.out.print(" ");
                Thread.sleep(1000);
            }
            System.out.println();
            BatsmanInnings<SPBatsman, MockBowler, SPBall> onStrike = eng1.batsman(eng1.getOnStrikeBatsman());
            BatsmanInnings<SPBatsman, MockBowler, SPBall> offStrike = eng1.batsman(eng1.getOffStrikeBatsman());
            System.out.printf("%s: %d (%d), %s: %d (%d)%n", onStrike.getBatsman().getName(), onStrike.runs(), onStrike.numberOfBalls(), offStrike.getBatsman().getName(), offStrike.runs(), offStrike.numberOfBalls());
            System.out.printf("England are %d-%d from %d overs%n", eng1.runs(), eng1.wickets(), eng1.getOvers().size() - 1);
            System.out.println();
            Thread.sleep(1000);
        }

        System.out.println("End of England 1st Innings - Full Scorecard");
        for(BatsmanInnings<SPBatsman, MockBowler, SPBall> in: eng1.batsmen()) {
            System.out.printf("%s: %s %d (%d)%n", in.getBatsman().getName(), in.wasOut() ? in.wicket().get().toString() : "not out", in.runs(), in.numberOfBalls());
        }
        System.out.printf("%d-%d (%d overs)%n", eng1.runs(), eng1.wickets(), eng1.getOvers().size());

        Innings<SPBatsman, MockBowler, SPBall, SPPlayer> sa1 = m.currentInningsOrCreateNext();
        while(!sa1.isComplete()) {
            System.out.printf("%s on strike:%n", sa1.getOnStrikeBatsman().getName());
            Over<SPBatsman, MockBowler, SPBall> o = m.completeCurrentOverOrNextOver();
            for(SPBall b: o.getBalls()) {
                System.out.print(b);
                System.out.print(" ");
                Thread.sleep(1000);
            }
            System.out.println();
            BatsmanInnings<SPBatsman, MockBowler, SPBall> onStrike = sa1.batsman(sa1.getOnStrikeBatsman());
            BatsmanInnings<SPBatsman, MockBowler, SPBall> offStrike = sa1.batsman(sa1.getOffStrikeBatsman());
            System.out.printf("%s: %d (%d), %s: %d (%d)%n", onStrike.getBatsman().getName(), onStrike.runs(), onStrike.numberOfBalls(), offStrike.getBatsman().getName(), offStrike.runs(), offStrike.numberOfBalls());
            System.out.printf("South Africa are %d-%d from %d overs (%s by %d)%n", sa1.runs(), sa1.wickets(), sa1.getOvers().size() - 1, sa1.runs() > eng1.runs() ? "lead" : "trail", Math.abs(sa1.runs() - eng1.runs()));
            System.out.println();
            Thread.sleep(1000);
        }

        System.out.println("End of South Africa 1st Innings - Full Scorecard");
        for(BatsmanInnings<SPBatsman, MockBowler, SPBall> in: sa1.batsmen()) {
            System.out.printf("%s: %s %d (%d)%n", in.getBatsman().getName(), in.wasOut() ? in.wicket().get().toString() : "not out", in.runs(), in.numberOfBalls());
        }
        System.out.printf("%d-%d (%d overs)%n", sa1.runs(), sa1.wickets(), sa1.getOvers().size());

        Innings<SPBatsman, MockBowler, SPBall, SPPlayer> eng2 = m.currentInningsOrCreateNext();
        while(!eng2.isComplete()) {
            System.out.printf("%s on strike:%n", eng2.getOnStrikeBatsman().getName());
            Over<SPBatsman, MockBowler, SPBall> o = m.completeCurrentOverOrNextOver();
            for(SPBall b: o.getBalls()) {
                System.out.print(b);
                System.out.print(" ");
                Thread.sleep(1000);
            }
            System.out.println();
            BatsmanInnings<SPBatsman, MockBowler, SPBall> onStrike = eng2.batsman(eng2.getOnStrikeBatsman());
            BatsmanInnings<SPBatsman, MockBowler, SPBall> offStrike = eng2.batsman(eng2.getOffStrikeBatsman());
            System.out.printf("%s: %d (%d), %s: %d (%d)%n", onStrike.getBatsman().getName(), onStrike.runs(), onStrike.numberOfBalls(), offStrike.getBatsman().getName(), offStrike.runs(), offStrike.numberOfBalls());
            System.out.printf("England are %d-%d from %d overs (%s by %d)%n", eng2.runs(), eng2.wickets(), eng2.getOvers().size() - 1, eng1.runs() + eng2.runs() > sa1.runs() ? "lead" : "trail", Math.abs(eng1.runs() + eng2.runs() - sa1.runs()));
            System.out.println();
            Thread.sleep(1000);
        }

        System.out.println("End of England 2nd Innings - Full Scorecard");
        for(BatsmanInnings<SPBatsman, MockBowler, SPBall> in: eng2.batsmen()) {
            System.out.printf("%s: %s %d (%d)%n", in.getBatsman().getName(), in.wasOut() ? in.wicket().get().toString() : "not out", in.runs(), in.numberOfBalls());
        }
        System.out.printf("%d-%d (%d overs)%n", eng2.runs(), eng2.wickets(), eng2.getOvers().size());

        if(eng1.runs() + eng2.runs() < sa1.runs()) {
            System.out.printf("South Africa win by an innings and %d runs", sa1.runs() - (eng1.runs() + eng2.runs()));
        } else {
            Innings<SPBatsman, MockBowler, SPBall, SPPlayer> sa2 = m.currentInningsOrCreateNext();
            while(!sa2.isComplete() && (sa1.runs() + sa2.runs()) <= (eng1.runs() + eng2.runs())) {
                System.out.printf("%s on strike:%n", sa2.getOnStrikeBatsman().getName());
                Over<SPBatsman, MockBowler, SPBall> o = m.completeCurrentOverOrNextOver();
                for(SPBall b: o.getBalls()) {
                    System.out.print(b);
                    System.out.print(" ");
                    Thread.sleep(1000);
                }
                System.out.println();
                BatsmanInnings<SPBatsman, MockBowler, SPBall> onStrike = sa2.batsman(sa2.getOnStrikeBatsman());
                BatsmanInnings<SPBatsman, MockBowler, SPBall> offStrike = sa2.batsman(sa2.getOffStrikeBatsman());
                System.out.printf("%s: %d (%d), %s: %d (%d)%n", onStrike.getBatsman().getName(), onStrike.runs(), onStrike.numberOfBalls(), offStrike.getBatsman().getName(), offStrike.runs(), offStrike.numberOfBalls());
                System.out.printf("South Africa are %d-%d from %d overs (%d required)%n", sa2.runs(), sa2.wickets(), sa2.getOvers().size() - 1, eng1.runs() + eng2.runs() + 1 - (sa1.runs() + sa2.runs()));
                System.out.println();
                Thread.sleep(1000);
            }

            System.out.println("End of South Africa 2nd Innings - Full Scorecard");
            for(BatsmanInnings<SPBatsman, MockBowler, SPBall> in: sa2.batsmen()) {
                System.out.printf("%s: %s %d (%d)%n", in.getBatsman().getName(), in.wasOut() ? in.wicket().get().toString() : "not out", in.runs(), in.numberOfBalls());
            }
            System.out.printf("%d-%d (%d overs)%n", sa2.runs(), sa2.wickets(), sa2.getOvers().size());

            System.out.println();
            if((sa1.runs() + sa2.runs()) == (eng1.runs() + eng2.runs())) {
                System.out.println("Match tied!!!");
            } else if ((sa1.runs() + sa2.runs()) > (eng1.runs() + eng2.runs())) {
                System.out.printf("South Africa win by %d wickets%n", 10 - sa2.wickets());
            } else {
                System.out.printf("England win by %d runs%n", (eng1.runs() + eng2.runs()) - (sa2.runs() + sa1.runs()));
            }
        }

    }

}
