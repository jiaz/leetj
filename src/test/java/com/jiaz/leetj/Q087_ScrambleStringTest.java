package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q087_ScrambleStringTest extends AbstractTest<Q087_ScrambleString> {

    @Override
    protected String solveProblem(String input, Q087_ScrambleString solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.isScramble(toStr(inputs[0]), toStr(inputs[1])));
    }

}
