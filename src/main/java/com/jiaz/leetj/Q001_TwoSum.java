package com.jiaz.leetj;

// Given an array of integers, find two numbers such that they add up to a specific target number.

// The function twoSum should return indices of the two numbers such that they add up to the target,
// where index1 must be less than index2. Please note that your returned answers (both index1 and index2)
// are not zero-based.

// You may assume that each input would have exactly one solution.

// Input: numbers={2, 7, 11, 15}, target=9
// Output: index1=1, index2=2

public class Q001_TwoSum {
    private void swap(int[] numbers, int a, int b) {
        if (a == b) return;
        int t = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = t;
    }

    private void qsort(int[] numbers, int[] index, int begin, int end) {
        if (begin >= end) return;

        int pivot = numbers[begin];
        int i = begin + 1; int j = end;
        while (i <= j) {
            if (numbers[i] <= pivot) i++;
            else if (numbers[j] > pivot) j--;
            else if (i != j) {
                swap(numbers, i, j);
                swap(index, i, j);
            }
        }

        swap(numbers, begin, j);
        swap(index, begin, j);

        qsort(numbers, index, begin, j - 1);
        qsort(numbers, index, j + 1, end);
    }

    private void sort(int[] numbers, int[] index) {
        qsort(numbers, index, 0, numbers.length - 1);
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[numbers.length];
        for (int i = 0; i < numbers.length; ++i) index[i] = i+1;
        sort(numbers, index);
        int i = 0; int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) break;
            else if (sum < target) i++;
            else j--;
        }
        int a, b;
        if (index[i] < index[j]) {
            a = index[i];
            b = index[j];
        } else {
            a = index[j];
            b = index[i];
        }
        return new int[] {b,a};
    }
}
