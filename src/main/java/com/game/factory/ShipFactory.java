package com.game.factory;

import com.game.entity.CoordinatePair;
import com.game.entity.Ship;
import com.game.validation.ShipPositionValidator;
import com.game.exception.OutOfAreaException;
import com.game.exception.PositionOverlapException;

public class ShipFactory {
    public static Ship createShip(String name, int size, int x, int y, int battlefieldSize, ShipPositionValidator validator) throws OutOfAreaException, PositionOverlapException {
        CoordinatePair topLeft = new CoordinatePair(x, y);
        CoordinatePair bottomRight = new CoordinatePair(x + size - 1, y - size + 1);

        // Validate the ship position
        validator.validatePosition(topLeft, bottomRight, battlefieldSize);

        return new Ship(name, topLeft, bottomRight, false, size);
    }
}