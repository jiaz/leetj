package com.jiaz.leetj;

import static com.jiaz.leetj.TestRunner.*;

public class Q009_PalindromeNumberTest extends AbstractTest<Q009_PalindromeNumber> {

    @Override
    protected String solveProblem(String input, Q009_PalindromeNumber solver) {
        return serialize(solver.isPalindrome(toInt(input)));
    }

} 
