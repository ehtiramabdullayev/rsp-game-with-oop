package org.example.strategy.impl;

import org.example.types.ResultType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ScissorsStrategyTest {
    private final ScissorsStrategy scissorsStrategy;

    public ScissorsStrategyTest() {
        scissorsStrategy = new ScissorsStrategy();
    }

    @Test
    public void testScissorsStrategyAgainstPaperStrategy() {
        ResultType resultType = scissorsStrategy.play(new PaperStrategy());
        assertNotNull(resultType);
        assertEquals(ResultType.WIN, resultType);
    }

    @Test
    public void testScissorsStrategyAgainstRockStrategy() {
        ResultType resultType = scissorsStrategy.play(new RockStrategy());
        assertNotNull(resultType);
        assertEquals(ResultType.LOSS, resultType);
    }

    @Test
    public void testScissorsStrategyAgainstScissorsStrategy() {
        ResultType resultType = scissorsStrategy.play(new ScissorsStrategy());
        assertNotNull(resultType);
        assertEquals(ResultType.DRAW, resultType);
    }
}