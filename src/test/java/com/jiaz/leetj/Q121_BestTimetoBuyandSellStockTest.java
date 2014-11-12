package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q121_BestTimetoBuyandSellStockTest extends AbstractTest<Q121_BestTimetoBuyandSellStock> {

    @Override
    protected String solveProblem(String input, Q121_BestTimetoBuyandSellStock solver) {
        return serialize(solver.maxProfit(toIntArray(input)));
    }

}
