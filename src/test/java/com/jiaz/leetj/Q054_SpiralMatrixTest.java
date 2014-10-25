package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q054_SpiralMatrixTest extends AbstractTest<Q054_SpiralMatrix> {

    @Override
    protected String solveProblem(String input, Q054_SpiralMatrix solver) {
        return serializeList(solver.spiralOrder(toArrayOfIntArray(input)),
            IntegerSerializer.getInstance());
    }

} 
