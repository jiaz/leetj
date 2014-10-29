package com.jiaz.leetj;

import java.util.*;

public class Q086_PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = null;
        ListNode smallTail = null;
        ListNode largeHead = null;
        ListNode largeTail = null;

        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                if (smallHead == null) {
                    smallHead = current;
                    smallTail = current;
                } else {
                    smallTail.next = current;
                    smallTail = smallTail.next;
                }
            } else {
                if (largeHead == null) {
                    largeHead = current;
                    largeTail = current;
                } else {
                    largeTail.next = current;
                    largeTail = largeTail.next;
                }
            }
            current = current.next;
        }
        if (largeTail != null) {
            largeTail.next = null;
        }
        if (smallTail != null) {
            smallTail.next = largeHead;
            return smallHead;
        } else {
            return largeHead;
        }
    }

}
