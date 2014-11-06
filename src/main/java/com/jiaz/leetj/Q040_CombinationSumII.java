package com.jiaz.leetj;

import java.util.*;

// Given a collection of candidate numbers (C) and a target number (T),
// find all unique combinations in C where the candidate numbers sums to T.
//
// Each number in C may only be used once in the combination.
//
// Note:
// All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, … , ak) must be in non-descending order.
// (ie, a1 ≤ a2 ≤ … ≤ ak).
// The solution set must not contain duplicate combinations.
// For example, given candidate set 10,1,2,7,6,1,5 and target 8,
// A solution set is:
// [1, 7]
// [1, 2, 5]
// [2, 6]
// [1, 1, 6]

public class Q040_CombinationSumII {

    private void recSolve(int[] num, int pos, int target, Stack<Integer> stk, List<List<Integer>> res) {
        if (target == 0) {
            // found solution
            List<Integer> list = new ArrayList<>(stk);
            res.add(list);
            return;
        }
        if (pos == num.length || target < 0) {
            // no solution
            return;
        }
        Integer last = null;
        for (int i = pos; i < num.length; ++i) {
            int pick = 0;
            if (last != null) {
                if (num[i] != last) {
                    pick = num[i];
                } else {
                    continue;
                }
            } else {
                pick = num[i];
            }
            stk.push(pick);
            recSolve(num, i + 1, target - pick, stk, res);
            stk.pop();
            last = pick;
        }
    }

    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == null) return result;

        Arrays.sort(num);
        recSolve(num, 0, target, new Stack<Integer>(), result);
        return result;
    }

}
