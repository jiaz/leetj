package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q092_ReverseLinkedListIITest extends AbstractTest<Q092_ReverseLinkedListII> {

    @Override
    protected String solveProblem(String input, Q092_ReverseLinkedListII solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.reverseBetween(toList(inputs[0]), toInt(inputs[1]), toInt(inputs[2])));
    }

}
