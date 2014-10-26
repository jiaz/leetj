package com.jiaz.leetj;

import java.util.*;

// Given a string S and a string T, count the number of distinct subsequences of T in S.
//
// A subsequence of a string is a new string which is formed from the original string by
// deleting some (can be none) of the characters without disturbing the relative positions
// of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
//
// Here is an example:
// S = "rabbbit", T = "rabbit"
//
// Return 3.

public class Q115_DistinctSubsequences {

    public int numDistinct(String S, String T) {
        int[][] D = new int[S.length() + 1][T.length() + 1];
        for (int i = 0; i <= S.length(); ++i) {
            D[i][0] = 1;
        }
        for (int j = 1; j <= T.length(); ++j) {
            D[0][j] = 0;
        }
        for (int j = 1; j <= T.length(); ++j) {
            for (int i = 1; i <= S.length(); ++i) {
                if (j > i) {
                    D[i][j] = 0;
                } else {
                    if (S.charAt(i - 1) == T.charAt(j - 1)) {
                        D[i][j] = D[i - 1][j - 1] + D[i - 1][j];
                    } else {
                        D[i][j] = D[i - 1][j];
                    }
                }
            }
        }
        return D[S.length()][T.length()];
    }

}
