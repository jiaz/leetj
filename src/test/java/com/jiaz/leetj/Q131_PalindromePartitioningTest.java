package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q131_PalindromePartitioningTest extends AbstractTest<Q131_PalindromePartitioning> {

    @Override
    protected String solveProblem(String input, Q131_PalindromePartitioning solver) {
        return serializeList(solver.partition(toStr(input)), StringListSerializer.getInstance());
    }

}
