package com.jiaz.leetj;

// You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8

public class Q002_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;

        ListNode head = null;
        ListNode prev = null;
        ListNode current = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = 0; int b = 0;
            if (l1 != null) a = l1.val;
            if (l2 != null) b = l2.val;
            int sum = a + b + carry;
            carry = 0;
            if (sum > 9) {
                sum -= 10;
                carry++;
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            current = new ListNode(sum);
            if (head == null) head = current;
            if (prev != null) prev.next = current;
            prev = current;
        }
        if (carry > 0) {
            ListNode lastNode = new ListNode(carry);
            prev.next = lastNode;
        }
        return head;
    }
}
