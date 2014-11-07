package com.jiaz.leetj;

import java.util.*;
import static com.jiaz.leetj.TestRunner.*;

public class Q049_AnagramsTest extends AbstractTestII<Q049_Anagrams, List<String>> {

    @Override
    protected boolean verifyResult(List<String> result, String answer) {
        String[] answerObj = toStrArray(answer);
        List<String> answerList = new ArrayList<>();
        for (int i = 0; i < answerObj.length; ++i) answerList.add(answerObj[i]);

        Collections.sort(answerList);
        Collections.sort(result);
        for (int i = 0; i < answerList.size(); ++i) {
            if (!result.get(i).equals(answerList.get(i))) return false;
        }
        return true;
    }

    @Override
    protected List<String> solveProblem(String input, Q049_Anagrams solver) {
        return solver.anagrams(toStrArray(input));
    }

}
