package com.jiaz.leetj;

import java.util.*;

// Given a linked list, swap every two adjacent nodes and return its head.
//
// For example,
// Given 1->2->3->4, you should return the list as 2->1->4->3.
//
// Your algorithm should use only constant space. You may not modify the values
// in the list, only nodes itself can be changed.

public class Q024_SwapNodesinPairs {

    private void swap(ListNode left, ListNode right) {
        if (left == null || right == null) return;

        left.next = right.next;
        right.next = left;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode newHead = null;
        ListNode newTail = null;
        ListNode left = head;
        ListNode right = null;
        while (left != null) {
            if (left.next != null) {
                right = left.next;
                swap(left, right);
                if (newHead == null) {
                    newHead = right;
                    newTail = left;
                } else {
                    newTail.next = right;
                    newTail = left;
                }
            } else {
                if (newHead == null) {
                    newHead = left;
                } else {
                    newTail.next = left;
                }
            }
            left = left.next;
        }
        return newHead;
    }

}
