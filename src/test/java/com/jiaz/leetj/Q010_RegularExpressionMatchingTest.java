package com.jiaz.leetj;

import static com.jiaz.leetj.TestRunner.*;

public class Q010_RegularExpressionMatchingTest extends AbstractTest<Q010_RegularExpressionMatching> {

    @Override
    protected String solveProblem(String input, Q010_RegularExpressionMatching solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.isMatch(toStr(inputs[0]), toStr(inputs[1])));
    }

} 
