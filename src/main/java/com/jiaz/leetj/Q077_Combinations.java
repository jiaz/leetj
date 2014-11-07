package com.jiaz.leetj;

import java.util.*;

// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
// For example,
// If n = 4 and k = 2, a solution is:
//
// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]

public class Q077_Combinations {

    private void recComb(int n, int k, int pos, Stack<Integer> stk, List<List<Integer>> res) {
        if (k == 0) {
            List<Integer> oneRes = new ArrayList<>(stk);
            res.add(oneRes);
        } else if (pos + k - 1 == n) {
            List<Integer> oneRes = new ArrayList<>(stk);
            for (int i = pos; i <= n; ++i) {
                oneRes.add(i);
            }
            res.add(oneRes);
        } else {
            stk.push(pos);
            recComb(n, k - 1, pos + 1, stk, res);
            stk.pop();
            recComb(n, k, pos + 1, stk, res);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        recComb(n, k, 1, new Stack<Integer>(), result);
        return result;
    }

}
