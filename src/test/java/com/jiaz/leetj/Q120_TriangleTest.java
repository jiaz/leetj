package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q120_TriangleTest extends AbstractTest<Q120_Triangle> {

    @Override
    protected String solveProblem(String input, Q120_Triangle solver) {
        return serialize(solver.minimumTotal(toListOfListOfInt(input)));
    }

}
