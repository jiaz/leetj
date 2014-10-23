package com.jiaz.leetj;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// Given a set of candidate numbers (C) and a target number (T), find all unique combinations 
// in C where the candidate numbers sums to T.

// The same repeated number may be chosen from C unlimited number of times.

// Note:
// All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
// The solution set must not contain duplicate combinations.
// For example, given candidate set 2,3,6,7 and target 7, 
// A solution set is: 
// [7] 
// [2, 2, 3] 

public class Q039_CombinationSum {

    private int[] dedup(int[] candidates) {
        int[] res = new int[candidates.length];
        System.arraycopy(candidates, 0, res, 0, candidates.length);
        int pos = 0;
        int next = 0;
        while (next != res.length) {
            if (res[next] == res[pos]) next++;
            else {
                pos++;
                res[pos] = res[next];
            }
        }
        if (pos == res.length - 1) return res;
        else {
            int[] trimRes = new int[pos + 1];
            System.arraycopy(res, 0, trimRes, 0, pos + 1);
            return trimRes;
        }
    }

    private void recCombSum(int[] num, int pos, int target, Stack<Integer> stk, List<List<Integer>> res) {
        if (target == 0) {
            // add to res
            List<Integer> oneRes = new ArrayList<>();
            for (Integer x : stk) {
                oneRes.add(x);
            }
            res.add(oneRes);
            return;
        }
        if (pos >= num.length) return;
        if (num[pos] > target) return;
        int count = 0;
        int v = target;
        while (v >= 0) {
            stk.push(num[pos]);
            v -= num[pos];
            count++;
        }
        for (int i = 0; i < count; ++i) {
            recCombSum(num, pos + 1, target - (count - i) * num[pos], stk, res);
            stk.pop();
        }
        recCombSum(num, pos + 1, target, stk, res);
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int[] num = dedup(candidates);
        Stack<Integer> stk = new Stack<Integer>();
        List<List<Integer>> res = new ArrayList<>();
        recCombSum(num, 0, target, stk, res);
        return res;
    }

}