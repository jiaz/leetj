package com.jiaz.leetj;

import java.util.*;

// Given a string, determine if it is a palindrome, considering only alphanumeric
// characters and ignoring cases.
//
// For example,
// "A man, a plan, a canal: Panama" is a palindrome.
// "race a car" is not a palindrome.
//
// Note:
// Have you consider that the string might be empty? This is a good question to
// ask during an interview.
//
// For the purpose of this problem, we define empty string as valid palindrome.

public class Q125_ValidPalindrome {

    private boolean isAlphabetic(char c) {
        if (c >= 'a' && c <= 'z') return true;
        if (c >= 'A' && c <= 'Z') return true;
        return false;
    }

    private boolean isNumeric(char c) {
        return c >= '0' && c <= '9';
    }

    private char tolower(char c) {
        if (c >= 'A' && c <= 'Z') return (char)(c - 'A' + 'a');
        return c;
    }

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char f = s.charAt(start);
            char e = s.charAt(end);
            if (!isAlphabetic(f) && !isNumeric(f)) {
                start++;
            } else if (!isAlphabetic(e) && !isNumeric(e)) {
                end--;
            } else {
                if (isAlphabetic(e) && isAlphabetic(f)) {
                    if (tolower(e) != tolower(f)) return false;
                } else if (isNumeric(e) && isNumeric(f)) {
                    if (e != f) return false;
                } else {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

}
