package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q058_LengthofLastWordTest extends AbstractTest<Q058_LengthofLastWord> {

    @Override
    protected String solveProblem(String input, Q058_LengthofLastWord solver) {
        return serialize(solver.lengthOfLastWord(toStr(input)));
    }

}
