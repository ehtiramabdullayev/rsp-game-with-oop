package org.example.strategy.impl;

import org.example.types.ResultType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PaperStrategyTest {

    private final PaperStrategy paperStrategy;

    public PaperStrategyTest() {
        paperStrategy = new PaperStrategy();
    }

    @Test
    public void testPaperStrategyAgainstPaperStrategy() {
        ResultType resultType = paperStrategy.play(new PaperStrategy());
        assertNotNull(resultType);
        assertEquals(ResultType.DRAW, resultType);
    }
    @Test
    public void testPaperStrategyAgainstRockStrategy() {
        ResultType resultType = paperStrategy.play(new RockStrategy());
        assertNotNull(resultType);
        assertEquals(ResultType.WIN, resultType);
    }
    @Test
    public void testPaperStrategyAgainstScissorsStrategy() {
        ResultType resultType = paperStrategy.play(new ScissorsStrategy());
        assertNotNull(resultType);
        assertEquals(ResultType.LOSS, resultType);
    }
}
