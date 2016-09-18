package com.ishakir.cricket.simpleprobability.probability;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by imran on 07/02/16.
 */
public class FiniteProbabilityDistribution<E> {

    private List<E> distribution;
    private Random random;

    public FiniteProbabilityDistribution(Map<E, Integer> definingMap) {
        distribution = new ArrayList<>();
        for(Map.Entry<E, Integer> entry: definingMap.entrySet()) {
            distribution.addAll(listOfN(entry.getValue(), entry.getKey()));
        }
        random = new Random();
    }

    public E draw() {
        return distribution.get(random.nextInt(distribution.size()));
    }

    private List<E> listOfN(int number, E value) {
        List<E> list = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            list.add(value);
        }
        return list;
    }

}
