package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q079_WordSearchTest extends AbstractTest<Q079_WordSearch> {

    @Override
    protected String solveProblem(String input, Q079_WordSearch solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.exist(toCharMap(inputs[0]), toStr(inputs[1])));
    }

}
