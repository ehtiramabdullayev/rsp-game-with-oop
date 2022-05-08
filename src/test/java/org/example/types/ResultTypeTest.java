package org.example.types;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultTypeTest {
    @Test
    public void simpleEnumExampleInsideClassTest() {
        ResultType win = ResultType.WIN;
        ResultType loss = ResultType.LOSS;
        ResultType draw = ResultType.DRAW;
        assertEquals(ResultType.valueOf("WIN"), win);
        assertEquals(ResultType.valueOf("LOSS"), loss);
        assertEquals(ResultType.valueOf("DRAW"), draw);
    }

}