package com.jiaz.leetj;

import java.util.*;

// Given a binary tree, flatten it to a linked list in-place.
//
// For example,
// Given
//
//          1
//         / \
//        2   5
//       / \   \
//      3   4   6
// The flattened tree should look like:
//    1
//     \
//      2
//       \
//        3
//         \
//          4
//           \
//            5
//             \
//              6

public class Q114_FlattenBinaryTreetoLinkedList {

    private static class Pair {
        public TreeNode head;
        public TreeNode tail;
        public Pair() {
            head = null;
            tail = null;
        }
    }

    private Pair recFlatten(TreeNode n) {
        if (n == null) {
            Pair p = new Pair();
            return p;
        }

        if (n.left == null && n.right == null) {
            Pair p = new Pair();
            p.head = n;
            p.tail = n;
            return p;
        }

        Pair leftPair = recFlatten(n.left);
        Pair rightPair = recFlatten(n.right);

        n.left = null;

        if (leftPair.head != null) {
            n.right = leftPair.head;
            leftPair.tail.right = rightPair.head;
        } else {
            n.right = rightPair.head;
        }

        Pair p = new Pair();
        p.head = n;
        p.tail = rightPair.tail == null ? leftPair.tail : rightPair.tail;
        return p;
    }

    public TreeNode flatten(TreeNode root) {
        Pair p = recFlatten(root);
        return p.head;
    }

}
