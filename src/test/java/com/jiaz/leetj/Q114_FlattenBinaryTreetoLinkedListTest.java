package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q114_FlattenBinaryTreetoLinkedListTest extends AbstractTest<Q114_FlattenBinaryTreetoLinkedList> {

    @Override
    protected String solveProblem(String input, Q114_FlattenBinaryTreetoLinkedList solver) {
        return serialize(solver.flatten(toTreeNode(input)));
    }

}
