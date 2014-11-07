package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q046_PermutationsTest extends AbstractTestII<Q046_Permutations, List<List<Integer>>> {

    @Override
    protected boolean verifyResult(List<List<Integer>> result, String answer) {
        List<List<Integer>> answerObj = toListOfListOfInt(answer);
        if (result.size() != answerObj.size()) return false;
        Comparator<List<Integer>> cmp = new Comparator<List<Integer>>() {
            public int compare(List<Integer> a, List<Integer> b) {
                if (a.size() != b.size()) return a.size() < b.size() ? -1 : 1;

                for (int i = 0; i < a.size(); ++i) {
                    int x = a.get(i).compareTo(b.get(i));
                    if (x == 0) continue;
                    return x;
                }
                return 0;
            }
        };
        Collections.sort(answerObj, cmp);
        Collections.sort(result, cmp);
        for (int i = 0; i < answerObj.size(); ++i) {
            if (cmp.compare(answerObj.get(i), result.get(i)) != 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected List<List<Integer>> solveProblem(String input, Q046_Permutations solver) {
        return solver.permute(toIntArray(input));
    }
}
