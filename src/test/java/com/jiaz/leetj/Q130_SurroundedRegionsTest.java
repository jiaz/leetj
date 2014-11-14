package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q130_SurroundedRegionsTest extends AbstractTest<Q130_SurroundedRegions> {

    @Override
    protected String solveProblem(String input, Q130_SurroundedRegions solver) {
        char[][] board = solver.solve(toCharMap(input));
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; ++i) {
            res.add(new String(board[i]));
        }
        return serializeList(res, StringSerializer.getInstance());
    }

}
