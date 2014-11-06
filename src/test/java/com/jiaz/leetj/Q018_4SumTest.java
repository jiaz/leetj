package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q018_4SumTest extends AbstractTest<Q018_4Sum> {

    @Override
    protected String solveProblem(String input, Q018_4Sum solver) {
        String[] inputs = tokenizeInput(input);
        return serializeList(solver.fourSum(toIntArray(inputs[0]), toInt(inputs[1])),
            IntegerListSerializer.getInstance());
    }

}
