package com.game.validation;

import com.game.entity.CoordinatePair;
import com.game.exception.OutOfAreaException;
import com.game.exception.PositionOverlapException;
import java.util.List;

public class ShipPositionValidator {

    private final List<CoordinatePair> occupiedCoordinates;

    public ShipPositionValidator(List<CoordinatePair> occupiedCoordinates) {
        this.occupiedCoordinates = occupiedCoordinates;
    }

    public void validatePosition(CoordinatePair topLeft, CoordinatePair bottomRight, int battlefieldSize) throws OutOfAreaException, PositionOverlapException {
        // Check if the ship is within battlefield bounds
        if (topLeft.getX() < 0 || topLeft.getY() < 0 || bottomRight.getX() >= battlefieldSize || bottomRight.getY() >= battlefieldSize) {
            throw new OutOfAreaException("Ship coordinates are out of battlefield bounds.");
        }

        // Check for overlap with existing ships
        for (CoordinatePair coordinate : occupiedCoordinates) {
            if (isOverlapping(topLeft, bottomRight, coordinate)) {
                throw new PositionOverlapException("Ship coordinates overlap with an existing ship.");
            }
        }
    }

    private boolean isOverlapping(CoordinatePair topLeft, CoordinatePair bottomRight, CoordinatePair coordinate) {
        return coordinate.getX() >= topLeft.getX() && coordinate.getX() <= bottomRight.getX() &&
               coordinate.getY() <= topLeft.getY() && coordinate.getY() >= bottomRight.getY();
    }
}