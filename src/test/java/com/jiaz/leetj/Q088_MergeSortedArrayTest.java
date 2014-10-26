package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q088_MergeSortedArrayTest extends AbstractTest<Q088_MergeSortedArray> {

    @Override
    protected String solveProblem(String input, Q088_MergeSortedArray solver) {
        String[] inputs = tokenizeInput(input);
        int[] A = toIntArray(inputs[0]);
        int[] B = toIntArray(inputs[1]);
        int m = A.length;
        int n = B.length;
        int[] tmp = new int[m + n];
        System.arraycopy(A, 0, tmp, 0, m);
        A = tmp;
        return serialize(solver.merge(A, m, B, n));
    }

}
