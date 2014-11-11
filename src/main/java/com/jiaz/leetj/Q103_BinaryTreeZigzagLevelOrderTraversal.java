package com.jiaz.leetj;

import java.util.*;

// Given a binary tree, return the zigzag level order traversal of its nodes' values.
// (ie, from left to right, then right to left for the next level and alternate between).
//
// For example:
// Given binary tree {3,9,20,#,#,15,7},
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its zigzag level order traversal as:
// [
//   [3],
//   [20,9],
//   [15,7]
// ]

public class Q103_BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        stk.push(root);
        boolean leftToRight = true;
        while (!stk.isEmpty()) {
            // add current level
            List<Integer> row = new ArrayList<>();
            while (!stk.isEmpty()) {
                TreeNode n = stk.pop();
                row.add(n.val);

                if (leftToRight) {
                    if (n.left != null) nextLevel.add(n.left);
                    if (n.right != null) nextLevel.add(n.right);
                } else {
                    if (n.right != null) nextLevel.add(n.right);
                    if (n.left != null) nextLevel.add(n.left);
                }
            }
            result.add(row);
            leftToRight = !leftToRight;
            stk = nextLevel;
            nextLevel = new Stack<>();
        }
        return result;
    }

}
