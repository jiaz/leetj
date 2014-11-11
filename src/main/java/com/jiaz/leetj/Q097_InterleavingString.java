package com.jiaz.leetj;

import java.util.*;

// Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

// For example,
// Given:
// s1 = "aabcc",
// s2 = "dbbca",

// When s3 = "aadbbcbcac", return true.
// When s3 = "aadbbbaccc", return false.

public class Q097_InterleavingString {

    private boolean recCheck(String s1, int pos1, String s2, int pos2, String s3, int pos3) {
        if (pos3 == s3.length()) return true;

        // String d = s1.substring(pos1) + s2.substring(pos2);
        // char[] dchars = d.toCharArray();
        // char[] s3chars = s3.substring(pos3).toCharArray();
        // Arrays.sort(dchars);
        // Arrays.sort(s3chars);
        // if (!Arrays.equals(dchars, s3chars)) {
        //     return false;
        // }

        char t = s3.charAt(pos3);
        if (pos1 < s1.length() && t == s1.charAt(pos1) && recCheck(s1, pos1 + 1, s2, pos2, s3, pos3 + 1)) {
            return true;
        }
        if (pos2 < s2.length() && t == s2.charAt(pos2) && recCheck(s1, pos1, s2, pos2 + 1, s3, pos3 + 1)) {
            return true;
        }
        return false;
    }

    private boolean checkDP(String s1, String s2, String s3) {
        boolean[][] map = new boolean[s1.length() + 1][s2.length() + 1];

        map[0][0] = true;

        for (int i = 0; i <= s1.length(); ++i) {
            for (int j = 0; j <= s2.length(); ++j) {
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    map[i][j] |= map[i - 1][j];
                }
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    map[i][j] |= map[i][j - 1];
                }
            }
        }

        return map[s1.length()][s2.length()];
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        //return recCheck(s1, 0, s2, 0, s3, 0);
        return checkDP(s1, s2, s3);
    }

}
