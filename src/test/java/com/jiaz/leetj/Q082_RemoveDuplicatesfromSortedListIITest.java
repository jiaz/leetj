package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q082_RemoveDuplicatesfromSortedListIITest extends AbstractTest<Q082_RemoveDuplicatesfromSortedListII> {

    @Override
    protected String solveProblem(String input, Q082_RemoveDuplicatesfromSortedListII solver) {
        return serialize(solver.deleteDuplicates(toList(input)));
    }

}
