package com.game.entity;

import com.game.strategy.FiringStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Player {
    private String name;
    public List<Ship> shipFleet = new ArrayList<>();
    private FiringStrategy firingStrategy;
    int maxX;
    int minX;
    int size;

    public Player(String name, FiringStrategy firingStrategy, int minX, int maxX, int size) {
        this.name = name;
        this.firingStrategy = firingStrategy;
        this.maxX = maxX;
        this.minX = minX;
        this.size = size;
    }

    public void addShip(Ship ship) {
        shipFleet.add(ship);
    }

    public int remainingShips() {
        return (int) shipFleet.stream().filter(ship -> !ship.isDestroyed()).count();
    }

    public CoordinatePair fire() {
        return firingStrategy.fire();
    }
}
