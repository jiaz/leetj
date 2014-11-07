package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q063_UniquePathsIITest extends AbstractTest<Q063_UniquePathsII> {

    @Override
    protected String solveProblem(String input, Q063_UniquePathsII solver) {
        return serialize(solver.uniquePathsWithObstacles(toArrayOfIntArray(input)));
    }

}
