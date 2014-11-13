package com.jiaz.leetj;

import java.util.*;

// Given a binary tree, find the maximum path sum.

// The path may start and end at any node in the tree.

// For example:
// Given the below binary tree,

//       1
//      / \
//     2   3
// Return 6.

public class Q124_BinaryTreeMaximumPathSum {

    private static class Pair {
        public int maxPathSum;
        public int maxPathSumToRoot;
    }

    private int max(int a, int b, int c, int d) {
        return Math.max(a, Math.max(b, Math.max(c, d)));
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    private Pair maxPathSumRec(TreeNode root) {
        if (root == null) {
            Pair p = new Pair();
            p.maxPathSum = 0;
            p.maxPathSumToRoot = 0;
            return p;
        }

        if (root.left == null && root.right == null) {
            Pair p = new Pair();
            p.maxPathSum = root.val;
            p.maxPathSumToRoot = root.val;
            return p;
        }

        Pair leftP = null;
        if (root.left != null) leftP = maxPathSumRec(root.left);
        Pair rightP = null;
        if (root.right != null) rightP = maxPathSumRec(root.right);

        int sumWithRoot = 0;
        int maxPathSum = 0;
        int maxPathSumToRoot = 0;

        if (root.left != null && root.right != null) {
            sumWithRoot = root.val + Math.max(0, leftP.maxPathSumToRoot) + Math.max(0, rightP.maxPathSumToRoot);
            maxPathSum = max(sumWithRoot, leftP.maxPathSum, rightP.maxPathSum);
            maxPathSumToRoot = max(0, leftP.maxPathSumToRoot, rightP.maxPathSumToRoot) + root.val;
        } else {
            Pair childP = null;
            if (root.left != null) {
                childP = leftP;
            } else {
                childP = rightP;
            }
            sumWithRoot = root.val + Math.max(0, childP.maxPathSumToRoot);
            maxPathSum = Math.max(sumWithRoot, childP.maxPathSum);
            maxPathSumToRoot = Math.max(0, childP.maxPathSumToRoot) + root.val;
        }

        Pair p = new Pair();
        p.maxPathSum = maxPathSum;
        p.maxPathSumToRoot = maxPathSumToRoot;
        return p;
    }

    public int maxPathSum(TreeNode root) {
        Pair p = maxPathSumRec(root);
        return p.maxPathSum;
    }

}
