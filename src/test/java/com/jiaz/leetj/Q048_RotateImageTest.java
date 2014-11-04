package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q048_RotateImageTest extends AbstractTest<Q048_RotateImage> {

    @Override
    protected String solveProblem(String input, Q048_RotateImage solver) {
        String res = serialize(solver.rotate(toArrayOfIntArray(input)));

        System.out.println(res);
        return res;
    }

}
