package com.jiaz.leetj;

import java.util.*;

// Follow up for "Search in Rotated Sorted Array": Q033
// What if duplicates are allowed?

// Would this affect the run-time complexity? How and why?

// Write a function to determine if a given target is in the array.

public class Q081_SearchinRotatedSortedArrayII {

    public boolean search(int[] A, int target) {
        int left = 0;
        int right = A.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) return true;
            if (A[left] < A[mid]) {
                // left side is increasing
                if (A[left] <= target && A[mid] > target) {
                    // continue in left
                    right = mid;
                } else {
                    // continue in right
                    left = mid + 1;
                }
            } else if (A[left] > A[mid]) {
                // right side is increasing
                if (A[mid] < target && target <= A[right - 1]) {
                    // continue in right
                    left = mid + 1;
                } else {
                    // continue in left;
                    right = mid;
                }
            } else {
                left++;
            }
        }
        return false;
    }

}
