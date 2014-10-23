package com.jiaz.leetj;

import java.util.*;
import java.util.function.*;

// Write an efficient algorithm that searches for a value in an m x n matrix.
// This matrix has the following properties:

// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
// For example,

// Consider the following matrix:

// [
//   [1,   3,  5,  7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 50]
// ]
// Given target = 3, return true.

public class Q074_Searcha2DMatrix {

    public int binarySearchLessThanOrEqualTo(int target,
        Function<Integer, Integer> getValue, int length) {
        int begin = 0; int end = length;
        while (end - begin > 1) {
            int mid = (begin + end) / 2;
            int x = getValue.apply(mid);
            if (x == target) return mid;
            else if (x < target) {
                begin = mid;
            } else {
                end = mid;
            }
        }
        if (getValue.apply(begin) <= target) {
            return begin;
        } else {
            return -1;
        }
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int ridx = binarySearchLessThanOrEqualTo(target, x -> matrix[x][0], matrix.length);
        if (ridx == -1) return false;

        int p = binarySearchLessThanOrEqualTo(target, x -> matrix[ridx][x], matrix[ridx].length);
        return matrix[ridx][p] == target;
    }

}