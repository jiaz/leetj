package com.jiaz.leetj;

import java.util.*;

// Find the contiguous subarray within an array (containing at least one number)
// which has the largest sum.
//
// For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
// the contiguous subarray [4,−1,2,1] has the largest sum = 6.

public class Q053_MaximumSubarray {

    private int max(int a, int b) {
        return a < b ? b : a;
    }
    private int min(int a, int b) {
        return a < b ? a : b;
    }

    public int maxSubArray(int[] A) {
        return maxSubArrayPrefix(A);
    }

    private int maxSubArray1(int[] A) {
        int r = A[0];
        int imax = r;
        for (int i = 1; i < A.length; ++i) {
            imax = max(A[i], imax + A[i]);
            r = max(r, imax);
        }
        return r;
    }

    private int maxSubArrayPrefix(int[] A) {
        int p = A[0];
        int minp = min(0, p);
        int r = p;
        for (int i = 1; i < A.length; ++i) {
            p += A[i];
            if (p - minp > r) r = p - minp;
            if (p < minp) minp = p;
        }
        return r;
    }

}
