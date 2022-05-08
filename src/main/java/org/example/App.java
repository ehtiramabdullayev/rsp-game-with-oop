package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.factory.GameStrategyCreatorFactory;
import org.example.game.Player;
import org.example.game.impl.ComputerPlayerImpl;
import org.example.game.impl.HumanPlayerImpl;
import org.example.strategy.GameStrategy;
import org.example.types.ChoiceType;
import org.example.types.ResultType;

import java.util.Random;
import java.util.Scanner;

import static org.example.types.Constants.*;

/**
 * Hello world!
 */
public class App {
    private static final Logger logger = LogManager.getLogger(App.class);
    private static final Scanner keyboard = new Scanner(System.in);
    private static final GameStrategyCreatorFactory factory = new GameStrategyCreatorFactory();

    public static Player computerChoice() {
        return new ComputerPlayerImpl(new Random());
    }

    public static Player userChoice() {
        logger.info(ENTER_YOUR_CHOICE_TEXT);
        String move = keyboard.next();
        ChoiceType choice = ChoiceType.fromString(move);
        GameStrategy gameStrategy = factory.getGameStrategy(choice);
        return new HumanPlayerImpl(gameStrategy);
    }


    public static void main(String[] args) {
        logger.info(ROUND_ASKING_TEXT);
        try {
            int numberOfRounds = keyboard.nextInt();
            logger.info(String.format(NUMBER_OF_ROUNDS_TEXT, numberOfRounds));
            logger.info("-------------------");
            while (numberOfRounds != 0) {
                Player player = userChoice();
                Player computerPlayer = computerChoice();
                ResultType resultType = player.playAgainst(computerPlayer);
                logger.info(resultType + "\n");
                numberOfRounds--;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

}



