package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q085_MaximalRectangleTest extends AbstractTest<Q085_MaximalRectangle> {

    @Override
    protected String solveProblem(String input, Q085_MaximalRectangle solver) {
        return serialize(solver.maximalRectangle(toCharMap(input)));
    }

}
