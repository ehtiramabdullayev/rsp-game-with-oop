package org.example.factory;

import org.example.strategy.GameStrategy;
import org.example.strategy.impl.PaperStrategy;
import org.example.strategy.impl.RockStrategy;
import org.example.strategy.impl.ScissorsStrategy;
import org.example.types.ChoiceType;

import static org.example.types.Constants.STRATEGY_NOT_FOUND_TEXT;
public class GameStrategyCreatorFactory {
    private final GameStrategy rockStrategy = new RockStrategy();
    private final GameStrategy paperStrategy = new PaperStrategy();
    private final GameStrategy scissorsStrategy = new ScissorsStrategy();

    public GameStrategy getGameStrategy(ChoiceType choice) {
        switch (choice) {
            case ROCK:
                return rockStrategy;
            case PAPER:
                return paperStrategy;
            case SCISSORS:
                return scissorsStrategy;
        }
        throw new IllegalArgumentException(STRATEGY_NOT_FOUND_TEXT);
    }
}
