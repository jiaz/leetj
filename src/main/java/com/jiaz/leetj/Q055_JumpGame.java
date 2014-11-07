package com.jiaz.leetj;

import java.util.*;

// Given an array of non-negative integers, you are initially positioned at
// the first index of the array.
//
// Each element in the array represents your maximum jump length at that
// position.
//
// Determine if you are able to reach the last index.
//
// For example:
// A = [2,3,1,1,4], return true.
//
// A = [3,2,1,0,4], return false.

public class Q055_JumpGame {

    public boolean canJump(int[] A) {
        boolean[] map = new boolean[A.length];
        for (int i = 0; i < map.length; ++i) {
            map[i] = false;
        }
        map[0] = true;
        int i = 0;
        int furthest = 0;
        while (i <= furthest) {
            int nextfurthest = furthest;
            for (int j = i; j <= furthest; ++j) {
                nextfurthest = Math.max(nextfurthest, A[j] + j);
                if (nextfurthest >= A.length - 1) return true;
            }
            i = furthest + 1;
            furthest = nextfurthest;
        }
        return false;
    }

}
