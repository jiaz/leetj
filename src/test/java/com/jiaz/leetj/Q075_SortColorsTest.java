package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q075_SortColorsTest extends AbstractTest<Q075_SortColors> {

    @Override
    protected String solveProblem(String input, Q075_SortColors solver) {
        return serialize(solver.sortColors(toIntArray(input)));
    }

}
