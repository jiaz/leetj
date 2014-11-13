package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q123_BestTimetoBuyandSellStockIIITest extends AbstractTest<Q123_BestTimetoBuyandSellStockIII> {

    @Override
    protected String solveProblem(String input, Q123_BestTimetoBuyandSellStockIII solver) {
        return serialize(solver.maxProfit(toIntArray(input)));
    }

}
