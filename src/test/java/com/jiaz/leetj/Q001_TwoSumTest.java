package com.jiaz.leetj;

import static com.jiaz.leetj.TestRunner.*;

public class Q001_TwoSumTest extends AbstractTest<Q001_TwoSum> {

    @Override
    protected String solveProblem(String input, Q001_TwoSum solver) {
        String[] inputs = tokenizeInput(input);
        return serializeInformal(solver.twoSum(toIntArray(inputs[0]), toInt(inputs[1])));
    }
}
