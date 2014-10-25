package com.jiaz.leetj;

import java.util.*;

// Given a matrix of m x n elements (m rows, n columns), return all 
// elements of the matrix in spiral order.

// For example,
// Given the following matrix:

// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// You should return [1,2,3,6,9,8,7,4,5].

public class Q054_SpiralMatrix {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int step = 0;
        int m = matrix.length;
        if (m == 0) {
            return result;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return result;
        }

        int L = 0;
        int R = n - 1;
        int T = 1;
        int B = m - 1;
        int direction = 0;
        int r = 0;
        int c = 0;

        while (true) {
            result.add(matrix[r][c]);
            step++;
            if (step >= m * n) break;
            // check
            switch (direction) {
                case 0:
                    if (c == R) {
                        direction = 1;
                        R--;
                    }
                    break;
                case 1:
                    if (r == B) {
                        direction = 2;
                        B--;
                    }
                    break;
                case 2:
                    if (c == L) {
                        direction = 3;
                        L++;
                    }
                    break;
                case 3:
                    if (r == T) {
                        direction = 0;
                        T++;
                    }
                    break;
                default:
                    break;
            }
            // move
            switch (direction) {
                case 0:
                    c++;
                    break;
                case 1:
                    r++;
                    break;
                case 2:
                    c--;
                    break;
                case 3:
                    r--;
                    break;
                default:
                    break;
            }
        }
        return result;
    }

}