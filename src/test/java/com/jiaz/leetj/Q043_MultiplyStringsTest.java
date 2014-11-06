package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q043_MultiplyStringsTest extends AbstractTest<Q043_MultiplyStrings> {

    @Override
    protected String solveProblem(String input, Q043_MultiplyStrings solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.multiply(toStr(inputs[0]), toStr(inputs[1])));
    }

}
