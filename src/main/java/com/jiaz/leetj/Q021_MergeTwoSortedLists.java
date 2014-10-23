package com.jiaz.leetj;

public class Q021_MergeTwoSortedLists {
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode first = l1;
        ListNode second = l2;
        ListNode head = null;
        ListNode current = null;

        while (first != null || second != null) {
            if (first == null) {
                current.next = second;
                current = current.next;
                second = second.next;
            } else if (second == null) {
                current.next = first;
                current = current.next;
                first = first.next;
            } else {
                ListNode n = null;
                if (first.val < second.val) {
                    n = first;
                    first = first.next;
                } else {
                    n = second;
                    second = second.next;
                }
                if (head == null) head = n;
                if (current == null) {
                    current = n;
                } else {
                    current.next = n;
                    current = current.next;
                }
            }
        }
        current.next = null;

        return head;
    }

}