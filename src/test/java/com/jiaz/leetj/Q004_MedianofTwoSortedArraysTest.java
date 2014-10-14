package com.jiaz.leetj;

import static com.jiaz.leetj.TestRunner.*;

public class Q004_MedianofTwoSortedArraysTest extends AbstractTest<Q004_MedianofTwoSortedArrays> {

    @Override
    protected String solveProblem(String input, Q004_MedianofTwoSortedArrays solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.findMedianSortedArrays(toIntArray(inputs[0]), toIntArray(inputs[1])));
    }

} 
