package com.jiaz.leetj;

import static com.jiaz.leetj.TestRunner.*;

public class Q005_LongestPalindromicSubstringTest extends AbstractTest<Q005_LongestPalindromicSubstring> {

    @Override
    protected String solveProblem(String input, Q005_LongestPalindromicSubstring solver) {
        return serialize(solver.longestPalindrome(toStr(input)));
    }

} 
