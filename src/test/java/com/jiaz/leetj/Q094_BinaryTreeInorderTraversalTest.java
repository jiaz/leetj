package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q094_BinaryTreeInorderTraversalTest extends AbstractTest<Q094_BinaryTreeInorderTraversal> {

    @Override
    protected String solveProblem(String input, Q094_BinaryTreeInorderTraversal solver) {
        return serializeList(solver.inorderTraversal(toTreeNode(input)), IntegerSerializer.getInstance());
    }

}
