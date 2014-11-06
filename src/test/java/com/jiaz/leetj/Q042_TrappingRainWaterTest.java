package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q042_TrappingRainWaterTest extends AbstractTest<Q042_TrappingRainWater> {

    @Override
    protected String solveProblem(String input, Q042_TrappingRainWater solver) {
        return serialize(solver.trap(toIntArray(input)));
    }

}
