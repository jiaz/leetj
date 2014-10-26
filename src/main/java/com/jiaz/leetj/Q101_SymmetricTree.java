package com.jiaz.leetj;

import java.util.*;

// Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
// For example, this binary tree is symmetric:
//
//     1
//    / \
//   2   2
//  / \ / \
// 3  4 4  3
// But the following is not:
//     1
//    / \
//   2   2
//    \   \
//    3    3
// Note:
// Bonus points if you could solve it both recursively and iteratively.

public class Q101_SymmetricTree {

    // TODO: Implement iteratively

    private boolean isMirror(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;

        if (l.val != r.val) return false;
        return isMirror(l.left, r.right) && isMirror(l.right, r.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

}
