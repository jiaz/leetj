package com.jiaz.leetj;

import static com.jiaz.leetj.TestRunner.*;

public class Q014_LongestCommonPrefixTest extends AbstractTest<Q014_LongestCommonPrefix> {

    @Override
    protected String solveProblem(String input, Q014_LongestCommonPrefix solver) {
        return serialize(solver.longestCommonPrefix(toStrArray(input)));
    }

} 
