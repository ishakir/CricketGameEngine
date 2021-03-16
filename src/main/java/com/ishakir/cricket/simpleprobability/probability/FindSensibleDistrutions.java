package com.ishakir.cricket.simpleprobability.probability;

import com.ishakir.cricket.simpleprobability.game.SimpleBallResult;

import java.util.*;
import java.util.stream.Collectors;

public class FindSensibleDistrutions {

    public static void main(String[] args) {
        SimpleBallResult dot = new SimpleBallResult(0, false);
        SimpleBallResult one = new SimpleBallResult(1, false);
        SimpleBallResult two = new SimpleBallResult(2, false);
        SimpleBallResult three = new SimpleBallResult(3, false);
        SimpleBallResult four = new SimpleBallResult(4, false);
        SimpleBallResult six = new SimpleBallResult(6, false);
        SimpleBallResult out = new SimpleBallResult(0, true);

        exampleDistribution(new FiniteProbabilityDistribution<>(new HashMap<SimpleBallResult, Integer>() {{
            put(dot, 1091);
            put(one, 300);
            put(two, 0);
            put(three, 0);

            put(four, 117);
            put(six, 2);
            put(out, 67);
        }}), 72);
    }

    static void exampleDistribution(FiniteProbabilityDistribution<SimpleBallResult> d, int inningsMultipler) {
        int NO_SAMPLES = 10000;

        List<List<SimpleBallResult>> inningses = new ArrayList<>();

        for(int i = 0; i < NO_SAMPLES; i++) {
            boolean isOut = false;
            List<SimpleBallResult> innings = new ArrayList<>();
            while(!isOut) {
                SimpleBallResult result = d.draw();
                innings.add(result);
                isOut = result.isWicket();
            }
            inningses.add(innings);
        }

        // Min, max, spread, quartiles, quartile spread
        List<Integer> totals = inningses.stream().mapToInt(i -> i.stream().mapToInt(b -> b.getRuns()).sum()).boxed().collect(Collectors.toList());
        Collections.sort(totals);

        // Now examine the stats, average, strike rate, run distribution, spread, percentiles
        OptionalDouble average = totals.stream().mapToInt(i -> i).average();
        System.out.printf("Average is %.4f %n", average.getAsDouble());

        long noBalls = inningses.stream().flatMap(List::stream).count();;
        long totalRuns = inningses.stream().flatMap(List::stream).mapToInt(b -> b.getRuns()).sum();
        float strikeRate = (((float) totalRuns) / ((float) noBalls)) * 100;
        System.out.printf("Strike Rate is %.4f %n", strikeRate);

        int min = totals.get(0);
        int tenthPercentile = totals.get(totals.size() / 10);
        int twentyFifthPercentile = totals.get(totals.size() / 4);
        int median = totals.get(totals.size() / 2);
        int seventyFifthPercentile = totals.get(3 * totals.size() / 4);
        int nintiethPercentile = totals.get(9 * totals.size() / 10);
        int max = totals.get(totals.size() - 1);

        System.out.printf("Min score: %d %n", min);
        System.out.printf("10th Pct: %d %n", tenthPercentile);
        System.out.printf("25th Pct: %d %n", twentyFifthPercentile);
        System.out.printf("Median: %d %n", median);
        System.out.printf("75th Pct: %d %n", seventyFifthPercentile);
        System.out.printf("90th Pct: %d %n", nintiethPercentile);
        System.out.printf("Max score: %d %n", max);

        long noFifties = totals.stream().filter(i -> i >= 50).count();
        long noHundreds = totals.stream().filter(i -> i >= 100).count();

        System.out.printf("Fifties: %d %n", Math.round((((float) noFifties) / NO_SAMPLES) * inningsMultipler));
        System.out.printf("Hundreds: %d %n", Math.round((((float) noHundreds) / NO_SAMPLES) * inningsMultipler));
    }
}
