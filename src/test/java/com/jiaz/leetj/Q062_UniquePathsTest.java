package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q062_UniquePathsTest extends AbstractTest<Q062_UniquePaths> {

    @Override
    protected String solveProblem(String input, Q062_UniquePaths solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.uniquePaths(toInt(inputs[0]), toInt(inputs[1])));
    }

}
