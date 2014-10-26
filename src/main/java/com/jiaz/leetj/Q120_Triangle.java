package com.jiaz.leetj;

import java.util.*;

// Given a triangle, find the minimum path sum from top to bottom.
// Each step you may move to adjacent numbers on the row below.
//
// For example, given the following triangle
// [
//      [2],
//     [3,4],
//    [6,5,7],
//   [4,1,8,3]
// ]
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
//
// Note:
// Bonus point if you are able to do this using only O(n) extra space,
// where n is the total number of rows in the triangle.

public class Q120_Triangle {

    private int min(int a, int b) {
        return a < b ? a : b;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;

        int[] sum = new int[triangle.size()];
        int i = 0;
        for (List<Integer> row : triangle) {
            if (i == 0) {
                sum[i] = row.get(0);
            } else {
                for (int j = row.size() - 1; j >= 0; --j) {
                    if (j == row.size() - 1) {
                        sum[j] = sum[j - 1] + row.get(j);
                    } else if (j == 0) {
                        sum[j] = sum[j] + row.get(j);
                    } else {
                        sum[j] = min(sum[j - 1], sum[j]) + row.get(j);
                    }
                }
            }
            ++i;
        }
        int min = sum[0];
        for (int j = 1; j < triangle.size(); ++j) {
            if (min > sum[j]) min = sum[j];
        }
        return min;
    }

}
