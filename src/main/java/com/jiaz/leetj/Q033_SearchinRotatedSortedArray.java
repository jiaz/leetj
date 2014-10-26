package com.jiaz.leetj;

import java.util.*;

// Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
// You are given a target value to search. If found in the array return its index, otherwise return -1.
//
// You may assume no duplicate exists in the array.

public class Q033_SearchinRotatedSortedArray {

    public int search(int[] A, int target) {
        int L = 0;
        int R = A.length;
        while (R - L > 0) {
            int m = (L + R) / 2;
            if (A[m] == target) return m;
            else if (A[m] < target) {
                if (A[L] > A[m]) {
                    if (A[L] > target) {
                        L = m + 1;
                    } else if (A[L] < target) {
                        L += 1;
                        R = m;
                    } else {
                        return L;
                    }
                } else {
                    L = m + 1;
                }
            } else {
                if (A[L] > A[m]) {
                    L += 1;
                    R = m;
                } else {
                    if (A[L] > target) {
                        L = m + 1;
                    } else if (A[L] < target) {
                        L += 1;
                        R = m;
                    } else {
                        return L;
                    }
                }
            }
        }
        return -1;
    }

}
