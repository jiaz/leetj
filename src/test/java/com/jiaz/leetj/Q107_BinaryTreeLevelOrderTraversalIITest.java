package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q107_BinaryTreeLevelOrderTraversalIITest extends AbstractTest<Q107_BinaryTreeLevelOrderTraversalII> {

    @Override
    protected String solveProblem(String input, Q107_BinaryTreeLevelOrderTraversalII solver) {
        return serializeList(solver.levelOrderBottom(toTreeNode(input)), IntegerListSerializer.getInstance());
    }

}
