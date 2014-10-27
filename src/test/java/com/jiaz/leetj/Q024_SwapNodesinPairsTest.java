package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q024_SwapNodesinPairsTest extends AbstractTest<Q024_SwapNodesinPairs> {

    @Override
    protected String solveProblem(String input, Q024_SwapNodesinPairs solver) {
        return serialize(solver.swapPairs(toList(input)));
    }

}
