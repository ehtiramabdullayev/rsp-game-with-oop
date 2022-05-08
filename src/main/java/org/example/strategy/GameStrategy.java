package org.example.strategy;

import org.example.strategy.impl.PaperStrategy;
import org.example.strategy.impl.RockStrategy;
import org.example.strategy.impl.ScissorsStrategy;
import org.example.types.ResultType;

public interface GameStrategy {
    ResultType play(GameStrategy opponentStrategy);

    ResultType getResult(RockStrategy rockStrategy);

    ResultType getResult(PaperStrategy paperStrategy);

    ResultType getResult(ScissorsStrategy scissorStrategy);
}
