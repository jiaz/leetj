package com.jiaz.leetj;

import static com.jiaz.leetj.TestRunner.*;

public class Q002_AddTwoNumbersTest extends AbstractTest<Q002_AddTwoNumbers> {

    @Override
    protected String solveProblem(String input, Q002_AddTwoNumbers solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.addTwoNumbers(toList(inputs[0]), toList(inputs[1])));
    }
}
