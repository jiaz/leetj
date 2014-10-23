package com.jiaz.leetj;

// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
// Return the sum of the three integers. You may assume that each input would have exactly one solution.

//     For example, given array S = {-1 2 1 -4}, and target = 1.

//     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

public class Q016_3SumClosest {

    private void swap(int[] num, int a, int b) {
        int t = num[a];
        num[a] = num[b];
        num[b] = t;
    }

    private void qsort(int[] num, int start, int end) {
        if (end - start < 2) return;

        int pivot = num[start];
        int left = start + 1;
        int right = end - 1;
        while (left <= right) {
            if (num[left] <= pivot) {
                left++;
            } else if (num[right] > pivot) {
                right--;
            } else {
                swap(num, left, right);
            }
        }
        swap(num, start, right);

        qsort(num, start, right);
        qsort(num, right + 1, end);
    }

    private int abs(int a) {
        if (a < 0) return -1 * a;
        else return a;
    }

    public void sort(int[] num) {
        qsort(num, 0, num.length);
    }
    
    public int threeSumClosest(int[] num, int target) {
        if (num.length < 3) return 0;
        int closest = num[0] + num[1] + num[2];

        sort(num);

        int cpos = num.length - 1;
        while (cpos > 1) {
            int apos = 0;
            int bpos = cpos - 1;
            while (apos < bpos) {
                int d = num[apos] + num[bpos] + num[cpos];
                if (abs(d - target) < abs(closest - target)) {
                    closest = d;
                }
                if (d > target) {
                    bpos--;
                } else if (d < target) {
                    apos++;
                } else {
                    return target;
                }
            }
            cpos--;
        }

        return closest;
    }

}