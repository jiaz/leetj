package com.jiaz.leetj;

// Given a sorted array of integers, find the starting and ending position of a given target value.

// Your algorithm's runtime complexity must be in the order of O(log n).

// If the target is not found in the array, return [-1, -1].

// For example,
// Given [5, 7, 7, 8, 8, 10] and target value 8,
// return [3, 4].

public class Q034_SearchforaRange {

    private int searchForStart(int[] num, int target) {
        if (num.length < 1) return -1;
        int begin = 0;
        int end = num.length - 1;
        while (end >= begin) {
            if (end == begin) {
                if (num[begin] == target) return begin;
                else return -1;
            } else {
                int mid = begin + (end - begin + 1) / 2;
                if (num[mid] > target) {
                    end = mid - 1;
                } else if (num[mid] < target) {
                    begin = mid + 1;
                } else {
                    // found target
                    if (mid > begin) {
                        // check prev num is also target
                        if (num[mid - 1] == target) {
                            end = mid - 1;
                        } else {
                            return mid;
                        }
                    } else {
                        return mid;
                    }
                }
            }
        }
        return -1;
    }
    
    private int searchForEnd(int[] num, int target) {
        if (num.length < 1) return -1;
        int begin = 0;
        int end = num.length - 1;
        while (end >= begin) {
            if (end == begin) {
                if (num[begin] == target) return begin;
                else return -1;
            } else {
                int mid = begin + (end - begin + 1) / 2;
                if (num[mid] > target) {
                    end = mid - 1;
                } else if (num[mid] < target) {
                    begin = mid + 1;
                } else {
                    // found target
                    if (mid < end) {
                        // check next num is also target
                        if (num[mid + 1] == target) {
                            begin = mid + 1;
                        } else {
                            return mid;
                        }
                    } else {
                        return mid;
                    }
                }
            }
        }
        return -1;
    }

    public int[] searchRange(int[] A, int target) {
        int start = searchForStart(A, target);
        if (start == -1) {
            return new int[] {-1, -1};
        }
        int end = searchForEnd(A, target);
        return new int[] {start, end};
    }

}