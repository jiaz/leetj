package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q112_PathSumTest extends AbstractTest<Q112_PathSum> {

    @Override
    protected String solveProblem(String input, Q112_PathSum solver) {
        String[] inputs = tokenizeInput(input);
        TreeNode t = toTreeNode(inputs[0]);
        String s = serialize(t);
        t = toTreeNode(s);
        return serialize(solver.hasPathSum(t, toInt(inputs[1])));
    }

} 
