package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q115_DistinctSubsequencesTest extends AbstractTest<Q115_DistinctSubsequences> {

    @Override
    protected String solveProblem(String input, Q115_DistinctSubsequences solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.numDistinct(toStr(inputs[0]), toStr(inputs[1])));
    }

}
