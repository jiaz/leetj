package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q101_SymmetricTreeTest extends AbstractTest<Q101_SymmetricTree> {

    @Override
    protected String solveProblem(String input, Q101_SymmetricTree solver) {
        return serialize(solver.isSymmetric(toTreeNode(input)));
    }

}
