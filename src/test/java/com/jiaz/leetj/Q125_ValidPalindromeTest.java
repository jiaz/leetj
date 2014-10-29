package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q125_ValidPalindromeTest extends AbstractTest<Q125_ValidPalindrome> {

    @Override
    protected String solveProblem(String input, Q125_ValidPalindrome solver) {
        return serialize(solver.isPalindrome(toStr(input)));
    }

}
