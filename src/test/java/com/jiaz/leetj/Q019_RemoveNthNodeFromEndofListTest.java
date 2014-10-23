package com.jiaz.leetj;

import static com.jiaz.leetj.TestRunner.*;

public class Q019_RemoveNthNodeFromEndofListTest extends AbstractTest<Q019_RemoveNthNodeFromEndofList> {

    @Override
    protected String solveProblem(String input, Q019_RemoveNthNodeFromEndofList solver) {
        String[] inputs = tokenizeInput(input);
        return serialize(solver.removeNthFromEnd(toList(inputs[0]), toInt(inputs[1])));
    }

} 
