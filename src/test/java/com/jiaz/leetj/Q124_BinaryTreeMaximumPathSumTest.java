package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q124_BinaryTreeMaximumPathSumTest extends AbstractTest<Q124_BinaryTreeMaximumPathSum> {

    @Override
    protected String solveProblem(String input, Q124_BinaryTreeMaximumPathSum solver) {
        return serialize(solver.maxPathSum(toTreeNode(input)));
    }

}
