package com.jiaz.leetj;

import static com.jiaz.leetj.TestRunner.*;

public class Q012_IntegertoRomanTest extends AbstractTest<Q012_IntegertoRoman> {

    @Override
    protected String solveProblem(String input, Q012_IntegertoRoman solver) {
        return serialize(solver.intToRoman(toInt(input)));
    }

} 
