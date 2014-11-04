package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q099_RecoverBinarySearchTreeTest extends AbstractTest<Q099_RecoverBinarySearchTree> {

    @Override
    protected String solveProblem(String input, Q099_RecoverBinarySearchTree solver) {
        return serialize(solver.recoverTree(toTreeNode(input)));
    }

}
