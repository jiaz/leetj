package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q116_PopulatingNextRightPointersinEachNodeTest extends AbstractTest<Q116_PopulatingNextRightPointersinEachNode> {

    @Override
    protected String solveProblem(String input, Q116_PopulatingNextRightPointersinEachNode solver) {
        return serialize(solver.connect(toTreeLinkNode(input)));
    }

}
