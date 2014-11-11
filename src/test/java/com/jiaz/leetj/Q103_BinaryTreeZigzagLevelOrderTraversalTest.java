package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q103_BinaryTreeZigzagLevelOrderTraversalTest extends AbstractTest<Q103_BinaryTreeZigzagLevelOrderTraversal> {

    @Override
    protected String solveProblem(String input, Q103_BinaryTreeZigzagLevelOrderTraversal solver) {
        return serializeList(solver.zigzagLevelOrder(toTreeNode(input)), IntegerListSerializer.getInstance());
    }

}
