package com.game.validation;

import com.game.entity.CoordinatePair;
import com.game.exception.OutOfAreaException;
import com.game.exception.PositionOverlapException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShipPositionValidatorTest {

    @Test
    void testValidatePositionWithinBounds() {
        List<CoordinatePair> occupied = Arrays.asList(new CoordinatePair(2, 2), new CoordinatePair(3, 3));
        ShipPositionValidator validator = new ShipPositionValidator(occupied);

        assertDoesNotThrow(() -> validator.validatePosition(new CoordinatePair(0, 0), new CoordinatePair(1, -1), 5));
    }

    @Test
    void testValidatePositionOutOfBounds() {
        List<CoordinatePair> occupied = Arrays.asList(new CoordinatePair(2, 2), new CoordinatePair(3, 3));
        ShipPositionValidator validator = new ShipPositionValidator(occupied);

        assertThrows(OutOfAreaException.class, () -> validator.validatePosition(new CoordinatePair(4, 4), new CoordinatePair(6, 2), 5));
    }

    @Test
    void testValidatePositionOverlap() {
        List<CoordinatePair> occupied = Arrays.asList(new CoordinatePair(2, 2), new CoordinatePair(3, 3));
        ShipPositionValidator validator = new ShipPositionValidator(occupied);

        assertThrows(PositionOverlapException.class, () -> validator.validatePosition(new CoordinatePair(2, 2), new CoordinatePair(3, 1), 5));
    }
}