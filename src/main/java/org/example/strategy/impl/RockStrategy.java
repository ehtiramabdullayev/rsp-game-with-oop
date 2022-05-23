package org.example.strategy.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.strategy.GameStrategy;
import org.example.types.ResultType;
import static org.example.types.Constants.*;

public class RockStrategy implements GameStrategy {

    private static final Logger logger = LogManager.getLogger(PaperStrategy.class);

    @Override
    public ResultType play(GameStrategy opponentStrategy) {
        return opponentStrategy.getResult(this);
    }

    @Override
    public ResultType getResult(RockStrategy rockStrategy) {
        logger.info(String.format(DRAWS_WITH_TEXT, rockStrategy, this));
        return ResultType.DRAW;
    }

    @Override
    public ResultType getResult(PaperStrategy paperStrategy) {
        logger.info(String.format(WINS_AGAINST_TEXT, paperStrategy, this));
        return ResultType.WIN;
    }

    @Override
    public ResultType getResult(ScissorsStrategy scissorStrategy) {
        logger.info(String.format(LOSES_TO_EXISTS_TEXT, scissorStrategy, this));
        return ResultType.LOSS;
    }

    @Override
    public String toString() {
        return ROCK;
    }
}
