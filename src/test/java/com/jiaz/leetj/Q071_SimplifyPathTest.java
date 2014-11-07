package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q071_SimplifyPathTest extends AbstractTest<Q071_SimplifyPath> {

    @Override
    protected String solveProblem(String input, Q071_SimplifyPath solver) {
        return serialize(solver.simplifyPath(toStr(input)));
    }

}
