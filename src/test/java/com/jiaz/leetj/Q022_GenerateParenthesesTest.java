package com.jiaz.leetj;

import static com.jiaz.leetj.TestRunner.*;

public class Q022_GenerateParenthesesTest extends AbstractTest<Q022_GenerateParentheses> {

    @Override
    protected String solveProblem(String input, Q022_GenerateParentheses solver) {
        return serializeList(solver.generateParenthesis(toInt(input)), StringSerializer.getInstance());
    }

} 
