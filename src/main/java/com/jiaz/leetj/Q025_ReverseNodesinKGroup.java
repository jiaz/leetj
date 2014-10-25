package com.jiaz.leetj;

import java.util.*;

// Given a linked list, reverse the nodes of a linked list k at a time 
// and return its modified list.

// If the number of nodes is not a multiple of k then left-out nodes in 
// the end should remain as it is.

// You may not alter the values in the nodes, only nodes itself may be changed.

// Only constant memory is allowed.

// For example,
// Given this linked list: 1->2->3->4->5

// For k = 2, you should return: 2->1->4->3->5

// For k = 3, you should return: 3->2->1->4->5

public class Q025_ReverseNodesinKGroup {

    private void reverse(ListNode head, ListNode tail) {
        ListNode current = head;
        ListNode guard = tail.next;
        ListNode next = tail.next;
        while (current != guard) {
            ListNode temp = current.next;
            current.next = next;
            next = current;
            current = temp;
        }
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        if (k == 1) return head;

        ListNode newHead = null;
        ListNode newTail = null;
        ListNode groupHead = head;
        int count;
        while(groupHead != null) {
            ListNode groupTail = groupHead;
            count = 1;
            while (groupTail != null && count < k) {
                groupTail = groupTail.next;
                if (groupTail != null) count++;
            }
            if (count == k) {
                // reverse between groupHead and groupTail, then append to newTail
                reverse(groupHead, groupTail);
                if (newTail == null) {
                    newHead = groupTail;
                    newTail = groupHead;
                } else {
                    newTail.next = groupTail;
                    newTail = groupHead;
                }
                groupHead = groupHead.next;
            } else {
                // append only
                if (newTail == null) {
                    // the whole list is < k elements
                    newHead = head;
                } else {
                    newTail.next = groupHead;
                }
                groupHead = groupTail;
            }
        }
        return newHead;
    }

}