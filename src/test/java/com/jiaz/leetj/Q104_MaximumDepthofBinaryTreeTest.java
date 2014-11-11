package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q104_MaximumDepthofBinaryTreeTest extends AbstractTest<Q104_MaximumDepthofBinaryTree> {

    @Override
    protected String solveProblem(String input, Q104_MaximumDepthofBinaryTree solver) {
        return serialize(solver.maxDepth(toTreeNode(input)));
    }

}
