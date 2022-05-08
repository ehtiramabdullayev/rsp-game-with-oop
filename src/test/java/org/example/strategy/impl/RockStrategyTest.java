package org.example.strategy.impl;

import org.example.types.ResultType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RockStrategyTest {

    private final RockStrategy rockStrategy;

    public RockStrategyTest() {
        rockStrategy = new RockStrategy();
    }

    @Test
    public void testRockStrategyAgainstPaperStrategy() {
        ResultType resultType = rockStrategy.play(new PaperStrategy());
        assertNotNull(resultType);
        assertEquals(ResultType.LOSS, resultType);
    }

    @Test
    public void testRockStrategyAgainstRockStrategy() {
        ResultType resultType = rockStrategy.play(new RockStrategy());
        assertNotNull(resultType);
        assertEquals(ResultType.DRAW, resultType);
    }

    @Test
    public void testRockStrategyAgainstScissorsStrategy() {
        ResultType resultType = rockStrategy.play(new ScissorsStrategy());
        assertNotNull(resultType);
        assertEquals(ResultType.WIN, resultType);
    }

}