package com.jiaz.leetj;

import java.util.*;

// Implement next permutation, which rearranges numbers into the lexicographically 
// next greater permutation of numbers.

// If such arrangement is not possible, it must rearrange it as the lowest possible 
// order (ie, sorted in ascending order).

// The replacement must be in-place, do not allocate extra memory.

// Here are some examples. Inputs are in the left-hand column and its corresponding 
// outputs are in the right-hand column.
// 1,2,3 → 1,3,2
// 3,2,1 → 1,2,3
// 1,1,5 → 1,5,1

public class Q031_NextPermutation {

    private void swap(int[] num, int a, int b) {
        int t = num[a];
        num[a] = num[b];
        num[b] = t;
    }
    
    public int[] nextPermutation(int[] num) {
        int pos = -1;
        for (int i = num.length - 1; i > 0; --i) {
            if (num[i - 1] < num[i]) {
                pos = i - 1;
                break;
            }
        }
        if (pos != -1) {
            for (int i = num.length - 1; i > pos; --i) {
                if (num[i] > num[pos]) {
                    swap(num, i, pos);
                    break;
                }
            }
        }
        int l = pos + 1;
        int r = num.length - 1;
        while (l < r) {
            swap(num, l, r);
            l++;
            r--;
        }
        return num;
    }

}