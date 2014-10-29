package com.jiaz.leetj;

import java.util.*;

// Given n non-negative integers representing the histogram's bar height
// where the width of each bar is 1, find the area of largest rectangle in the histogram.
//
// For example,
// Given height = [2,1,5,6,2,3],
// return 10.

public class Q084_LargestRectangleinHistogram {

    private int max(int a, int b) {
        return a < b ? b : a;
    }

    public int largestRectangleArea(int[] height) {
        int L = 0;
        Stack<Integer> stk = new Stack<>();
        int i = 0;
        while (i < height.length) {
            if (stk.isEmpty() || height[i] >= height[stk.peek()]) {
                stk.push(i);
                i++;
            } else {
                int x = stk.pop();
                L = max(L, (i - (stk.isEmpty() ? 0 : stk.peek() + 1)) * height[x]);
            }
        }
        while (!stk.isEmpty()) {
            int x = stk.pop();
            L = max(L, (height.length - (stk.isEmpty() ? 0 : stk.peek() + 1)) * height[x]);
        }
        return L;
    }

}
