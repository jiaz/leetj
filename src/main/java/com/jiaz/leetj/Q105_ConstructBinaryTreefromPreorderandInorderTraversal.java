package com.jiaz.leetj;

import java.util.*;

// Given preorder and inorder traversal of a tree, construct the binary tree.

// Note:
// You may assume that duplicates do not exist in the tree.

public class Q105_ConstructBinaryTreefromPreorderandInorderTraversal {

    private int find(int[] arr, int start, int end, int target) {
        for (int i = 0; i <= end; ++i) {
            if (arr[i] == target) return i;
        }
        return 0;
    }

    private TreeNode recBuild(int[] preorder, int preStart, int preEnd,
        int[] inorder, int inStart, int inEnd) {
        if (preEnd < preStart) return null;

        if (preEnd == preStart) {
            return new TreeNode(preorder[preStart]);
        } else {
            int x = preorder[preStart];
            int inPos = find(inorder, inStart, inEnd, x);
            TreeNode left = recBuild(preorder, preStart + 1, preStart + (inPos - inStart),
                inorder, inStart, inPos - 1);
            TreeNode right = recBuild(preorder, preStart + (inPos - inStart) + 1, preEnd,
                inorder, inPos + 1, inEnd);
            TreeNode n = new TreeNode(x);
            n.left = left;
            n.right = right;
            return n;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recBuild(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

}
