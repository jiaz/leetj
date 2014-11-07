package com.jiaz.leetj;

import java.util.*;

// Follow up for "Unique Paths":
//
// Now consider if some obstacles are added to the grids. How many unique paths would there be?
//
// An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
// For example,
// There is one obstacle in the middle of a 3x3 grid as illustrated below.
//
// [
//   [0,0,0],
//   [0,1,0],
//   [0,0,0]
// ]
// The total number of unique paths is 2.
//
// Note: m and n will be at most 100.

public class Q063_UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] map = new int[m][n];

        boolean hasObstacle = false;
        for (int i = 0; i < m; ++i) {
            if (obstacleGrid[i][0] == 1) {
                hasObstacle = true;
            }
            map[i][0] = hasObstacle ? 0 : 1;
        }
        hasObstacle = false;
        for (int j = 0; j < n; ++j) {
            if (obstacleGrid[0][j] == 1) {
                hasObstacle = true;
            }
            map[0][j] = hasObstacle ? 0 : 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                int sum = 0;
                if (obstacleGrid[i][j] == 0) {
                    sum += map[i - 1][j];
                    sum += map[i][j - 1];
                }
                map[i][j] = sum;
            }
        }
        return map[m - 1][n - 1];
    }

}
