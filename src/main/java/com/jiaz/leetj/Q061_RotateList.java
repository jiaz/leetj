package com.jiaz.leetj;

import java.util.*;

// Given a list, rotate the list to the right by k places, where k is non-negative.
//
// For example:
// Given 1->2->3->4->5->NULL and k = 2,
// return 4->5->1->2->3->NULL.

public class Q061_RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        int count = 0;
        ListNode tmp = head;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }
        k %= count;

        // simple shortcut
        if (k == 0 || count == 1) return head;

        int leftCount = count - k;
        tmp = head;
        while (leftCount > 1) {
            tmp = tmp.next;
            leftCount--;
        }

        ListNode newHead = tmp.next;
        ListNode newTail = tmp;

        ListNode mid = newHead;
        while (mid.next != null) {
            mid = mid.next;
        }

        mid.next = head;
        newTail.next = null;

        return newHead;
    }

}
