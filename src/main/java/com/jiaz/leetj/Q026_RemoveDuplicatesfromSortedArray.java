package com.jiaz.leetj;

import java.util.*;

// Given a sorted array, remove the duplicates in place such that each element
// appear only once and return the new length.
//
// Do not allocate extra space for another array, you must do this in place with
// constant memory.
//
// For example,
// Given input array A = [1,1,2],

// Your function should return length = 2, and A is now [1,2].

public class Q026_RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] A) {
        if (A.length == 0) return 0;
        int current = A[0];
        int pos = 0;
        int head = 1;
        while (head < A.length) {
            if (A[head] != current) {
                pos++;
                A[pos] = A[head];
                current = A[pos];
            }
            head++;
        }
        return pos + 1;
    }

}
