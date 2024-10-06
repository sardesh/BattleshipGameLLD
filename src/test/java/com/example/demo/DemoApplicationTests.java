package com.example.demo;

import com.game.BattleShipGameApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(classes = BattleShipGameApplication.class)
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

}
