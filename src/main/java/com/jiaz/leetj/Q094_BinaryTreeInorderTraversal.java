package com.jiaz.leetj;

import java.util.*;

// Given a binary tree, return the inorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},

//    1
//     \
//      2
//     /
//    3
// return [1,3,2].

// Note: Recursive solution is trivial, could you do it iteratively?

public class Q094_BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;
        Stack<TreeNode> stk = new Stack<>();
        while (current != null || !stk.isEmpty()) {
            if (current != null) {
                stk.push(current);
                current = current.left;
            } else {
                current = stk.pop();
                result.add(current.val);
                current = current.right;
            }
        }
        return result;
    }

}
