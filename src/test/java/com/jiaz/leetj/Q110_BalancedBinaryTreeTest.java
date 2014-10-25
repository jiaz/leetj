package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q110_BalancedBinaryTreeTest extends AbstractTest<Q110_BalancedBinaryTree> {

    @Override
    protected String solveProblem(String input, Q110_BalancedBinaryTree solver) {
        // public boolean isBalanced(TreeNode root) {
        return serialize(solver.isBalanced(toTreeNode(input)));
    }

} 
