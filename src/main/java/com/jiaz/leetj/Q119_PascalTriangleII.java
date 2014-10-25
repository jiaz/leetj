package com.jiaz.leetj;

import java.util.*;

// Given an index k, return the kth row of the Pascal's triangle.

// For example, given k = 3,
// Return [1,3,3,1].

// Note:
// Could you optimize your algorithm to use only O(k) extra space?

public class Q119_PascalTriangleII {
    
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex);
        for (int i = 0; i <= rowIndex; ++i) {
            result.add(0);
        }
        for (int i = 0; i <= rowIndex; ++i) {
            for (int j = rowIndex; j >= 0; --j) {
                if (j == 0 || j == rowIndex) {
                    result.set(j, 1);
                } else {
                    result.set(j, result.get(j) + result.get(j - 1));
                }
            }
        }
        return result;
    }

}