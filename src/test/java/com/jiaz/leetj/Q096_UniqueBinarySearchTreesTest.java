package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q096_UniqueBinarySearchTreesTest extends AbstractTest<Q096_UniqueBinarySearchTrees> {

    @Override
    protected String solveProblem(String input, Q096_UniqueBinarySearchTrees solver) {
        return serialize(solver.numTrees(toInt(input)));
    }

}
