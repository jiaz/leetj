package com.jiaz.leetj;

import java.util.*;

// Given a string S and a string T, find the minimum window in S which will
// contain all the characters in T in complexity O(n).
//
// For example,
// S = "ADOBECODEBANC"
// T = "ABC"
// Minimum window is "BANC".
//
// Note:
// If there is no such window in S that covers all characters in T, return the
// emtpy string "".
//
// If there are multiple such windows, you are guaranteed that there will always
// be only one unique minimum window in S.

public class Q076_MinimumWindowSubstring {

    public String minWindow(String S, String T) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> target = new HashMap<>();
        for (int i = 0; i < T.length(); ++i) {
            int d = (int)T.charAt(i);
            map.put(d, 0);
            if (target.containsKey(d)) {
                target.put(d, target.get(d) + 1);
            } else {
                target.put(d, 1);
            }
        }
        int count = 0;
        int i = 0;
        int j = -1;
        int currentMinI = -1;
        int currentMinJ = -1;
        while (i < S.length() && j < S.length()) {
            if (count < map.size()) {
                // moving j forward
                j++;
                if (j >= S.length()) break;
                int d = (int)(S.charAt(j));
                if (map.containsKey(d)) {
                    if (map.get(d) == target.get(d) - 1) {
                        count++;
                    }
                    map.put(d, map.get(d) + 1);
                }
            } else {
                // moving i forward
                int d = (int)(S.charAt(i));
                if (map.containsKey(d)) {
                    if (map.get(d).equals(target.get(d))) {
                        count--;
                        // i is the last char, check length
                        if (currentMinI == -1 || j - i < currentMinJ - currentMinI) {
                            currentMinI = i;
                            currentMinJ = j;
                        }
                    }
                    map.put(d, map.get(d) - 1);
                }
                i++;
            }
        }
        if (currentMinI == -1) return "";
        return S.substring(currentMinI, currentMinJ + 1);
    }

}
