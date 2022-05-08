package org.example.game;

import org.example.strategy.GameStrategy;
import org.example.types.ResultType;

public interface Player {
    ResultType playAgainst(Player opponent);
    GameStrategy getStrategy();

}
