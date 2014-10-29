package com.jiaz.leetj;

import java.util.*;

public class Q073_SetMatrixZeroes {

    public int[][] setZeroes(int[][] matrix) {
        if (matrix.length == 0) return matrix;

        boolean firstRowZero = false;
        boolean firstColZero = false;
        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[i][0] == 0) firstColZero = true;
        }
        for (int i = 0; i < matrix[0].length; ++i) {
            if (matrix[0][i] == 0) firstRowZero = true;
        }

        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[i].length; ++j) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRowZero == true) {
            for (int i = 0; i < matrix[0].length; ++i) {
                matrix[0][i] = 0;
            }
        }
        if (firstColZero == true) {
            for (int j = 0; j < matrix.length; ++j) {
                matrix[j][0] = 0;
            }
        }

        return matrix;
    }

}
