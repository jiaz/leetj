package com.jiaz.leetj;

import java.util.*;

// Given an array and a value, remove all instances of that value in place and return the new length.
//
// The order of elements can be changed. It doesn't matter what you leave beyond the new length.

public class Q027_RemoveElement {

    public int removeElement(int[] A, int elem) {
        int pos = -1;
        int head = 0;
        while (head != A.length) {
            if (A[head] != elem) {
                pos++;
                A[pos] = A[head];
            }
            head++;
        }
        return pos + 1;
    }

}
