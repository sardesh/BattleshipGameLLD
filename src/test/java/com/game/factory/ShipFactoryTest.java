package com.game.factory;

import com.game.entity.CoordinatePair;
import com.game.entity.Ship;
import com.game.validation.ShipPositionValidator;
import com.game.exception.OutOfAreaException;
import com.game.exception.PositionOverlapException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShipFactoryTest {

    @Test
    void testCreateShipValidPosition() throws OutOfAreaException, PositionOverlapException {
        List<CoordinatePair> occupied = Arrays.asList(new CoordinatePair(2, 2), new CoordinatePair(3, 3));
        ShipPositionValidator validator = new ShipPositionValidator(occupied);

        Ship ship = ShipFactory.createShip("Battleship", 2, 0, 0, 5, validator);

        assertNotNull(ship);
        assertEquals("Battleship", ship.getName());
        assertEquals(new CoordinatePair(0, 0), ship.getTopLeft());
        assertEquals(new CoordinatePair(1, -1), ship.getBottomRight());
    }

    @Test
    void testCreateShipOutOfBounds() {
        List<CoordinatePair> occupied = Arrays.asList(new CoordinatePair(2, 2), new CoordinatePair(3, 3));
        ShipPositionValidator validator = new ShipPositionValidator(occupied);

        assertThrows(OutOfAreaException.class, () -> ShipFactory.createShip("Battleship", 3, 4, 4, 5, validator));
    }

    @Test
    void testCreateShipOverlappingPosition() {
        List<CoordinatePair> occupied = Arrays.asList(new CoordinatePair(2, 2), new CoordinatePair(3, 3));
        ShipPositionValidator validator = new ShipPositionValidator(occupied);

        assertThrows(PositionOverlapException.class, () -> ShipFactory.createShip("Battleship", 2, 2, 2, 5, validator));
    }
}