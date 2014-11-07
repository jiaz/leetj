package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q045_JumpGameIITest extends AbstractTest<Q045_JumpGameII> {

    @Override
    protected String solveProblem(String input, Q045_JumpGameII solver) {
        return serialize(solver.jump(toIntArray(input)));
    }

}
