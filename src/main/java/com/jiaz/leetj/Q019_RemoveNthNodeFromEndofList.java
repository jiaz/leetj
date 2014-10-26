package com.jiaz.leetj;

// Given a linked list, remove the nth node from the end of list and return its head.
// For example,
//   Given linked list: 1->2->3->4->5, and n = 2.
//   After removing the second node from the end, the linked list becomes 1->2->3->5.
//
// Note:
// Given n will always be valid.
// Try to do this in one pass.

public class Q019_RemoveNthNodeFromEndofList {

    private ListNode removeByAssign(ListNode head, int n) {
        if (n == 1) {
            // remove last node
            if (head.next == null) {
                // head is the last node
                return null;
            } else {
                ListNode prev = head;
                ListNode curr = head.next;
                while (curr.next != null) {
                    prev = curr;
                    curr = curr.next;
                }
                prev.next = null;
            }
        } else {
            ListNode curr = head;
            ListNode checkPoint = curr;
            for (int i = 0; i < n; ++i) {
                checkPoint = checkPoint.next;
            }
            while (checkPoint != null) {
                curr = curr.next;
                checkPoint = checkPoint.next;
            }
            curr.val = curr.next.val;
            curr.next = curr.next.next;
        }
        return head;
    }

    private ListNode removeByDelete(ListNode head, int n) {
        ListNode guard = head;
        for (int i = 0; i < n; ++i) {
            guard = guard.next;
        }
        if (guard == null) {
            // the nth node is head
            ListNode result = head.next;
            head.next = null;
            return result;
        } else {
            ListNode target = head;
            // move target and guard ahead until guard.next = null
            while (guard.next != null) {
                guard = guard.next;
                target = target.next;
            }
            // remove target's next node
            ListNode removeNode = target.next;
            target.next = removeNode.next;
            removeNode.next = null;
            return head;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        return removeByDelete(head, n);
    }

}
