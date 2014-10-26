package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q033_SearchinRotatedSortedArrayTest extends AbstractTest<Q033_SearchinRotatedSortedArray> {

    @Override
    protected String solveProblem(String input, Q033_SearchinRotatedSortedArray solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.search(toIntArray(inputs[0]), toInt(inputs[1])));
    }

}
