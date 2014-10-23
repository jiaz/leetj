package com.jiaz.leetj;

import static com.jiaz.leetj.TestRunner.*;

public class Q013_RomantoIntegerTest extends AbstractTest<Q013_RomantoInteger> {

    @Override
    protected String solveProblem(String input, Q013_RomantoInteger solver) {
        return serialize(solver.romanToInt(toStr(input)));
    }

} 
