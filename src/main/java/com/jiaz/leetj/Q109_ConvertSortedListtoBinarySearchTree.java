package com.jiaz.leetj;

import java.util.*;

// Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

public class Q109_ConvertSortedListtoBinarySearchTree {

    private int getLen(ListNode n) {
        int count = 0;
        while (n != null) {
            count++;
            n = n.next;
        }
        return count;
    }

    private ListNode move(ListNode n, int m) {
        for (int i = 0; i < m; ++i) {
            n = n.next;
        }
        return n;
    }

    private TreeNode buildBST(ListNode head, int len) {
        if (len == 0) return null;
        if (len == 1) return new TreeNode(head.val);

        int mid = len / 2;
        ListNode midNode = move(head, mid);
        ListNode rightHead = midNode.next;
        TreeNode n = new TreeNode(midNode.val);
        n.left = buildBST(head, mid);
        n.right = buildBST(rightHead, len - mid - 1);
        return n;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int len = getLen(head);
        return buildBST(head, len);
    }

}
