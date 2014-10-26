package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q036_ValidSudokuTest extends AbstractTest<Q036_ValidSudoku> {

    @Override
    protected String solveProblem(String input, Q036_ValidSudoku solver) {
        return serialize(solver.isValidSudoku(toCharMap(input)));
    }

}
