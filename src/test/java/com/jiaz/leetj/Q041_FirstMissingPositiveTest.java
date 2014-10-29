package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q041_FirstMissingPositiveTest extends AbstractTest<Q041_FirstMissingPositive> {

    @Override
    protected String solveProblem(String input, Q041_FirstMissingPositive solver) {
        return serialize(solver.firstMissingPositive(toIntArray(input)));
    }

}
