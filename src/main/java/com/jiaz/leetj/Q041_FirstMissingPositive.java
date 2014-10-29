package com.jiaz.leetj;

import java.util.*;

// Given an unsorted integer array, find the first missing positive integer.

// For example,
// Given [1,2,0] return 3,
// and [3,4,-1,1] return 2.

// Your algorithm should run in O(n) time and uses constant space.

public class Q041_FirstMissingPositive {

    private void swap(int[] A, int a, int b) {
        int x = A[a];
        A[a] = A[b];
        A[b] = x;
    }

    public int firstMissingPositive(int[] A) {
        boolean foundLargest = false;
        int pos = 0;
        while (pos < A.length) {
            if (A[pos] != pos) {
                if (A[pos] == A.length) {
                    foundLargest = true;
                    pos++;
                } else if (A[pos] < 0 || A[pos] > A.length || A[pos] == A[A[pos]]) {
                    pos++;
                } else {
                    swap(A, A[pos], pos);
                }
            } else {
                pos++;
            }
        }
        for (int i = 1; i < A.length; ++i) {
            if (A[i] != i) return i;
        }
        if (foundLargest) return A.length + 1;
        return A.length == 0 ? 1 : A.length;
    }

}
