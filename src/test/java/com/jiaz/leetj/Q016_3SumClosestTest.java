package com.jiaz.leetj;

import static com.jiaz.leetj.TestRunner.*;

public class Q016_3SumClosestTest extends AbstractTest<Q016_3SumClosest> {

    @Override
    protected String solveProblem(String input, Q016_3SumClosest solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.threeSumClosest(toIntArray(inputs[0]), toInt(inputs[1])));
    }

} 
