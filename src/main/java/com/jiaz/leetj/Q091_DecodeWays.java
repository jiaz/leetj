package com.jiaz.leetj;

import java.util.*;

// A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// Given an encoded message containing digits, determine the total number of ways to decode it.
//
// For example,
// Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//
// The number of ways decoding "12" is 2.

public class Q091_DecodeWays {

    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        if (s.charAt(0) == '0') return 0;

        int[] sum = new int[s.length()];
        sum[0] = 1;
        for (int i = 1; i < s.length(); ++i) {
            int subsum = 0;
            int x = (int)(s.charAt(i) - '0');
            if (x != 0) {
                subsum += sum[i - 1];
            }
            int y = (int)(s.charAt(i - 1) - '0');
            if (y != 0) {
                int d = y * 10 + x;
                if (d >= 1 && d <= 26) {
                    subsum += (i >= 2 ? sum[i - 2] : 1);
                }
            }
            if (subsum == 0) return 0;
            sum[i] = subsum;
        }
        return sum[sum.length - 1];
    }

}
