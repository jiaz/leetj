package com.jiaz.leetj;

import static com.jiaz.leetj.TestRunner.*;

public class Q034_SearchforaRangeTest extends AbstractTest<Q034_SearchforaRange> {

    @Override
    protected String solveProblem(String input, Q034_SearchforaRange solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.searchRange(toIntArray(inputs[0]), toInt(inputs[1])));
    }

} 
