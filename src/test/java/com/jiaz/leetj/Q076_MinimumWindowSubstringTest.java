package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q076_MinimumWindowSubstringTest extends AbstractTest<Q076_MinimumWindowSubstring> {

    @Override
    protected String solveProblem(String input, Q076_MinimumWindowSubstring solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.minWindow(toStr(inputs[0]), toStr(inputs[1])));
    }

}
