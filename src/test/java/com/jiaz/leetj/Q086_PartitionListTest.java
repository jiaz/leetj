package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q086_PartitionListTest extends AbstractTest<Q086_PartitionList> {

    @Override
    protected String solveProblem(String input, Q086_PartitionList solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.partition(toList(inputs[0]), toInt(inputs[1])));
    }

}
