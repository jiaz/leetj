package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q106_ConstructBinaryTreefromInorderandPostorderTraversalTest extends AbstractTest<Q106_ConstructBinaryTreefromInorderandPostorderTraversal> {

    @Override
    protected String solveProblem(String input, Q106_ConstructBinaryTreefromInorderandPostorderTraversal solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.buildTree(toIntArray(inputs[0]), toIntArray(inputs[1])));
    }

}
