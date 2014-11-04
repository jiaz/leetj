package com.jiaz.leetj;

import java.util.*;

// The set [1,2,3,…,n] contains a total of n! unique permutations.
//
// By listing and labeling all of the permutations in order,
// We get the following sequence (ie, for n = 3):
//
// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.
//
// Note: Given n will be between 1 and 9 inclusive.

public class Q060_PermutationSequence {

    public String getPermutation(int n, int k) {
        int[] counts = new int[10];
        counts[0] = 1;
        counts[1] = 1;
        for (int i = 2; i <= 9; ++i) {
            counts[i] = counts[i - 1] * i;
        }
        boolean[] map = new boolean[n];
        for (int i = 0; i < n; ++i) map[i] = false;
        k--;

        StringBuilder sb = new StringBuilder();

        for (int d = 0; d < n; ++d) {
            int m = counts[n - d - 1];
            int p = k / m + 1;
            int e = 0;
            while (p > 0) {
                if (map[e] == false) {
                    p--;
                }
                if (p <= 0) break;
                e++;
            }
            k %= m;
            map[e] = true;
            sb.append((char)('1' + e));
        }

        return sb.toString();
    }

}
