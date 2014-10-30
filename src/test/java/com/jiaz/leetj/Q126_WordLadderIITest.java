package com.jiaz.leetj;

import static com.jiaz.leetj.TestRunner.*;
import java.util.*;

public class Q126_WordLadderIITest extends AbstractTestII<Q126_WordLadderII, List<List<String>>> {

    @Override
    protected boolean verifyResult(List<List<String>> result, String answer) {
        List<List<String>> answerObj = toListOfListOfString(answer);
        if (result.size() != answerObj.size()) return false;
        Comparator<List<String>> cmp = new Comparator<List<String>>() {
            public int compare(List<String> a, List<String> b) {
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
    protected List<List<String>> solveProblem(String input, Q126_WordLadderII solver) {
        String[] inputs = tokenizeInput(input);
        return solver.findLadders(toStr(inputs[0]), toStr(inputs[1]),
            new HashSet<String>(Arrays.asList(toStrArray(inputs[2]))));
    }

}
