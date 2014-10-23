package com.jiaz.leetj;

import static com.jiaz.leetj.TestRunner.*;

public class Q020_ValidParenthesesTest extends AbstractTest<Q020_ValidParentheses> {

    @Override
    protected String solveProblem(String input, Q020_ValidParentheses solver) {
        return serialize(solver.isValid(toStr(input)));
    }

} 
