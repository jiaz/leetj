package com.jiaz.leetj;

import java.util.*;

// Given an array with n objects colored red, white or blue, sort them so that
// objects of the same color are adjacent, with the colors in the order red, white
// and blue.
//
// Here, we will use the integers 0, 1, and 2 to represent the color red, white,
// and blue respectively.
//
// Note:
// You are not suppose to use the library's sort function for this problem.

public class Q075_SortColors {

    private void swap(int[] A, int a, int b) {
        if (a == b) return;
        int t = A[a];
        A[a] = A[b];
        A[b] = t;
    }

    public int[] sortColors(int[] A) {
        int head = 0;
        int stackbase = A.length;
        int stacktop = A.length;
        while (head < stacktop) {
            if (A[head] == 0) {
                head++;
            } else {
                if (A[head] == 1) {
                    stacktop--;
                    // swap head and stacktop
                    swap(A, head, stacktop);
                } else {
                    stacktop--;
                    stackbase--;
                    // swap head and stacktop
                    swap(A, head, stacktop);
                    swap(A, stacktop, stackbase);
                }
            }
        }
        return A;
    }

}
