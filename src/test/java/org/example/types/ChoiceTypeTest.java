package org.example.types;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChoiceTypeTest {

    @Test
    public void whenConvertedIntoEnumThenGetsConvertedCorrectly() {
        String paper = "PAPER";
        String rock = "ROCK";
        String scissors = "SCISSORS";
        ChoiceType paperType = ChoiceType.fromString(paper);
        ChoiceType rockType = ChoiceType.fromString(rock);
        ChoiceType scissorsType = ChoiceType.fromString(scissors);
        assertSame(paperType, ChoiceType.PAPER);
        assertSame(rockType, ChoiceType.ROCK);
        assertSame(scissorsType, ChoiceType.SCISSORS);
    }

    @Test
    public void whenConvertedIntoEnumThenGetsConvertedFails() {
        String paper = "some1";
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> {
                    ChoiceType.fromString(paper);
                });
        assertTrue(thrown.getMessage().contains("does not exist as a choice"));

    }

}