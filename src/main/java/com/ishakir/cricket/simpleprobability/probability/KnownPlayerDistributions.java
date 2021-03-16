package com.ishakir.cricket.simpleprobability.probability;

import com.ishakir.cricket.simpleprobability.game.SimpleBallResult;

import java.util.HashMap;

/**
 * Created by imran on 07/02/16.
 */
public class KnownPlayerDistributions {

    private static SimpleBallResult dot = new SimpleBallResult(0, false);
    private static SimpleBallResult one = new SimpleBallResult(1, false);
    private static SimpleBallResult two = new SimpleBallResult(2, false);
    private static SimpleBallResult three = new SimpleBallResult(3, false);
    private static SimpleBallResult four = new SimpleBallResult(4, false);
    private static SimpleBallResult six = new SimpleBallResult(6, false);
    private static SimpleBallResult out = new SimpleBallResult(0, true);

    public static FiniteProbabilityDistribution<SimpleBallResult> andrewStrauss() {
        return new FiniteProbabilityDistribution<>(new HashMap<SimpleBallResult, Integer>() {{
            put(dot, 10500);
            put(one, 2200);
            put(two, 600);
            put(three, 36);

            put(four, 867);
            put(six, 10);
            put(out, 172);
        }});
    }

    public static FiniteProbabilityDistribution<SimpleBallResult> alastairCook() {
        return new FiniteProbabilityDistribution<>(new HashMap<SimpleBallResult, Integer>() {{
            put(dot, 16665);
            put(one, 3700);
            put(two, 800);
            put(three, 20);

            put(four, 1140);
            put(six, 10);
            put(out, 214);
        }});
    }

    public static FiniteProbabilityDistribution<SimpleBallResult> nickCompton() {
        return new FiniteProbabilityDistribution<>(new HashMap<SimpleBallResult, Integer>() {{
            put(dot, 1640);
            put(one, 190);
            put(two, 86);
            put(three, 10);

            put(four, 77);
            put(six, 3);
            put(out, 23);
        }});
    }

    public static FiniteProbabilityDistribution<SimpleBallResult> joeRoot() {
        return new FiniteProbabilityDistribution<>(new HashMap<SimpleBallResult, Integer>() {{
            put(dot, 4520);
            put(one, 1019);
            put(two, 350);
            put(three, 20);

            put(four, 378);
            put(six, 14);
            put(out, 62);
        }});
    }

    public static FiniteProbabilityDistribution<SimpleBallResult> jamesTaylor() {
        return new FiniteProbabilityDistribution<>(new HashMap<SimpleBallResult, Integer>() {{
            put(dot, 527);
            put(one, 120);
            put(two, 15);
            put(three, 5);

            put(four, 32);
            put(six, 2);
            put(out, 12);
        }});
    }

    public static FiniteProbabilityDistribution<SimpleBallResult> benStokes() {
        return new FiniteProbabilityDistribution<>(new HashMap<SimpleBallResult, Integer>() {{
            put(dot, 1335);
            put(one, 260);
            put(two, 100);
            put(three, 5);

            put(four, 189);
            put(six, 25);
            put(out, 41);
        }});
    }

    public static FiniteProbabilityDistribution<SimpleBallResult> johnnyBairstow() {
        return new FiniteProbabilityDistribution<>(new HashMap<SimpleBallResult, Integer>() {{
            put(dot, 1633);
            put(one, 335);
            put(two, 100);
            put(three, 0);

            put(four, 148);
            put(six, 12);
            put(out, 37);
        }});
    }

    public static FiniteProbabilityDistribution<SimpleBallResult> moeenAli() {
        return new FiniteProbabilityDistribution<>(new HashMap<SimpleBallResult, Integer>() {{
            put(dot, 1545);
            put(one, 210);
            put(two, 60);
            put(three, 10);

            put(four, 140);
            put(six, 5);
            put(out, 34);
        }});
    }

    public static FiniteProbabilityDistribution<SimpleBallResult> chrisWoakes() {
        return new FiniteProbabilityDistribution<>(new HashMap<SimpleBallResult, Integer>() {{
            put(dot, 141);
            put(one, 40);
            put(two, 8);
            put(three, 0);

            put(four, 17);
            put(six, 0);
            put(out, 6);
        }});
    }

    public static FiniteProbabilityDistribution<SimpleBallResult> stuartBroad() {
        return new FiniteProbabilityDistribution<>(new HashMap<SimpleBallResult, Integer>() {{
            put(dot, 2410);
            put(one, 850);
            put(two, 115);
            put(three, 10);

            put(four, 325);
            put(six, 29);
            put(out, 112);
        }});
    }

    public static FiniteProbabilityDistribution<SimpleBallResult> jimmyAnderson() {
        return new FiniteProbabilityDistribution<>(new HashMap<SimpleBallResult, Integer>() {{
            put(dot, 1997);
            put(one, 238);
            put(two, 112);
            put(three, 5);

            put(four, 140);
            put(six, 2);
            put(out, 100);
        }});
    }

    public static FiniteProbabilityDistribution<SimpleBallResult> deanElgar() {
        return new FiniteProbabilityDistribution<>(new HashMap<SimpleBallResult, Integer>() {{
            put(dot, 2035);
            put(one, 475);
            put(two, 65);
            put(three, 6);

            put(four, 138);
            put(six, 13);
            put(out, 34);
        }});
    }

    public static FiniteProbabilityDistribution<SimpleBallResult> stiaanVanZyl() {
        return new FiniteProbabilityDistribution<>(new HashMap<SimpleBallResult, Integer>() {{
            put(dot, 468);
            put(one, 90);
            put(two, 20);
            put(three, 1);

            put(four, 54);
            put(six, 0);
            put(out, 13);
        }});
    }

    public static FiniteProbabilityDistribution<SimpleBallResult> hashimAmla() {
        return new FiniteProbabilityDistribution<>(new HashMap<SimpleBallResult, Integer>() {{
            put(dot, 10338);
            put(one, 2950);
            put(two, 330);
            put(three, 20);

            put(four, 910);
            put(six, 8);
            put(out, 143);
        }});
    }

    public static FiniteProbabilityDistribution<SimpleBallResult> abDeVilliers() {
        return new FiniteProbabilityDistribution<>(new HashMap<SimpleBallResult, Integer>() {{
            put(dot, 10322);
            put(one, 3090);
            put(two, 450);
            put(three, 10);

            put(four, 933);
            put(six, 57);
            put(out, 160);
        }});
    }

    public static FiniteProbabilityDistribution<SimpleBallResult> fafDuPlessis() {
        return new FiniteProbabilityDistribution<>(new HashMap<SimpleBallResult, Integer>() {{
            put(dot, 3240);
            put(one, 650);
            put(two, 97);
            put(three, 10);

            put(four, 191);
            put(six, 9);
            put(out, 41);
        }});
    }

    public static FiniteProbabilityDistribution<SimpleBallResult> tembaBavuma() {
        return new FiniteProbabilityDistribution<>(new HashMap<SimpleBallResult, Integer>() {{
            put(dot, 584);
            put(one, 144);
            put(two, 10);
            put(three, 1);

            put(four, 50);
            put(six, 2);
            put(out, 10);
        }});
    }

    public static FiniteProbabilityDistribution<SimpleBallResult> jpDuminy() {
        return new FiniteProbabilityDistribution<>(new HashMap<SimpleBallResult, Integer>() {{
            put(dot, 2475);
            put(one, 570);
            put(two, 60);
            put(three, 10);

            put(four, 156);
            put(six, 11);
            put(out, 44);
        }});
    }

    public static FiniteProbabilityDistribution<SimpleBallResult> kyleAbbott() {
        return new FiniteProbabilityDistribution<>(new HashMap<SimpleBallResult, Integer>() {{
            put(dot, 225);
            put(one, 14);
            put(two, 5);
            put(three, 1);

            put(four, 7);
            put(six, 1);
            put(out, 9);
        }});
    }

    public static FiniteProbabilityDistribution<SimpleBallResult> daleSteyn() {
        return new FiniteProbabilityDistribution<>(new HashMap<SimpleBallResult, Integer>() {{
            put(dot, 1955);
            put(one, 400);
            put(two, 41);
            put(three, 5);

            put(four, 114);
            put(six, 32);
            put(out, 81);
        }});
    }

    public static FiniteProbabilityDistribution<SimpleBallResult> danePiedt() {
        return new FiniteProbabilityDistribution<>(new HashMap<SimpleBallResult, Integer>() {{
            put(dot, 159);
            put(one, 28);
            put(two, 2);
            put(three, 1);

            put(four, 1);
            put(six, 0);
            put(out, 6);
        }});
    }

    public static FiniteProbabilityDistribution<SimpleBallResult> morneMorkel() {
        return new FiniteProbabilityDistribution<>(new HashMap<SimpleBallResult, Integer>() {{
            put(dot, 1133);
            put(one, 225);
            put(two, 30);
            put(three, 3);

            put(four, 117);
            put(six, 2);
            put(out, 67);
        }});
    }

}
