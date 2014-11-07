package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q067_AddBinaryTest extends AbstractTest<Q067_AddBinary> {

    @Override
    protected String solveProblem(String input, Q067_AddBinary solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.addBinary(toStr(inputs[0]), toStr(inputs[1])));
    }

}
