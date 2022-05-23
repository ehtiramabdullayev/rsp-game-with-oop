package org.example.types;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.example.types.Constants.CHOICE_DOES_NOT_EXISTS_TEXT;

public enum ChoiceType {
    ROCK, PAPER, SCISSORS;

    private static final Map<String, ChoiceType> CHOICE_TYPE_MAP =
            Stream.of(values())
                    .collect(Collectors.toMap(ChoiceType::toString,
                            Function.identity()));

    public static ChoiceType fromString(final String name) {
        ChoiceType choice = CHOICE_TYPE_MAP.get(name);
        if (null == choice) {
            throw new IllegalArgumentException(
                    String.format(CHOICE_DOES_NOT_EXISTS_TEXT, name,
                            Arrays.asList(values())));
        }
        return choice;
    }
}
