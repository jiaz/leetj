package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q073_SetMatrixZeroesTest extends AbstractTest<Q073_SetMatrixZeroes> {

    @Override
    protected String solveProblem(String input, Q073_SetMatrixZeroes solver) {
        return serialize(solver.setZeroes(toArrayOfIntArray(input)));
    }

}
