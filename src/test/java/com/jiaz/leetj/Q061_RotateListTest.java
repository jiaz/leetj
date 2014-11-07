package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q061_RotateListTest extends AbstractTest<Q061_RotateList> {

    @Override
    protected String solveProblem(String input, Q061_RotateList solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.rotateRight(toList(inputs[0]), toInt(inputs[1])));
    }

}
