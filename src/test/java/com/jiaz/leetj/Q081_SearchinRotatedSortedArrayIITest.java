package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q081_SearchinRotatedSortedArrayIITest extends AbstractTest<Q081_SearchinRotatedSortedArrayII> {

    @Override
    protected String solveProblem(String input, Q081_SearchinRotatedSortedArrayII solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.search(toIntArray(inputs[0]), toInt(inputs[1])));
    }

}
