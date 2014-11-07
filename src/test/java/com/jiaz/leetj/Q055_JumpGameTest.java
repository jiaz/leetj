package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q055_JumpGameTest extends AbstractTest<Q055_JumpGame> {

    @Override
    protected String solveProblem(String input, Q055_JumpGame solver) {
        return serialize(solver.canJump(toIntArray(input)));
    }

}
