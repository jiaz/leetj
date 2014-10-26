package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q026_RemoveDuplicatesfromSortedArrayTest extends AbstractTest<Q026_RemoveDuplicatesfromSortedArray> {

    @Override
    protected String solveProblem(String input, Q026_RemoveDuplicatesfromSortedArray solver) {
        String[] inputs = tokenizeInput(input);
        int[] src = toIntArray(inputs[0]);
        int len = solver.removeDuplicates(src);
        int[] result = new int[len];
        if (len > 0) System.arraycopy(src, 0, result, 0, len);
        return serialize(result);
    }

}
