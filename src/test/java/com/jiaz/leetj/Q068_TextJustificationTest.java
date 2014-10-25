package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q068_TextJustificationTest extends AbstractTest<Q068_TextJustification> {

    @Override
    protected String solveProblem(String input, Q068_TextJustification solver) {
        String[] inputs = tokenizeInput(input);
        return serializeList(solver.fullJustify(toStrArray(inputs[0]), toInt(inputs[1])),
            StringSerializer.getInstance());
    }

} 
