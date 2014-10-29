package com.jiaz.leetj;

import java.util.*;

// Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
// containing all ones and return its area.

public class Q085_MaximalRectangle {

    private int max(int a, int b) {
        return a < b ? b : a;
    }

    public int maximalRectangle(char[][] matrix) {
        int[][] histmap = new int[matrix.length][];
        for (int i = 0; i < matrix.length; ++i) {
            histmap[i] = new int[matrix[i].length];
            for (int j = 0; j < histmap[i].length; ++j) {
                histmap[i][j] = -1;
            }
        }
        int L = 0;
        for (int i = 0; i < matrix.length; ++i) {
            // go through row i
            Stack<Integer> stk = new Stack<>();
            int j = 0;
            while (j < matrix[i].length) {
                if (histmap[i][j] == -1) {
                    // explore histmap
                    if (matrix[i][j] == '0') {
                        histmap[i][j] = 0;
                    } else {
                        int k = i;
                        while (k < matrix.length && matrix[k][j] == '1') k++;
                        for (int l = i; l < k; ++l) {
                            histmap[l][j] = k - l;
                            System.out.println(histmap[l][j]);
                        }
                    }
                }
                // calculate max area
                if (stk.isEmpty() || histmap[i][stk.peek()] <= histmap[i][j]) {
                    stk.push(j);
                    j++;
                } else {
                    int x = stk.pop();
                    L = max(L, (j - (stk.isEmpty() ? 0 : stk.peek() + 1)) * histmap[i][x]);
                }
            }
            while (!stk.isEmpty()) {
                int x = stk.pop();
                L = max(L, (histmap[i].length - (stk.isEmpty() ? 0 : stk.peek() + 1)) * histmap[i][x]);
            }
        }
        return L;
    }

}
