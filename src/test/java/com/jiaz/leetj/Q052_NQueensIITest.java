package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q052_NQueensIITest extends AbstractTest<Q052_NQueensII> {

    @Override
    protected String solveProblem(String input, Q052_NQueensII solver) {
        return serialize(solver.totalNQueens(toInt(input)));
    }

} 
