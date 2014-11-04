package com.jiaz.leetj;

import java.util.*;

// You are given an n x n 2D matrix representing an image.

// Rotate the image by 90 degrees (clockwise).

// Follow up:
// Could you do this in-place?

public class Q048_RotateImage {

    private void rotatePoint(int[][] m, int i, int j) {
        int N = m.length;

        int x = m[i][j];

        m[i][j] = m[N - j - 1][i];
        m[N - j - 1][i] = m[N - i - 1][N - j - 1];
        m[N - i - 1][N - j - 1] = m[j][N - i - 1];
        m[j][N - i - 1] = x;
    }

    public int[][] rotate(int[][] matrix) {
        for (int k = 0; k < matrix.length / 2; ++k) {
            for (int j = 0; j < matrix.length - 2 * k - 1; ++j) {
                rotatePoint(matrix, k, k + j);
            }
        }
        return matrix;
    }

}
