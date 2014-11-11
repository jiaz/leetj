package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q105_ConstructBinaryTreefromPreorderandInorderTraversalTest extends AbstractTest<Q105_ConstructBinaryTreefromPreorderandInorderTraversal> {

    @Override
    protected String solveProblem(String input, Q105_ConstructBinaryTreefromPreorderandInorderTraversal solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.buildTree(toIntArray(inputs[0]), toIntArray(inputs[1])));
    }

}
