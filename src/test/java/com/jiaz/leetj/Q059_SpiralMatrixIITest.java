package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q059_SpiralMatrixIITest extends AbstractTest<Q059_SpiralMatrixII> {

    @Override
    protected String solveProblem(String input, Q059_SpiralMatrixII solver) {
        return serialize(solver.generateMatrix(toInt(input)));
    }

}
