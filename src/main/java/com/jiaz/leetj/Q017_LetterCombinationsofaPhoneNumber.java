package com.jiaz.leetj;

import java.util.List;
import java.util.ArrayList;

// Given a digit string, return all possible letter combinations that the number could represent.

// A mapping of digit to letters (just like on the telephone buttons) is given below.

public class Q017_LetterCombinationsofaPhoneNumber {

    private static final String[] mapping = new String[] {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits.length() == 0) {
            res.add("");
            return res;
        }

        int d = digits.charAt(0) - '0';
        String validChars = mapping[d];

        String restDigits = digits.substring(1);
        List<String> subRes = letterCombinations(restDigits);

        for (int i = 0; i < validChars.length(); ++i) {
            for (int j = 0; j < subRes.size(); ++j) {
                res.add(validChars.charAt(i) + subRes.get(j));
            }
        }

        return res;
    }

}