package com.jiaz.leetj;

import java.util.*;

// Given a string s consists of upper/lower-case alphabets and empty space
// characters ' ', return the length of last word in the string.
//
// If the last word does not exist, return 0.
//
// Note: A word is defined as a character sequence consists of non-space
// characters only.
//
// For example,
// Given s = "Hello World",
// return 5.

public class Q058_LengthofLastWord {

    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0) {
            if (s.charAt(end) == ' ') end--;
            else break;
        }
        if (end < 0) return 0;

        int len = 0;
        while (end >= 0 && s.charAt(end) != ' ') {
            len++;
            end--;
        }
        return len;
    }

}
