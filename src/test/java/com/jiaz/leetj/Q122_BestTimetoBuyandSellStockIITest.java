package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q122_BestTimetoBuyandSellStockIITest extends AbstractTest<Q122_BestTimetoBuyandSellStockII> {

    @Override
    protected String solveProblem(String input, Q122_BestTimetoBuyandSellStockII solver) {
        return serialize(solver.maxProfit(toIntArray(input)));
    }

}
