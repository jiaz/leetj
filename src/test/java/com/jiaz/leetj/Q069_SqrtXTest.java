package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q069_SqrtXTest extends AbstractTest<Q069_SqrtX> {

    @Override
    protected String solveProblem(String input, Q069_SqrtX solver) {
        return serialize(solver.sqrt(toInt(input)));
    }

} 
