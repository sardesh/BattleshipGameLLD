package com.game.service;

import com.game.entity.*;
import com.game.factory.ShipFactory;
import com.game.strategy.RandomFiringStrategy;
import com.game.validation.ShipPositionValidator;

//@TODO: Implement state design pattern to manage game states
public class GameService {
    private Game game;

    public void initGame(int size) {
        this.game = new Game();
        game.setBattleField(new BattleField(size));
        game.getBattleField().addPlayer(new Player("PlayerA", new RandomFiringStrategy(size, size/2, size), 0, size/2, size));
        game.getBattleField().addPlayer(new Player("PlayerB", new RandomFiringStrategy(size, 0, size/2), size/2, size, size));
        game.setGameStatus(GameStatus.INITIATED);
    }

    public void startGame() {
        if (game.getGameStatus().equals(GameStatus.STARTED)) {
            System.out.println("Game is already started");
        }
        game.setGameStatus(GameStatus.STARTED);
        int playerTurn = 0;
        Player attacker = null;
        Player defender;
        while (game.getBattleField().getPlayers().get(0).remainingShips() > 0 && game.getBattleField().getPlayers().get(1).remainingShips() > 0) {
            attacker = game.getBattleField().getPlayers().get(playerTurn);
            defender = game.getBattleField().getPlayers().get(playerTurn^1);
            CoordinatePair firedCoordinate = attacker.fire();

            Ship destroyedShip = null;
            for (Ship ship: defender.getShipFleet()) {
                if(ship.isHit(firedCoordinate)) {
                    ship.setDestroyed(true);
                    destroyedShip = ship;
                    break;
                }
            }

            String common = attacker.getName()+"’s turn: Missile fired at (" +firedCoordinate.getX()+","+firedCoordinate.getY()+") ";
            String hitOrMiss = destroyedShip == null ? "Miss" : "Hit "+ defender.getName()+ "’s ship with id "+ destroyedShip.getName();
            System.out.println(common+hitOrMiss);
            playerTurn ^=1;
        }

        System.out.println(attacker.getName()+" wins the game");
        game.setWinner(attacker);
        game.setGameStatus(GameStatus.ENDED);
    }

    public void addShip(String id, int size, int xa, int ya, int xb, int yb) {
        Player playerA = game.getBattleField().getPlayers().get(0);
        Player playerB = game.getBattleField().getPlayers().get(1);
        Ship shipA = ShipFactory.createShip("A-"+id, size, xa, ya);
        Ship shipB = ShipFactory.createShip("B-"+id, size, xb, yb);

        ShipPositionValidator.validatePositionOverlap(shipA, playerA.getShipFleet());
        ShipPositionValidator.validatePositionOverlap(shipB, playerB.getShipFleet());
        ShipPositionValidator.validateOutOfArea(shipA, playerA);
        ShipPositionValidator.validateOutOfArea(shipB, playerB);

        playerA.addShip(shipA);
        playerB.addShip(shipB);
    }
}
