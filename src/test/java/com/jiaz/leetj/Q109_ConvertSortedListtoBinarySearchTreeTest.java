package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q109_ConvertSortedListtoBinarySearchTreeTest extends AbstractTest<Q109_ConvertSortedListtoBinarySearchTree> {

    @Override
    protected String solveProblem(String input, Q109_ConvertSortedListtoBinarySearchTree solver) {
        return serialize(solver.sortedListToBST(toList(input)));
    }

}
