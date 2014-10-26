package com.jiaz.leetj;

import java.util.*;

// Validate if a given string is numeric.
//
// Some examples:
// "0" => true
// " 0.1 " => true
// "abc" => false
// "1 a" => false
// "2e10" => true
// Note: It is intended for the problem statement to be ambiguous.
// You should gather all requirements up front before implementing one.

public class Q065_ValidNumber {

    public boolean isNumber(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < s.length() && s.charAt(start) == ' ') start++;
        while (end >= start && s.charAt(end) == ' ') end--;
        if (start > end) return false;

        int i = start;

        // optional +/-
        if (s.charAt(i) == '+' || s.charAt(i) == '-') i++;

        // if nothing else, return false
        if (i > end) return false;

        // scan digits, until meet E or EOS
        boolean hasAtLeastOneDigit = false;
        boolean hasOneDot = false;
        boolean hasExp = false;
        while (i <= end) {
            char c = s.charAt(i);
            i++;
            if (c >= '0' && c <= '9') {
                hasAtLeastOneDigit = true;
            }
            else if (c == '.') {
                if (hasOneDot) return false;
                hasOneDot = true;
            }
            else if (c == 'E' || c == 'e') {
                hasExp = true;
                break;
            }
            else return false;
        }

        // we require at least one digit to continue
        if (!hasAtLeastOneDigit) return false;

        // if nothing else, return true if there is no E
        if (i > end) return !hasExp;

        // optional +/-
        if (s.charAt(i) == '+' || s.charAt(i) == '-') i++;

        hasAtLeastOneDigit = false;
        while (i <= end) {
            char c = s.charAt(i);
            i++;
            if (c >= '0' && c <= '9') {
                hasAtLeastOneDigit = true;
            }
            else return false;
        }
        // at least one digit
        return hasAtLeastOneDigit;
    }

}
