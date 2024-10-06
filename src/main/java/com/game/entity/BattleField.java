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
}
