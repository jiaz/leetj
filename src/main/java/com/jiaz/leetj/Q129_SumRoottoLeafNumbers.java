package com.jiaz.leetj;

import java.util.*;

// Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
//
// An example is the root-to-leaf path 1->2->3 which represents the number 123.
//
// Find the total sum of all root-to-leaf numbers.
//
// For example,
//
//     1
//    / \
//   2   3
// The root-to-leaf path 1->2 represents the number 12.
// The root-to-leaf path 1->3 represents the number 13.
//
// Return the sum = 12 + 13 = 25.

public class Q129_SumRoottoLeafNumbers {

    private int sum;

    private void recCalc(TreeNode n, int subsum) {
        if (n == null) {
            sum += subsum;
            return;
        }

        int currentSum = n.val + subsum * 10;
        if (n.left == null && n.right == null) {
            sum += currentSum;
            return;
        }
        if (n.left != null) {
            recCalc(n.left, currentSum);
        }
        if (n.right != null) {
            recCalc(n.right, currentSum);
        }
    }

    public int sumNumbers(TreeNode root) {
        sum = 0;
        recCalc(root, 0);
        return sum;
    }

}
