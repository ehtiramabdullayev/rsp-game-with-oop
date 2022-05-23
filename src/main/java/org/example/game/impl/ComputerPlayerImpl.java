package org.example.game.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.game.Player;
import org.example.strategy.GameStrategy;
import org.example.strategy.impl.PaperStrategy;
import org.example.strategy.impl.RockStrategy;
import org.example.strategy.impl.ScissorsStrategy;
import org.example.types.ResultType;
import java.util.Random;
import static org.example.types.Constants.*;

public class ComputerPlayerImpl implements Player {
    private static final Logger logger = LogManager.getLogger(ComputerPlayerImpl.class);
    private final Random random;

    public ComputerPlayerImpl(Random random) {
        this.random = random;
    }

    @Override
    public GameStrategy getStrategy() {
        int randomValue =random.nextInt(3);
        switch (randomValue) {
            case 0:
                RockStrategy rockStrategy = new RockStrategy();
                logger.info(String.format(COMPUTER_CHOSE, rockStrategy));
                return rockStrategy;
            case 1:
                PaperStrategy paperStrategy = new PaperStrategy();
                logger.info(String.format(COMPUTER_CHOSE, paperStrategy));
                return paperStrategy;
            case 2:
                ScissorsStrategy scissorsStrategy = new ScissorsStrategy();
                logger.info(String.format(COMPUTER_CHOSE, scissorsStrategy));
                return scissorsStrategy;
            default:
                logger.error(STRATEGY_NOT_FOUND_TEXT);
                throw new IllegalStateException(NO_STRATEGY_FOUND_TEXT);
        }
    }

    @Override
    public ResultType playAgainst(Player opponent) {
        return getStrategy().play(opponent.getStrategy());
    }

}
