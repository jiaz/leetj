package com.jiaz.leetj;

import java.util.*;

// Given a m x n grid filled with non-negative numbers, find a path from top 
// left to bottom right which minimizes the sum of all numbers along its path.

// Note: You can only move either down or right at any point in time.

public class Q064_MinimumPathSum {
    
    public int minPathSum(int[][] grid) {
        int n = 0;
        int m = 0;
        int[][] map = new int[grid.length][];
        m = map.length;
        for (int i = 0; i < map.length; ++i) {
            map[i] = new int[grid[i].length];
            n = map[i].length;  // all n should be the same
            for (int j = 0; j < map[i].length; ++j) {
                map[i][j] = 0;
            }
        }

        map[0][0] = grid[0][0];
        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                int min = -1;
                if (r > 0) {
                    min = map[r - 1][c];
                }
                if (c > 0) {
                    if (min == -1 || min > map[r][c - 1]) min = map[r][c - 1];
                }
                if (r != 0 || c != 0) {
                    map[r][c] = min + grid[r][c];
                }
            }
        }

        return map[m - 1][n - 1];
    }

}