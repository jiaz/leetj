package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q031_NextPermutationTest extends AbstractTest<Q031_NextPermutation> {

    @Override
    protected String solveProblem(String input, Q031_NextPermutation solver) {
        return serialize(solver.nextPermutation(toIntArray(input)));
    }

} 
