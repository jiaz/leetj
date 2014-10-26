package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q100_SameTreeTest extends AbstractTest<Q100_SameTree> {

    @Override
    protected String solveProblem(String input, Q100_SameTree solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.isSameTree(toTreeNode(inputs[0]), toTreeNode(inputs[1])));
    }

}
