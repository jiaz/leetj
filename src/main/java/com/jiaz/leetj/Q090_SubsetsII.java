package com.jiaz.leetj;

import java.util.*;

// Given a collection of integers that might contain duplicates, S, return all possible subsets.

// Note:

// Elements in a subset must be in non-descending order.
// The solution set must not contain duplicate subsets.
// For example,
// If S = [1,2,2], a solution is:

// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]

public class Q090_SubsetsII {

    private void recGenSubsets(int[] num, int pos, Stack<Integer> stk, List<List<Integer>> res) {
        if (pos == num.length) {
            List<Integer> list = new ArrayList<>(stk);
            res.add(list);
        } else {
            int count = 1;
            int peek = pos + 1;
            while (peek < num.length && num[peek] == num[pos]) {
                peek++;
                count++;
            }
            for (int i = 0; i <= count; ++i) {
                for (int j = 0; j < i; ++j) {
                    stk.push(num[pos]);
                }
                recGenSubsets(num, peek, stk, res);
                for (int j = 0; j < i; ++j) {
                    stk.pop();
                }
            }
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(num);
        recGenSubsets(num, 0, new Stack<Integer>(), result);

        return result;
    }

}
