package com.jiaz.leetj;

import java.util.*;

// Given n non-negative integers representing an elevation map where the width
// of each bar is 1, compute how much water it is able to trap after raining.
//
// For example,
// Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

public class Q042_TrappingRainWater {

    public int trap(int[] A) {
        if (A == null || A.length == 0) return 0;

        int peekPos = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] > A[peekPos]) {
                peekPos = i;
            }
        }

        int sum = 0;
        // left to right
        int currentLevel = A[0];
        for (int i = 0; i < peekPos; ++i) {
            if (A[i] > currentLevel) {
                currentLevel = A[i];
            } else if (A[i] < currentLevel) {
                sum += (currentLevel - A[i]);
            }
        }

        currentLevel = A[A.length - 1];
        for (int i = A.length - 1; i > peekPos; --i) {
            if (A[i] > currentLevel) {
                currentLevel = A[i];
            } else if (A[i] < currentLevel) {
                sum += (currentLevel - A[i]);
            }
        }

        return sum;
    }

}
