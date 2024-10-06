package com.game.validation;

public class GameValidator {
    public static boolean isValidBattleFieldSize(int size) {
        //@TODO: Throw an exception if the size is not valid
        return size % 2 == 0;
    }
}
