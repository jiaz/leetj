package com.jiaz.leetj;

import java.util.*;

// Given a string s1, we may represent it as a binary tree by partitioning it to
// two non-empty substrings recursively.
//
// Below is one possible representation of s1 = "great":
//
//     great
//    /    \
//   gr    eat
//  / \    /  \
// g   r  e   at
//            / \
//           a   t
// To scramble the string, we may choose any non-leaf node and swap its two
// children.
//
// For example, if we choose the node "gr" and swap its two children, it
// produces a scrambled string "rgeat".
//
//     rgeat
//    /    \
//   rg    eat
//  / \    /  \
// r   g  e   at
//            / \
//           a   t
// We say that "rgeat" is a scrambled string of "great".
//
// Similarly, if we continue to swap the children of nodes "eat" and "at", it
// produces a scrambled string "rgtae".
//
//     rgtae
//    /    \
//   rg    tae
//  / \    /  \
// r   g  ta  e
//        / \
//       t   a
// We say that "rgtae" is a scrambled string of "great".
//
// Given two strings s1 and s2 of the same length, determine if s2 is a
// scrambled string of s1.

public class Q087_ScrambleString {

    private boolean recScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if (!Arrays.equals(c1, c2)) return false;

        int l = s1.length();
        for (int i = 1; i < l; ++i) {
            String left1 = s1.substring(0, i);
            String left2 = s2.substring(0, i);
            String right1 = s1.substring(i, l);
            String right2 = s2.substring(i, l);
            if (recScramble(left1, left2) && recScramble(right1, right2)) {
                return true;
            }

            left1 = s1.substring(0, i);
            right1 = s2.substring(l - i, l);
            left2 = s1.substring(i, l);
            right2 = s2.substring(0, l - i);
            if (recScramble(left1, right1) && recScramble(left2, right2)) {
                return true;
            }
        }
        return false;
    }

    public boolean isScramble(String s1, String s2) {
        if (s1 == null && s2 == null) return true;
        return recScramble(s1, s2);
    }

}
