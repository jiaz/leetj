package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q025_ReverseNodesinKGroupTest extends AbstractTest<Q025_ReverseNodesinKGroup> {

    @Override
    protected String solveProblem(String input, Q025_ReverseNodesinKGroup solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.reverseKGroup(toList(inputs[0]), toInt(inputs[1])));
    }

} 
