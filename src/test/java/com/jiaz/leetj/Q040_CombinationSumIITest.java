package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q040_CombinationSumIITest extends AbstractTest<Q040_CombinationSumII> {

    @Override
    protected String solveProblem(String input, Q040_CombinationSumII solver) {
        String[] inputs = tokenizeInput(input);
        return serializeList(solver.combinationSum2(toIntArray(inputs[0]), toInt(inputs[1])),
            IntegerListSerializer.getInstance());
    }

}
