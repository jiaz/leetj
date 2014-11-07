package com.jiaz.leetj;

import java.util.*;

// Given a set of distinct integers, S, return all possible subsets.
//
// Note:
// Elements in a subset must be in non-descending order.
// The solution set must not contain duplicate subsets.
// For example,
// If S = [1,2,3], a solution is:
//
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]

public class Q078_Subsets {

    private void recSubSet(int[] S, int pos, Stack<Integer> stk, List<List<Integer>> res) {
        if (pos == S.length) {
            List<Integer> oneRes = new ArrayList<>(stk);
            res.add(oneRes);
        } else {
            recSubSet(S, pos+1, stk, res);

            stk.push(S[pos]);
            recSubSet(S, pos+1, stk, res);
            stk.pop();
        }
    }

    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> result = new ArrayList<>();
        recSubSet(S, 0, new Stack<Integer>(), result);
        return result;
    }

}
