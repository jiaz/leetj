package com.jiaz.leetj;

import java.util.*;

// Given a sorted linked list, delete all nodes that have duplicate numbers,
// leaving only distinct numbers from the original list.
//
// For example,
// Given 1->2->3->3->4->4->5, return 1->2->5.
// Given 1->1->1->2->3, return 2->3.

public class Q082_RemoveDuplicatesfromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = null;
        ListNode newTail = null;
        ListNode currentStart = head;
        while (currentStart != null) {
            ListNode currentEnd = currentStart;
            int count = 0;
            while (currentEnd != null && currentEnd.val == currentStart.val) {
                currentEnd = currentEnd.next;
                count++;
            }
            if (count == 1) {
                if (newHead == null) {
                    newHead = currentStart;
                    newTail = newHead;
                } else {
                    newTail.next = currentStart;
                    newTail = newTail.next;
                }
                newTail.next = null;
            }
            currentStart = currentEnd;
        }
        return newHead;
    }

}
