package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q038_CountandSayTest extends AbstractTest<Q038_CountandSay> {

    @Override
    protected String solveProblem(String input, Q038_CountandSay solver) {
        return serialize(solver.countAndSay(toInt(input)));
    }

} 
