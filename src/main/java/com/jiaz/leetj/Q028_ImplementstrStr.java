package com.jiaz.leetj;

import java.util.*;

// Implement strStr().
//
// Returns a pointer to the first occurrence of needle in haystack,
// or null if needle is not part of haystack.

public class Q028_ImplementstrStr {

    private String strStrBruteForce(String p, String t) {
        int pos = -1;
        for (int i = 0; i < p.length() - t.length() + 1; ++i) {
            boolean match = true;
            for (int j = 0; j < t.length(); ++j) {
                if (p.charAt(i + j) != t.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                pos = i;
                break;
            }
        }
        if (pos == -1) return null;
        
        return p.substring(pos);
    }

    public String strStr(String haystack, String needle) {
        return strStrBruteForce(haystack, needle);
    }

}
