package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q032_LongestValidParenthesesTest extends AbstractTest<Q032_LongestValidParentheses> {

    @Override
    protected String solveProblem(String input, Q032_LongestValidParentheses solver) {
        return serialize(solver.longestValidParentheses(toStr(input)));
    }

}
