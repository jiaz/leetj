package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q053_MaximumSubarrayTest extends AbstractTest<Q053_MaximumSubarray> {

    @Override
    protected String solveProblem(String input, Q053_MaximumSubarray solver) {
        return serialize(solver.maxSubArray(toIntArray(input)));
    }

}
