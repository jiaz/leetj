package com.jiaz.leetj;

import java.util.*;

// Given numRows, generate the first numRows of Pascal's triangle.

// For example, given numRows = 5,
// Return

// [
//      [1],
//     [1,1],
//    [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]

public class Q118_PascalTriangle {
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows < 1) return result;
        for (int i = 0; i < numRows; ++i) {
            List<Integer> line = new ArrayList<>();
            List<Integer> prevLine = null;
            if (i > 0) prevLine = result.get(i - 1);
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    line.add(1);
                } else {
                    line.add(prevLine.get(j - 1) + prevLine.get(j));
                }
            }
            result.add(line);
        }
        return result;
    }

}