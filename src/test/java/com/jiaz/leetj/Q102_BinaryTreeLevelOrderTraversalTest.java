package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q102_BinaryTreeLevelOrderTraversalTest extends AbstractTest<Q102_BinaryTreeLevelOrderTraversal> {

    @Override
    protected String solveProblem(String input, Q102_BinaryTreeLevelOrderTraversal solver) {
        //List<List<Integer>> levelOrder(TreeNode root)
        return serializeListOfListInt(solver.levelOrder(toTreeNode(input)));
    }

} 
