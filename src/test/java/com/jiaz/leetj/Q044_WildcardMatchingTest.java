package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q044_WildcardMatchingTest extends AbstractTest<Q044_WildcardMatching> {

    @Override
    protected String solveProblem(String input, Q044_WildcardMatching solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.isMatch(toStr(inputs[0]), toStr(inputs[1])));
    }

}
