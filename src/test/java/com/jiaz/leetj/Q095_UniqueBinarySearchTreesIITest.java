package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q095_UniqueBinarySearchTreesIITest extends AbstractTest<Q095_UniqueBinarySearchTreesII> {

    @Override
    protected String solveProblem(String input, Q095_UniqueBinarySearchTreesII solver) {
        return serializeList(solver.generateTrees(toInt(input)), TreeNodeSerializer.getInstance());
    }

}
