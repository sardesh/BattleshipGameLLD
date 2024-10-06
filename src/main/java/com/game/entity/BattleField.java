package com.game.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BattleField {
    private int size;
    private List<Player> players = new ArrayList<>();

    public BattleField(int size) {
        this.size = size;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void viewBattleField() {
        String[][] board = new String[size][size];
        players.forEach(player -> {
            player.getShipFleet().forEach(ship -> {
                for (int i = ship.getTopLeft().getX(); i < ship.getBottomRight().getX(); i++) {
                    for (int j = ship.getTopLeft().getY(); j > ship.getBottomRight().getY(); j--) {
                        board[j][i] = ship.isDestroyed() ? "\u001B[9m"+ ship.getName() +"\u001B[0m" : ship.getName();
                    }
                }
            });
        });
        for (String[] strings : board) {
            for (String string : strings) {
                if(string != null) {
                    System.out.print(" | " + string);
                } else {
                    System.out.print(" | -----");
                }
            }
            System.out.println("");
        }
    }
}
