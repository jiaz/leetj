package com.jiaz.leetj;

import static com.jiaz.leetj.TestRunner.*;

public class Q007_ReverseIntegerTest extends AbstractTest<Q007_ReverseInteger> {

    @Override
    protected String solveProblem(String input, Q007_ReverseInteger solver) {
        return serialize(solver.reverse(toInt(input)));
    }

} 
