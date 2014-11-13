package com.jiaz.leetj;

import java.util.*;

// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

// For example,
// Given [100, 4, 200, 1, 3, 2],
// The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

// Your algorithm should run in O(n) complexity.

public class Q128_LongestConsecutiveSequence {

    public int longestConsecutive(int[] num) {
        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < num.length; ++i) {
            int n = num[i];
            int c = 1;
            if (maps.containsKey(n)) continue;

            if (maps.containsKey(n - 1)) {
                c += maps.get(n - 1);
            }
            if (maps.containsKey(n + 1)) {
                c += maps.get(n + 1);
            }
            if (maps.containsKey(n - 1)) {
                int k = n - maps.get(n - 1);
                maps.put(k, c);
            }
            if (maps.containsKey(n + 1)) {
                int k = n + maps.get(n + 1);
                maps.put(k, c);
            }
            maps.put(n, c);
        }
        int max = 0;
        for (Integer v : maps.values()) {
            max = Math.max(max, v);
        }
        return max;
    }

}
