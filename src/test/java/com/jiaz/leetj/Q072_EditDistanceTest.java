package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q072_EditDistanceTest extends AbstractTest<Q072_EditDistance> {

    @Override
    protected String solveProblem(String input, Q072_EditDistance solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.minDistance(toStr(inputs[0]), toStr(inputs[1])));
    }

} 
