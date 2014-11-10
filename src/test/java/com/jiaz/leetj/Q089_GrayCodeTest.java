package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q089_GrayCodeTest extends AbstractTest<Q089_GrayCode> {

    @Override
    protected String solveProblem(String input, Q089_GrayCode solver) {
        return serializeList(solver.grayCode(toInt(input)), IntegerSerializer.getInstance());
    }

}
