package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q113_PathSumIITest extends AbstractTest<Q113_PathSumII> {

    @Override
    protected String solveProblem(String input, Q113_PathSumII solver) {
        String[] inputs = tokenizeInput(input);
        return serializeList(solver.pathSum(toTreeNode(inputs[0]), toInt(inputs[1])), IntegerListSerializer.getInstance());
    }

}
