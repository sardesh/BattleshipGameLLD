package com.game.validation;

import com.game.entity.Player;
import com.game.entity.Ship;

import java.util.List;

public class ShipPositionValidator {
    public static void validatePositionOverlap(Ship ship, List<Ship> existingShip) {
        for (Ship existingShip1 : existingShip) {
            if (ship.getTopLeft().getX() >= existingShip1.getTopLeft().getX()
            && ship.getTopLeft().getX() < existingShip1.getBottomRight().getX()
            && ship.getTopLeft().getY() >= existingShip1.getTopLeft().getY()
            && ship.getTopLeft().getY() < existingShip1.getBottomRight().getY()) {
                System.out.println("Ship already exists in given position!");
                //@TODO: throw exception PositionOverlapException
            }
        }
    }

    public static void validateOutOfArea(Ship ship, Player player) {
        if (
            ship.getTopLeft().getX() < player.getMinX() && ship.getBottomRight().getX() > player.getMaxX()
                && ship.getTopLeft().getY() > player.getSize() && ship.getBottomRight().getY() < 0
        ) {
            System.out.println("Ship is out of area");
            //@TODO: throw exception OutOfAreaException
        }
    }
}
