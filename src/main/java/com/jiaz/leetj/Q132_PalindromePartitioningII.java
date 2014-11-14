package com.jiaz.leetj;

import java.util.*;

// Given a string s, partition s such that every substring of the partition is a palindrome.
//
// Return the minimum cuts needed for a palindrome partitioning of s.
//
// For example, given s = "aab",
// Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

public class Q132_PalindromePartitioningII {

    private boolean[][] pal;
    private int[] min;

    private void genPal(String s) {
        for (int i = 0; i < s.length(); ++i) {
            // i as center
            for (int j = 0; i - j >= 0 && i + j < s.length(); ++j) {
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    pal[i - j][i + j] = true;
                } else {
                    break;
                }
            }
            // i as left center
            for (int j = 0; i - j >= 0 && i + j + 1 < s.length(); ++j) {
                if (s.charAt(i - j) == s.charAt(i + j + 1)) {
                    pal[i - j][i + j + 1] = true;
                } else {
                    break;
                }
            }
        }
    }

    private void calcMin() {
        min[0] = 0;
        for (int i = 1; i < min.length; ++i) {
            if (pal[0][i]) {
                min[i] = 0;
            } else {
                int m = i + 1;
                for (int j = 0; j < i; j++) {
                    if (pal[j + 1][i]) {
                        m = Math.min(m, min[j] + 1);
                    }
                }
                min[i] = m;
            }
        }
    }

    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;

        pal = new boolean[s.length()][s.length()];
        min = new int[s.length()];

        genPal(s);
        calcMin();

        return min[s.length() - 1];
    }

}
