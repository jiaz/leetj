package com.jiaz.leetj;

import static com.jiaz.leetj.TestRunner.*;

public class Q008_StringtoIntegerTest extends AbstractTest<Q008_StringtoInteger> {

    @Override
    protected String solveProblem(String input, Q008_StringtoInteger solver) {
        return serialize(solver.atoi(toStr(input)));
    }

} 
