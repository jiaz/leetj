package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q129_SumRoottoLeafNumbersTest extends AbstractTest<Q129_SumRoottoLeafNumbers> {

    @Override
    protected String solveProblem(String input, Q129_SumRoottoLeafNumbers solver) {
        return serialize(solver.sumNumbers(toTreeNode(input)));
    }

}
