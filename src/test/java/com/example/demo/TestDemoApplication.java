package com.example.demo;

import com.game.BattleShipGameApplication;
import org.springframework.boot.SpringApplication;

public class TestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.from(BattleShipGameApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
