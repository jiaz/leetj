package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q030_SubstringwithConcatenationofAllWordsTest extends AbstractTest<Q030_SubstringwithConcatenationofAllWords> {

    @Override
    protected String solveProblem(String input, Q030_SubstringwithConcatenationofAllWords solver) {
        String[] inputs = tokenizeInput(input);
        String s = serializeList(solver.findSubstring(toStr(inputs[0]), toStrArray(inputs[1])), IntegerSerializer.getInstance());
        System.out.println(s);
        return s;
    }

}
