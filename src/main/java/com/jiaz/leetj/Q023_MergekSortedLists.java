package com.jiaz.leetj;

import java.util.*;

// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

public class Q023_MergekSortedLists {

    private ListNode merge(ListNode a, ListNode b) {
        ListNode newHead = null;
        ListNode current = null;
        while (a != null || b != null) {
            ListNode nextNode = null;
            if (a != null && b != null) {
                if (a.val > b.val) {
                    nextNode = b;
                    b = b.next;
                } else {
                    nextNode = a;
                    a = a.next;
                }
            } else if (a != null) {
                nextNode = a;
                a = a.next;
            } else {
                nextNode = b;
                b = b.next;
            }
            if (newHead == null) {
                newHead = nextNode;
                current = nextNode;
            } else {
                current.next = nextNode;
                current = nextNode;
            }
        }
        return newHead;
    }

    private ListNode mergeTwoByTwo(List<ListNode> lists) {
        List<ListNode> tmp = new ArrayList<>();
        while (lists.size() > 1) {
            int i = 0;
            while (i < lists.size()) {
                if (i < lists.size() - 1) {
                    // merge i, i + 1
                    ListNode a = lists.get(i);
                    ListNode b = lists.get(i + 1);
                    ListNode n = merge(a, b);
                    tmp.add(n);
                } else {
                    // insert i to tmp
                    tmp.add(lists.get(i));
                }
                i += 2;
            }
            List<ListNode> t = lists;
            lists = tmp;
            tmp = t;
            tmp.clear();
        }
        return lists.get(0);
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0) return null;
        return mergeTwoByTwo(lists);
    }

}
