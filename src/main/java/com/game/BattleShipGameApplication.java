package com.game;

import com.game.service.GameService;

public class BattleShipGameApplication {
    public static void main(String[] args) {
        GameService gameService = new GameService();
        gameService.initGame(6);
        gameService.addShip("SH1", 2, 1, 5, 4, 4);
        gameService.viewBattleField();
        gameService.startGame();
        gameService.viewBattleField();
    }
}
