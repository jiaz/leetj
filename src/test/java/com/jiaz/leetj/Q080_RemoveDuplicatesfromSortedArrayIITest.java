package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q080_RemoveDuplicatesfromSortedArrayIITest extends AbstractTest<Q080_RemoveDuplicatesfromSortedArrayII> {

    @Override
    protected String solveProblem(String input, Q080_RemoveDuplicatesfromSortedArrayII solver) {
        int[] arr = toIntArray(input);
        int res = solver.removeDuplicates(arr);
        int[] resArr = new int[res];
        System.arraycopy(arr, 0, resArr, 0, res);
        return serialize(resArr);
    }

}
