package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q023_MergekSortedListsTest extends AbstractTest<Q023_MergekSortedLists> {

    @Override
    protected String solveProblem(String input, Q023_MergekSortedLists solver) {
        return serialize(solver.mergeKLists(toListOfListNode(input)));
    }

}
