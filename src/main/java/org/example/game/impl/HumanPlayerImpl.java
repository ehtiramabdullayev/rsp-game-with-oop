package org.example.game.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.game.Player;
import org.example.strategy.GameStrategy;
import org.example.types.ResultType;
import static org.example.types.Constants.YOUR_CHOSE;

public class HumanPlayerImpl implements Player {
    private static final Logger logger = LogManager.getLogger(HumanPlayerImpl.class);
    private final GameStrategy strategy;

    public HumanPlayerImpl(GameStrategy strategy) {
        this.strategy = strategy;
        logger.info(String.format(YOUR_CHOSE, strategy.toString()));

    }

    @Override
    public ResultType playAgainst(Player opponent) {
        return strategy.play(opponent.getStrategy());
    }

    @Override
    public GameStrategy getStrategy() {
        return strategy;
    }
}
