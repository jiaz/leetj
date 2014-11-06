package com.jiaz.leetj;

import java.util.*;

// Given an array S of n integers, are there elements a, b, c, and d in S
// such that a + b + c + d = target? Find all unique quadruplets in the array
// which gives the sum of target.
//
// Note:
// Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
// The solution set must not contain duplicate quadruplets.
//     For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
//
//     A solution set is:
//     (-1,  0, 0, 1)
//     (-2, -1, 1, 2)
//     (-2,  0, 0, 2)

public class Q018_4Sum {

    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);

        List<List<Integer>> result = new ArrayList<>();

        int apos = 0;
        while (apos <= num.length - 4) {
            int bpos = apos + 1;
            while (bpos <= num.length - 3) {
                int cpos = bpos + 1;
                int dpos = num.length - 1;
                while (cpos < dpos) {
                    int v = num[apos] + num[bpos] + num[cpos] + num[dpos];
                    if (v == target) {
                        result.add(Arrays.asList(num[apos], num[bpos], num[cpos], num[dpos]));
                        do { cpos++; } while (dpos > cpos && num[cpos] == num[cpos-1]);
                        do { dpos--; } while (dpos > cpos && num[dpos] == num[dpos+1]);
                    } else if (v > target) {
                        do { dpos--; } while (dpos > cpos && num[dpos] == num[dpos+1]);
                    } else if (v < target) {
                        do { cpos++; } while (dpos > cpos && num[cpos] == num[cpos-1]);
                    }
                }
                do { bpos++; } while (bpos <= num.length - 3 && num[bpos] == num[bpos-1]);
            }
            do { apos++; } while (apos <= num.length - 4 && num[apos] == num[apos-1]);
        }

        return result;
    }

}
