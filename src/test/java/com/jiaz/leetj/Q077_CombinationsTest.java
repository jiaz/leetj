package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q077_CombinationsTest extends AbstractTest<Q077_Combinations> {

    @Override
    protected String solveProblem(String input, Q077_Combinations solver) {
        String[] inputs = tokenizeInput(input);
        return serializeList(solver.combine(toInt(inputs[0]), toInt(inputs[1])), IntegerListSerializer.getInstance());
    }

}
