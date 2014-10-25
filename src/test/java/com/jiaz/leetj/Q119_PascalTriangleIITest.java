package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q119_PascalTriangleIITest extends AbstractTest<Q119_PascalTriangleII> {

    @Override
    protected String solveProblem(String input, Q119_PascalTriangleII solver) {
        //List<Integer> getRow(int rowIndex)
        return serializeList(solver.getRow(toInt(input)), IntegerSerializer.getInstance());
    }

} 
