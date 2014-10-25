package com.jiaz.leetj;

import java.util.*;

// Given a binary tree, find its minimum depth.

// The minimum depth is the number of nodes along the shortest path 
// from the root node down to the nearest leaf node.

public class Q111_MinimumDepthofBinaryTree {

    private int preOrderMin;
    
    public int minDepth(TreeNode root) {
        return minDepthUsingPreOrder(root);
    }

    private int minDepthUsingPreOrder(TreeNode root) {
        if (root == null) return 0;
        preOrderMin = -1;
        preOrder(root, 1);
        return preOrderMin;
    }

    private void preOrder(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            if (preOrderMin == -1 || depth < preOrderMin) preOrderMin = depth;
        } else {
            if (node.left != null) {
                preOrder(node.left, depth + 1);
            }
            if (node.right != null) {
                preOrder(node.right, depth + 1);
            }
        }
    }

}