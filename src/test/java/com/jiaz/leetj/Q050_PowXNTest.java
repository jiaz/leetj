package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q050_PowXNTest extends AbstractTestII<Q050_PowXN, Double> {

    @Override
    protected boolean verifyResult(Double result, String answer) {
        Double answerObj = toDouble(answer);
        return doubleEq(result, answerObj);
    }

    @Override
    protected Double solveProblem(String input, Q050_PowXN solver) {
        String[] inputs = tokenizeInput(input);
        return solver.pow(toDouble(inputs[0]), toInt(inputs[1]));
    }
}
