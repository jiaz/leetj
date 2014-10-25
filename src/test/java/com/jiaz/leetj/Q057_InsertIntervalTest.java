package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q057_InsertIntervalTest extends AbstractTest<Q057_InsertInterval> {

    @Override
    protected String solveProblem(String input, Q057_InsertInterval solver) {
        String[] inputs = tokenizeInput(input);
        return serializeList(solver.insert(toIntervalList(inputs[0]), toInterval(inputs[1])),
            IntervalSerializer.getInstance());
    }

} 
