package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q084_LargestRectangleinHistogramTest extends AbstractTest<Q084_LargestRectangleinHistogram> {

    @Override
    protected String solveProblem(String input, Q084_LargestRectangleinHistogram solver) {
        return serialize(solver.largestRectangleArea(toIntArray(input)));
    }

}
