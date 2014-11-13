package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q128_LongestConsecutiveSequenceTest extends AbstractTest<Q128_LongestConsecutiveSequence> {

    @Override
    protected String solveProblem(String input, Q128_LongestConsecutiveSequence solver) {
        return serialize(solver.longestConsecutive(toIntArray(input)));
    }

}
