package com.jiaz.leetj;

import java.util.*;

// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

public class Q108_ConvertSortedArraytoBinarySearchTree {

    private TreeNode recConvert(int[] num, int start, int end) {
        if (end <= start) return null;
        if (end - start == 1) return new TreeNode(num[start]);
        int mid = start + (end - start) / 2;
        TreeNode n = new TreeNode(num[mid]);
        n.left = recConvert(num, start, mid);
        n.right = recConvert(num, mid + 1, end);
        return n;
    }

    public TreeNode sortedArrayToBST(int[] num) {
        return recConvert(num, 0, num.length);
    }

}
