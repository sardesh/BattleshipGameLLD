package com.game.factory;

import com.game.entity.CoordinatePair;
import com.game.entity.Ship;

public class ShipFactory {
    public static Ship createShip(String name, int size, int x, int y) {
        CoordinatePair topLeft = new CoordinatePair(x, y);
        CoordinatePair bottomRight = new CoordinatePair(x + size, y - size);
        return new Ship(name, topLeft, bottomRight, false, size);
    }
}
