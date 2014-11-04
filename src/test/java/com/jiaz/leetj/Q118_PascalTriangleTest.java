package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q118_PascalTriangleTest extends AbstractTest<Q118_PascalTriangle> {

    @Override
    protected String solveProblem(String input, Q118_PascalTriangle solver) {
        return serializeList(solver.generate(toInt(input)), IntegerListSerializer.getInstance());
    }

}
