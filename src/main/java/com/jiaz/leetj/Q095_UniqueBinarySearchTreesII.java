package com.jiaz.leetj;

import java.util.*;

// Given n, generate all structurally unique BST's (binary search trees) that
// store values 1...n.
//
// For example,
// Given n = 3, your program should return all 5 unique BST's shown below.
//
//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3

public class Q095_UniqueBinarySearchTreesII {

    private List<TreeNode> generateTreesRec(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        if (start == end) {
            TreeNode n = new TreeNode(start);
            result.add(n);
            return result;
        }

        for (int i = start; i <= end; ++i) {
            List<TreeNode> left = generateTreesRec(start, i - 1);
            List<TreeNode> right = generateTreesRec(i + 1, end);
            if (left.size() != 0 && right.size() != 0) {
                for (TreeNode ln : left) {
                    for (TreeNode rn : right) {
                        TreeNode r = new TreeNode(i);
                        r.left = ln;
                        r.right = rn;
                        result.add(r);
                    }
                }
            } else if (left.size() != 0) {
                for (TreeNode ln : left) {
                    TreeNode r = new TreeNode(i);
                    r.left = ln;
                    r.right = null;
                    result.add(r);
                }
            } else if (right.size() != 0) {
                for (TreeNode rn : right) {
                    TreeNode r = new TreeNode(i);
                    r.left = null;
                    r.right = rn;
                    result.add(r);
                }
            }
        }

        return result;
    }

    public List<TreeNode> generateTrees(int n) {
        return generateTreesRec(1, n);
    }

}
