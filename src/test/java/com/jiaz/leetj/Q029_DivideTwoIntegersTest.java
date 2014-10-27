package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q029_DivideTwoIntegersTest extends AbstractTest<Q029_DivideTwoIntegers> {

    @Override
    protected String solveProblem(String input, Q029_DivideTwoIntegers solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.divide(toInt(inputs[0]), toInt(inputs[1])));
    }

}
