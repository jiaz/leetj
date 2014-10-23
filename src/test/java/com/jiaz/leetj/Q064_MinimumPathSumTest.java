package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q064_MinimumPathSumTest extends AbstractTest<Q064_MinimumPathSum> {

    @Override
    protected String solveProblem(String input, Q064_MinimumPathSum solver) {
        return serialize(solver.minPathSum(toArrayOfIntArray(input)));
    }

} 
