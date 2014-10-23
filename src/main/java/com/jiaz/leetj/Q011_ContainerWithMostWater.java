package com.jiaz.leetj;

// Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
// n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
// Find two lines, which together with x-axis forms a container, such that the container contains the most water.

// Note: You may not slant the container.

public class Q011_ContainerWithMostWater {
    
    public int maxArea(int[] height) {
        if (height.length < 2) return 0;

        int leftPos = 0;
        int rightPos = height.length - 1;
        int leftH = 0;
        int rightH = 0;
        int maxA = 0;

        while (leftPos < rightPos) {
            if (leftH >= height[leftPos]) {
                leftPos++;
            } else if (rightH >= height[rightPos]) {
                rightPos--;
            } else {
                int A;
                if (height[leftPos] < height[rightPos]) {
                    leftH = height[leftPos];
                    A = (rightPos - leftPos) * leftH;
                    leftPos++;
                } else {
                    rightH = height[rightPos];
                    A = (rightPos - leftPos) * rightH;
                    rightPos--;
                }
                if (A > maxA) maxA = A;
            }
        }

        return maxA;
    }

}