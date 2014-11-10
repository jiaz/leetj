package com.jiaz.leetj;

import java.util.*;

// Follow up for "Remove Duplicates": Q026
// What if duplicates are allowed at most twice?

// For example,
// Given sorted array A = [1,1,1,2,2,3],

// Your function should return length = 5, and A is now [1,1,2,2,3].

public class Q080_RemoveDuplicatesfromSortedArrayII {

    public int removeDuplicates(int[] A) {
        if (A.length <= 2) return A.length;

        int pos = 1;
        int head = 1;
        int seeCount = 1;
        while (head < A.length) {
            if (A[head] == A[pos - 1]) {
                if (seeCount < 2) {
                    seeCount++;
                    A[pos] = A[head];
                    pos++;
                }
            } else {
                A[pos] = A[head];
                seeCount = 1;
                pos++;
            }
            head++;
        }

        return pos;
    }

}
