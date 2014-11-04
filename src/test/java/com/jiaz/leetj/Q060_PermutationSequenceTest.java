package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q060_PermutationSequenceTest extends AbstractTest<Q060_PermutationSequence> {

    @Override
    protected String solveProblem(String input, Q060_PermutationSequence solver) {
        String[] inputs = tokenizeInput(input);
        String res = serialize(solver.getPermutation(toInt(inputs[0]), toInt(inputs[1])));
        System.out.println(res);
        return res;
    }

}
