package com.jiaz.leetj;

import static com.jiaz.leetj.TestRunner.*;

public class Q006_ZigZagConversionTest extends AbstractTest<Q006_ZigZagConversion> {

    @Override
    protected String solveProblem(String input, Q006_ZigZagConversion solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.convert(toStr(inputs[0]), toInt(inputs[1])));
    }

} 
