package com.game.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Game {
    private GameStatus gameStatus = GameStatus.NOT_STARTED;
    private BattleField battleField;
    private Player winner;
}
