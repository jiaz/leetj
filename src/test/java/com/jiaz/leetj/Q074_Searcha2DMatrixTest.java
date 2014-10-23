package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q074_Searcha2DMatrixTest extends AbstractTest<Q074_Searcha2DMatrix> {

    @Override
    protected String solveProblem(String input, Q074_Searcha2DMatrix solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.searchMatrix(toArrayOfIntArray(inputs[0]), toInt(inputs[1])));
    }

} 
