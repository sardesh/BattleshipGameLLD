package com.game.entity;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Ship {
    private String name;
    private CoordinatePair topLeft;
    private CoordinatePair bottomRight;
    private boolean destroyed = false;
    private int size;

    public boolean isHit(CoordinatePair firedAt) {
        return topLeft.getX() <= firedAt.getX() && bottomRight.getX() >= firedAt.getX()
            && topLeft.getY() >= firedAt.getY() && bottomRight.getY() <= firedAt.getY();
    }
}
