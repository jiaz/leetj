package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q056_MergeIntervalsTest extends AbstractTest<Q056_MergeIntervals> {

    @Override
    protected String solveProblem(String input, Q056_MergeIntervals solver) {
        return serializeList(solver.merge(toIntervalList(input)), IntervalSerializer.getInstance());
    }

} 
