package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q065_ValidNumberTest extends AbstractTest<Q065_ValidNumber> {

    @Override
    protected String solveProblem(String input, Q065_ValidNumber solver) {
        return serialize(solver.isNumber(toStr(input)));
    }

}
