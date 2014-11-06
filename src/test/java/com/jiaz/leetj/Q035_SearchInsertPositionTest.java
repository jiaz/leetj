package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q035_SearchInsertPositionTest extends AbstractTest<Q035_SearchInsertPosition> {

    @Override
    protected String solveProblem(String input, Q035_SearchInsertPosition solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.searchInsert(toIntArray(inputs[0]), toInt(inputs[1])));
    }

}
