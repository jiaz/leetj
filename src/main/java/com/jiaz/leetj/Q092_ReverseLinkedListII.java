package com.jiaz.leetj;

import java.util.*;

// Reverse a linked list from position m to n. Do it in-place and in one-pass.
//
// For example:
// Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//
// return 1->4->3->2->5->NULL.
//
// Note:
// Given m, n satisfy the following condition:
// 1 ≤ m ≤ n ≤ length of list.

public class Q092_ReverseLinkedListII {

    private ListNode move(ListNode n, int step) {
        for (int i = 1; i < step; ++i) {
            n = n.next;
        }
        return n;
    }

    private void reverse(ListNode head, ListNode end) {
        ListNode guard = end.next;

        ListNode current = head;
        ListNode prev = guard;
        while (current != guard) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;

        if (m == 1) {
            // head is changed
            ListNode nNode = move(head, n);
            reverse(head, nNode);
            return nNode;
        } else {
            ListNode mNodePrev = move(head, m - 1);
            ListNode nNode = move(head, n);
            reverse(mNodePrev.next, nNode);
            mNodePrev.next = nNode;
            return head;
        }
    }

}
