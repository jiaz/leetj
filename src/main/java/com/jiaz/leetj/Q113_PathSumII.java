package com.jiaz.leetj;

import java.util.*;

// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//
// For example:
// Given the below binary tree and sum = 22,
//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \    / \
//         7    2  5   1
// return
// [
//    [5,4,11,2],
//    [5,8,4,5]
// ]

public class Q113_PathSumII {
    private void recPathSum(TreeNode n, int sum, Stack<Integer> stk, List<List<Integer>> res) {
        if (n == null) return;

        if (n.left == null && n.right == null) {
            if (sum == n.val) {
                List<Integer> list = new ArrayList<>(stk);
                list.add(n.val);
                res.add(list);
            }
            return;
        }

        stk.push(n.val);
        recPathSum(n.left, sum - n.val, stk, res);
        recPathSum(n.right, sum - n.val, stk, res);
        stk.pop();
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        recPathSum(root, sum, stk, result);
        return result;
    }

}
