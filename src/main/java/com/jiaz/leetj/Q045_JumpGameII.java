package com.jiaz.leetj;

import java.util.*;

// Given an array of non-negative integers, you are initially positioned at
// the first index of the array.
//
// Each element in the array represents your maximum jump length at that position.
//
// Your goal is to reach the last index in the minimum number of jumps.
//
// For example:
// Given array A = [2,3,1,1,4]
//
// The minimum number of jumps to reach the last index is 2. (Jump 1 step
// from index 0 to 1, then 3 steps to the last index.)

public class Q045_JumpGameII {

    public int jump(int[] A) {
        if (A.length <= 1) return 0;
        
        int count = 0;
        int current = 0;
        int furthest = 0;
        while (current <= furthest) {
            count++;
            int next = furthest;
            for (int i = current; i <= furthest; ++i) {
                next = Math.max(next, i + A[i]);
                if (next >= A.length - 1) return count;
            }
            current = furthest + 1;
            furthest = next;
        }
        return -1;
    }

}
