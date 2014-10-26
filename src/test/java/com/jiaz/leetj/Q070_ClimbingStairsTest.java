package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q070_ClimbingStairsTest extends AbstractTest<Q070_ClimbingStairs> {

    @Override
    protected String solveProblem(String input, Q070_ClimbingStairs solver) {
        return serialize(solver.climbStairs(toInt(input)));
    }

}
