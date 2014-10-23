package com.jiaz.leetj;

import static com.jiaz.leetj.TestRunner.*;
import java.util.*;

public class Q127_WordLadderTest extends AbstractTest<Q127_WordLadder> {

    @Override
    protected String solveProblem(String input, Q127_WordLadder solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.ladderLength(toStr(inputs[0]), toStr(inputs[1]), new HashSet<String>(Arrays.asList(toStrArray(inputs[2])))));
    }

} 
