package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q102_BinaryTreeLevelOrderTraversalTest extends AbstractTest<Q102_BinaryTreeLevelOrderTraversal> {

    @Override
    protected String solveProblem(String input, Q102_BinaryTreeLevelOrderTraversal solver) {
        return serializeList(solver.levelOrder(toTreeNode(input)), IntegerListSerializer.getInstance());
    }

}
