package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q037_SudokuSolverTest extends AbstractTest<Q037_SudokuSolver> {

    @Override
    protected String solveProblem(String input, Q037_SudokuSolver solver) {
        return serializeList(solver.solveSudoku(toCharMap(input)), StringSerializer.getInstance());
    }

}
