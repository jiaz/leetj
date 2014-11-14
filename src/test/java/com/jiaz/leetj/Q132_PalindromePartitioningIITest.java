package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q132_PalindromePartitioningIITest extends AbstractTest<Q132_PalindromePartitioningII> {

    @Override
    protected String solveProblem(String input, Q132_PalindromePartitioningII solver) {
        return serialize(solver.minCut(toStr(input)));
    }

}
