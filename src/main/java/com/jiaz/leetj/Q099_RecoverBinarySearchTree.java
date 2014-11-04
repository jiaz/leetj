package com.jiaz.leetj;

import java.util.*;

// Two elements of a binary search tree (BST) are swapped by mistake.
//
// Recover the tree without changing its structure.
//
// Note:
// A solution using O(n) space is pretty straight forward. Could you devise a
// constant space solution?

public class Q099_RecoverBinarySearchTree {

    public TreeNode recoverTree(TreeNode root) {
        if (root == null) return null;
        
        TreeNode prevNode = null;
        TreeNode abnormalNode1 = null;
        TreeNode abnormalNode2 = null;
        TreeNode currentNode = root;
        Stack<TreeNode> stk = new Stack<>();
        while(currentNode != null || !stk.isEmpty()) {
            if (currentNode != null) {
                stk.push(currentNode);
                currentNode = currentNode.left;
            } else {
                currentNode = stk.pop();
                if (prevNode != null) {
                    // check prevNode and currentNode
                    if (prevNode.val > currentNode.val) {
                        if (abnormalNode1 == null) {
                            abnormalNode1 = prevNode;
                            abnormalNode2 = currentNode;
                        }
                        else abnormalNode2 = currentNode;
                    }
                }
                prevNode = currentNode;
                currentNode = currentNode.right;
            }
        }
        int v = abnormalNode1.val;
        abnormalNode1.val = abnormalNode2.val;
        abnormalNode2.val = v;
        return root;
    }

}
