package com.jiaz.leetj;

import static com.jiaz.leetj.TestRunner.*;

public class Q021_MergeTwoSortedListsTest extends AbstractTest<Q021_MergeTwoSortedLists> {

    @Override
    protected String solveProblem(String input, Q021_MergeTwoSortedLists solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.mergeTwoLists(toList(inputs[0]), toList(inputs[1])));
    }

} 
