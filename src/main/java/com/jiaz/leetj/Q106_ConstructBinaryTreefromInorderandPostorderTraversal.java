package com.jiaz.leetj;

import java.util.*;

// Given inorder and postorder traversal of a tree, construct the binary tree.

// Note:
// You may assume that duplicates do not exist in the tree.

public class Q106_ConstructBinaryTreefromInorderandPostorderTraversal {

    private int find(int[] arr, int start, int end, int target) {
        for (int i = start; i <= end; ++i) {
            if (arr[i] == target) return i;
        }
        return start;
    }

    private TreeNode buildTreeRec(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inEnd < inStart) return null;
        if (inEnd == inStart) return new TreeNode(inorder[inStart]);

        int x = postorder[postEnd];
        int inPos = find(inorder, inStart, inEnd, x);
        TreeNode left = buildTreeRec(inorder, inStart, inPos - 1, postorder, postStart, postStart + (inPos - inStart - 1));
        TreeNode right = buildTreeRec(inorder, inPos + 1, inEnd, postorder, postStart + inPos - inStart, postEnd - 1);
        TreeNode n = new TreeNode(x);
        n.left = left;
        n.right = right;
        return n;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeRec(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

}
