package com.jiaz.leetj;

import static com.jiaz.leetj.TestRunner.*;

public class Q003_LongestSubstringWithoutRepeatingCharactersTest extends AbstractTest<Q003_LongestSubstringWithoutRepeatingCharacters> {

    @Override
    protected String solveProblem(String input, Q003_LongestSubstringWithoutRepeatingCharacters solver) {
        return serialize(solver.lengthOfLongestSubstring(toStr(input)));
    }

} 
