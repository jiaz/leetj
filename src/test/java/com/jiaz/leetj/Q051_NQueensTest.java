package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q051_NQueensTest extends AbstractTest<Q051_NQueens> {

    @Override
    protected String solveProblem(String input, Q051_NQueens solver) {
        return serializeList(solver.solveNQueens(toInt(input)), StringArraySerializer.getInstance());
    }

} 
