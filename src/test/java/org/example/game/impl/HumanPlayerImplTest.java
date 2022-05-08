package org.example.game.impl;

import org.example.strategy.GameStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HumanPlayerImplTest {
    @InjectMocks
    HumanPlayerImpl humanPlayerImpl;
    @Mock
    GameStrategy gameStrategy;

    @Test
    public void testComputerPlayerPlayAgainstMethod() {
        humanPlayerImpl = Mockito.spy(humanPlayerImpl);
        ComputerPlayerImpl mockCompPlayer = Mockito.mock(ComputerPlayerImpl.class);
        GameStrategy rockMock2 = Mockito.mock(GameStrategy.class);
        Mockito.when(mockCompPlayer.getStrategy()).thenReturn(rockMock2);
        humanPlayerImpl.playAgainst(mockCompPlayer);
        Mockito.verify(gameStrategy, Mockito.times(1)).play(Mockito.any());
    }

}