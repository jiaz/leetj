package com.jiaz.leetj;

import java.util.*;

// Given a binary tree, determine if it is height-balanced.

// For this problem, a height-balanced binary tree is defined as a binary 
// tree in which the depth of the two subtrees of every node never differ by more than 1.

public class Q110_BalancedBinaryTree {

    private int abs(int a) {
        if (a < 0) return -1 * a;
        return a;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private int getDepth(TreeNode node) {
        if (node == null) return 0;

        if (node.left == null && node.right == null) return 1;

        int leftDepth = 0;
        if (node.left != null) {
            leftDepth = getDepth(node.left);
        }
        if (leftDepth == -1) return -1;

        int rightDepth = 0;
        if (node.right != null) {
            rightDepth = getDepth(node.right);
        }
        if (rightDepth == -1) return -1;

        if (abs(leftDepth - rightDepth) <= 1) {
            return max(leftDepth, rightDepth) + 1;
        } else {
            return -1;
        }
    }
    
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return getDepth(root) != -1;
    }

}