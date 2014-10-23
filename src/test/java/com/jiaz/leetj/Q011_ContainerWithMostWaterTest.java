package com.jiaz.leetj;

import static com.jiaz.leetj.TestRunner.*;

public class Q011_ContainerWithMostWaterTest extends AbstractTest<Q011_ContainerWithMostWater> {

    @Override
    protected String solveProblem(String input, Q011_ContainerWithMostWater solver) {
        int[] arr = toIntArray(input);
        return serialize(solver.maxArea(arr));
    }

} 
