package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q111_MinimumDepthofBinaryTreeTest extends AbstractTest<Q111_MinimumDepthofBinaryTree> {

    @Override
    protected String solveProblem(String input, Q111_MinimumDepthofBinaryTree solver) {
        // public int minDepth(TreeNode root) {
        return serialize(solver.minDepth(toTreeNode(input)));
    }

} 
