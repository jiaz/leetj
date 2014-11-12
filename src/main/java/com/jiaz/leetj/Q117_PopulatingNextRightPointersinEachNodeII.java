package com.jiaz.leetj;

import java.util.*;

public class Q117_PopulatingNextRightPointersinEachNodeII {

    public TreeLinkNode connect(TreeLinkNode root) {
        TreeLinkNode prevLevel = root;
        TreeLinkNode currentLevelHead = null;
        TreeLinkNode currentLevelTail = null;
        while (prevLevel != null) {
            if (prevLevel.left != null) {
                if (currentLevelHead == null) {
                    currentLevelHead = prevLevel.left;
                    currentLevelTail = prevLevel.left;
                } else {
                    currentLevelTail.next = prevLevel.left;
                    currentLevelTail = currentLevelTail.next;
                }
            }
            if (prevLevel.right != null) {
                if (currentLevelHead == null) {
                    currentLevelHead = prevLevel.right;
                    currentLevelTail = prevLevel.right;
                } else {
                    currentLevelTail.next = prevLevel.right;
                    currentLevelTail = currentLevelTail.next;
                }
            }
            prevLevel = prevLevel.next;
            if (prevLevel == null) {
                prevLevel = currentLevelHead;
                currentLevelHead = null;
                currentLevelTail = null;
            }
        }
        return root;
    }

}
