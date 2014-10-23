package com.jiaz.leetj;

import static com.jiaz.leetj.TestRunner.*;

public class Q017_LetterCombinationsofaPhoneNumberTest extends AbstractTest<Q017_LetterCombinationsofaPhoneNumber> {

    @Override
    protected String solveProblem(String input, Q017_LetterCombinationsofaPhoneNumber solver) {
        return serializeList(solver.letterCombinations(toStr(input)), StringSerializer.getInstance());
    }

} 
