package com.jiaz.leetj;

import java.util.*;

// Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
// For example,
// Given n = 3,
//
// You should return the following matrix:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]

public class Q059_SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][];
        for (int i = 0; i < n; ++i) {
            result[i] = new int[n];
        }

        int count = 1;
        int direction = 0;
        int left = 0;
        int right = n - 1;
        int top = 1;
        int bottom = n - 1;
        int i = 0;
        int j = 0;
        while (count <= n * n) {
            // gen value
            result[i][j] = count;

            // check direction change
            if (direction == 0) {
                if (j == right) {
                    direction = 1;
                    right -= 1;
                }
            } else if (direction == 1) {
                if (i == bottom) {
                    direction = 2;
                    bottom -= 1;
                }
            } else if (direction == 2) {
                if (j == left) {
                    direction = 3;
                    left += 1;
                }
            } else if (direction == 3) {
                if (i == top) {
                    direction = 0;
                    top += 1;
                }
            }

            // make move
            if (direction == 0) {
                j++;
            } else if (direction == 1) {
                i++;
            } else if (direction == 2) {
                j--;
            } else if (direction == 3) {
                i--;
            }

            count++;
        }

        return result;
    }

}
