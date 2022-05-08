package org.example.factory;

import org.example.strategy.GameStrategy;
import org.example.strategy.impl.PaperStrategy;
import org.example.strategy.impl.RockStrategy;
import org.example.strategy.impl.ScissorsStrategy;
import org.example.types.ChoiceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameStrategyCreatorFactoryTest {

    @Test
    public void testRockStrategyWhenRockIsChosen() {
        GameStrategyCreatorFactory factory = new GameStrategyCreatorFactory();
        GameStrategy gameStrategy = factory.getGameStrategy(ChoiceType.ROCK);
        Assertions.assertInstanceOf(RockStrategy.class, gameStrategy);
    }

    @Test
    public void testPaperStrategyWhenPaperIsChosen() {
        GameStrategyCreatorFactory factory = new GameStrategyCreatorFactory();
        GameStrategy gameStrategy = factory.getGameStrategy(ChoiceType.PAPER);
        Assertions.assertInstanceOf(PaperStrategy.class, gameStrategy);
    }

    @Test
    public void testScissorsStrategyWhenScissorsIsChosen() {
        GameStrategyCreatorFactory factory = new GameStrategyCreatorFactory();
        GameStrategy gameStrategy = factory.getGameStrategy(ChoiceType.SCISSORS);
        Assertions.assertInstanceOf(ScissorsStrategy.class, gameStrategy);
    }
}