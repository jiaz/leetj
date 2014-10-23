package com.jiaz.leetj;

import java.util.Map;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;

// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
// Find all unique triplets in the array which gives the sum of zero.

// Note:
// Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
// The solution set must not contain duplicate triplets.

//     For example, given array S = {-1 0 1 2 -1 -4},

//     A solution set is:
//     (-1, -1, 2)
//     (-1, 0, 1)

public class Q015_3Sum {

    private void swap(int[] num, int a, int b) {
        int t = num[a];
        num[a] = num[b];
        num[b] = t;
    }

    private void qsort(int[] num, int start, int end) {
        if (end - start < 2) return;

        int povit = num[start];
        int left = start + 1;
        int right = end - 1;
        while (left <= right) {
            if (num[left] <= povit) {
                left++;
            } else if (num[right] > povit) {
                right--;
            } else {
                swap(num, left, right);
            }
        }
        swap(num, start, right);

        qsort(num, start, right);
        qsort(num ,right + 1, end);
    }

    private void sort(int[] num) {
        qsort(num, 0, num.length);
    }
    
    public List<List<Integer>> threeSum(int[] num) {
        TreeMap<Integer, TreeSet<Integer>> maps = new TreeMap<>();
        
        sort(num);

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num.length < 3) {
            return res;
        }

        int a, b, c;
        a = 0; b = 0; c = 0;

        for (int i = 0; i < num.length; ++i) {
            int cpos = num.length - 1 - i;
            int apos = 0;
            int bpos = cpos - 1;
            c = num[cpos];
            while (apos < bpos) {
                if (num[apos] + num[bpos] + c > 0) {
                    bpos--;
                } else if (num[apos] + num[bpos] + c == 0) {
                    // record one
                    if (maps.containsKey(num[apos])) {
                        TreeSet<Integer> sets = maps.get(num[apos]);
                        sets.add(num[bpos]);
                    } else {
                        TreeSet<Integer> sets = new TreeSet<>();
                        sets.add(num[bpos]);
                        maps.put(num[apos], sets);
                    }
                    apos++;
                } else {
                    apos++;
                }
            }
        }

        for (Integer i : maps.keySet()) {
            for (Integer j : maps.get(i)) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j);
                list.add(0 - i - j);
                res.add(list);
            }
        }

        return res;
    }

}