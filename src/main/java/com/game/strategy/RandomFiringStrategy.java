package com.game.strategy;

import com.game.entity.CoordinatePair;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomFiringStrategy implements FiringStrategy {
    final private int firingRange;
    final private int minX;
    final private int maxX;
    final private Set<CoordinatePair> firedCoordinates = new HashSet<>();
    final private Random random = new Random();


    public RandomFiringStrategy(int firingRange, int minX, int maxS) {
        this.firingRange = firingRange;
        this.minX = minX;
        this.maxX = maxS;
    }

    @Override
    public CoordinatePair fire() {
        int x = random.nextInt(maxX-minX) + minX;
        int y = random.nextInt(firingRange);
        CoordinatePair coordinatePair = new CoordinatePair(x, y);
        while (firedCoordinates.contains(coordinatePair)) {
            x = random.nextInt(firingRange);
            y = random.nextInt(firingRange);
            coordinatePair = new CoordinatePair(x, y);
        }
        firedCoordinates.add(coordinatePair);
        return coordinatePair;
    }
}
