package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q098_ValidateBinarySearchTreeTest extends AbstractTest<Q098_ValidateBinarySearchTree> {

    @Override
    protected String solveProblem(String input, Q098_ValidateBinarySearchTree solver) {
        TreeNode tn = toTreeNode(input);
        return serialize(solver.isValidBST(tn));
    }

}
