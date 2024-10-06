package com.game;

import com.game.service.GameService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class BattleShipGameApplication {
    public static void main(String[] args) {
        GameService gameService = new GameService();
        gameService.initGame(6);
        gameService.addShip("SH1", 2, 1, 5, 4, 4);
        gameService.startGame();
    }
}
