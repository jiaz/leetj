package com.jiaz.leetj;

import java.util.*;

// Given two sorted integer arrays A and B, merge B into A as one sorted array.
//
// Note:
// You may assume that A has enough space (size that is greater or equal to m + n)
// to hold additional elements from B. The number of elements initialized in A and B
// are m and n respectively.

public class Q088_MergeSortedArray {

    public int[] merge(int[] A, int m, int[] B, int n) {
        int idxA = m - 1;
        int idxB = n - 1;
        int idxNew = m + n - 1;

        while (idxA >= 0 || idxB >= 0) {
            if (idxA >= 0 && idxB >= 0) {
                if (A[idxA] > B[idxB]) {
                    A[idxNew] = A[idxA];
                    idxA--;
                } else {
                    A[idxNew] = B[idxB];
                    idxB--;
                }
            } else if (idxA >= 0) {
                A[idxNew] = A[idxA];
                idxA--;
            } else {
                A[idxNew] = B[idxB];
                idxB--;
            }
            idxNew--;
        }

        return A;
    }

}
