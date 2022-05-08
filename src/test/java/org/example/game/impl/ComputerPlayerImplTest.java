package org.example.game.impl;


import org.example.strategy.GameStrategy;
import org.example.strategy.impl.PaperStrategy;
import org.example.strategy.impl.RockStrategy;
import org.example.strategy.impl.ScissorsStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

@ExtendWith(MockitoExtension.class)
public class ComputerPlayerImplTest {
    @InjectMocks
    ComputerPlayerImpl spyComputerPlayer;
    @Mock
    Random random;

    @Test
    public void testComputerPlayerPlayAgainstMethod() {
        spyComputerPlayer = Mockito.spy(spyComputerPlayer);
        ComputerPlayerImpl mockCompPlayer = Mockito.mock(ComputerPlayerImpl.class);
        GameStrategy rockMock = Mockito.mock(GameStrategy.class);
        GameStrategy rockMock2 = Mockito.mock(GameStrategy.class);

        Mockito.when(mockCompPlayer.getStrategy()).thenReturn(rockMock2);
        Mockito.doReturn(rockMock).when(spyComputerPlayer).getStrategy();

        spyComputerPlayer.playAgainst(mockCompPlayer);
        Mockito.verify(rockMock, Mockito.times(1)).play(Mockito.any());
    }

    @Test
    public void testGetStrategyReturnsRock() {
        Mockito.when(random.nextInt(3)).thenReturn(0);
        GameStrategy actualResult = spyComputerPlayer.getStrategy();
        Assertions.assertNotNull(actualResult);
        Assertions.assertInstanceOf(RockStrategy.class, actualResult);
    }

    @Test
    public void testGetStrategyReturnsPaper() {
        Mockito.when(random.nextInt(3)).thenReturn(1);
        GameStrategy actualResult = spyComputerPlayer.getStrategy();
        Assertions.assertNotNull(actualResult);
        Assertions.assertInstanceOf(PaperStrategy.class, actualResult);
    }

    @Test
    public void testGetStrategyReturnsScissors() {
        Mockito.when(random.nextInt(3)).thenReturn(2);
        GameStrategy actualResult = spyComputerPlayer.getStrategy();
        Assertions.assertNotNull(actualResult);
        Assertions.assertInstanceOf(ScissorsStrategy.class, actualResult);
    }
}