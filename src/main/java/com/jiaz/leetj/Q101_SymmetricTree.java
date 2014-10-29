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

    private static class TreePair {
        public TreeNode left;
        public TreeNode right;
        public TreePair(TreeNode l, TreeNode r) {
            left = l;
            right = r;
        }
    }

    private boolean isMirrorIter(TreeNode l, TreeNode r) {
        Stack<TreePair> stk = new Stack<>();
        TreePair p = new TreePair(l, r);
        stk.push(p);
        while (!stk.isEmpty()) {
            p = stk.pop();
            if (p.left == null && p.right == null) continue;
            if (p.left == null || p.right == null) return false;

            if (p.left.val != p.right.val) return false;

            stk.push(new TreePair(p.left.left, p.right.right));
            stk.push(new TreePair(p.left.right, p.right.left));
        }
        return true;
    }

    private boolean isMirror(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;

        if (l.val != r.val) return false;
        return isMirror(l.left, r.right) && isMirror(l.right, r.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirrorIter(root.left, root.right);
    }

}
