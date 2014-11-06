package com.jiaz.leetj;

import java.util.*;

// Given a sorted array and a target value, return the index if the target is found.
// If not, return the index where it would be if it were inserted in order.
//
// You may assume no duplicates in the array.
//
// Here are few examples.
// [1,3,5,6], 5 → 2
// [1,3,5,6], 2 → 1
// [1,3,5,6], 7 → 4
// [1,3,5,6], 0 → 0

public class Q035_SearchInsertPosition {

    public int searchInsert(int[] A, int target) {
        int begin = 0;
        int end = A.length;
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            int x = A[mid];
            if (x == target) return mid;
            else if (x > target) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return end;
    }

}
