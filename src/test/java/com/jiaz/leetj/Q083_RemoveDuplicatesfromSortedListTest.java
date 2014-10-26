package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q083_RemoveDuplicatesfromSortedListTest extends AbstractTest<Q083_RemoveDuplicatesfromSortedList> {

    @Override
    protected String solveProblem(String input, Q083_RemoveDuplicatesfromSortedList solver) {
        return serialize(solver.deleteDuplicates(toList(input)));
    }

}
