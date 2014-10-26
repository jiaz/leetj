package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q066_PlusOneTest extends AbstractTest<Q066_PlusOne> {

    @Override
    protected String solveProblem(String input, Q066_PlusOne solver) {
        return serialize(solver.plusOne(toIntArray(input)));
    }

}
