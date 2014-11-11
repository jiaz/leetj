package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q091_DecodeWaysTest extends AbstractTest<Q091_DecodeWays> {

    @Override
    protected String solveProblem(String input, Q091_DecodeWays solver) {
        return serialize(solver.numDecodings(toStr(input)));
    }

}
