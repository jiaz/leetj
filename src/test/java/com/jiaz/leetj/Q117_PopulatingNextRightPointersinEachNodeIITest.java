package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q117_PopulatingNextRightPointersinEachNodeIITest extends AbstractTest<Q117_PopulatingNextRightPointersinEachNodeII> {

    @Override
    protected String solveProblem(String input, Q117_PopulatingNextRightPointersinEachNodeII solver) {
        return serialize(solver.connect(toTreeLinkNode(input)));
    }

}
