package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q028_ImplementstrStrTest extends AbstractTest<Q028_ImplementstrStr> {

    @Override
    protected String solveProblem(String input, Q028_ImplementstrStr solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.strStr(toStr(inputs[0]), toStr(inputs[1])));
    }

}
