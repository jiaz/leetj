package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q108_ConvertSortedArraytoBinarySearchTreeTest extends AbstractTest<Q108_ConvertSortedArraytoBinarySearchTree> {

    @Override
    protected String solveProblem(String input, Q108_ConvertSortedArraytoBinarySearchTree solver) {
        return serialize(solver.sortedArrayToBST(toIntArray(input)));
    }

}
