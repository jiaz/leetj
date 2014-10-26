package com.jiaz.leetj;

import java.util.*;

// Given a binary tree, determine if it is a valid binary search tree (BST).
//
// Assume a BST is defined as follows:
//
// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.


public class Q098_ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        // in order traverse and check each node is greater than prev node
        Stack<TreeNode> stk = new Stack<>();
        TreeNode current = root;
        TreeNode prevNode = null;
        while (current != null || !stk.isEmpty()) {
            if (current == null) {
                TreeNode n = stk.pop();
                if (prevNode != null) {
                    if (prevNode.val >= n.val) return false;
                }
                prevNode = n;
                if (n.right != null) {
                    current = n.right;
                }
            } else {
                stk.push(current);
                current = current.left;
            }
        }
        return true;
    }

}
