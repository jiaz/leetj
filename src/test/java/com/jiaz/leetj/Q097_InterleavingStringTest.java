package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q097_InterleavingStringTest extends AbstractTest<Q097_InterleavingString> {

    @Override
    protected String solveProblem(String input, Q097_InterleavingString solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.isInterleave(toStr(inputs[0]), toStr(inputs[1]), toStr(inputs[2])));
    }

}
