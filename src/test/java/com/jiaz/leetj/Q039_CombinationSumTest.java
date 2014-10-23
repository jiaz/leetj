package com.jiaz.leetj;

import static com.jiaz.leetj.TestRunner.*;

public class Q039_CombinationSumTest extends AbstractTest<Q039_CombinationSum> {

    @Override
    protected String solveProblem(String input, Q039_CombinationSum solver) {
        String[] inputs = tokenizeInput(input);
        return serializeListOfListInt(solver.combinationSum(toIntArray(inputs[0]), toInt(inputs[1])));
    }

} 
