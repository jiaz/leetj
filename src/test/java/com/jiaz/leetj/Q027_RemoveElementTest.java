package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q027_RemoveElementTest extends AbstractTest<Q027_RemoveElement> {

    @Override
    protected String solveProblem(String input, Q027_RemoveElement solver) {
        String[] inputs = tokenizeInput(input);
        int[] src = toIntArray(inputs[0]);
        int len = solver.removeElement(src, toInt(inputs[1]));
        int[] res = new int[len];
        if (len > 0) System.arraycopy(src, 0, res, 0, len);
        return serialize(res);
    }

}
