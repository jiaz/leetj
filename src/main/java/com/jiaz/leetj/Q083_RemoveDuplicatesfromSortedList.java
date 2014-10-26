package com.jiaz.leetj;

import java.util.*;

// Given a sorted linked list, delete all duplicates such that each element
// appear only once.
//
// For example,
// Given 1->1->2, return 1->2.
// Given 1->1->2->3->3, return 1->2->3.

public class Q083_RemoveDuplicatesfromSortedList {

    private void deleteNode(ListNode parent, ListNode target) {
        if (parent == null || target == null) return;

        parent.next = target.next;
        target.next = null;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            if (next != null) {
                if (next.val == current.val) {
                    deleteNode(current, next);
                } else {
                    current = next;
                }
            } else {
                break;
            }
        }
        return head;
    }

}
