package com.jiaz.leetj;

import static com.jiaz.leetj.TestRunner.*;

public class Q015_3SumTest extends AbstractTest<Q015_3Sum> {

    @Override
    protected String solveProblem(String input, Q015_3Sum solver) {
        return serializeListOfListInt(solver.threeSum(toIntArray(input)));
    }

} 
