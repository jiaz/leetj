package com.jiaz.leetj;

import java.util.*;

// Given a collection of intervals, merge all overlapping intervals.

// For example,
// Given [1,3],[2,6],[8,10],[15,18],
// return [1,6],[8,10],[15,18].

public class Q056_MergeIntervals {

    private int compare(Interval in1, Interval in2) {
        if (in1.start > in2.start) {
            return 1;
        } else if (in1.start < in2.start) {
            return -1;
        } else {
            return 0;
        }
    }

    private void swap(List<Interval> intervals, int a, int b) {
        Interval tmp = new Interval(intervals.get(a).start, intervals.get(a).end);
        intervals.get(a).start = intervals.get(b).start;
        intervals.get(a).end = intervals.get(b).end;
        intervals.get(b).start = tmp.start;
        intervals.get(b).end = tmp.end;
    }

    private void qsort(List<Interval> intervals, int start, int end) {
        if (end - start <= 0) return;

        Interval pivot = intervals.get(start);
        int left = start; int right = end;
        while (left <= right) {
            if (compare(pivot, intervals.get(left)) >= 0) {
                left++;
            } else if (compare(pivot, intervals.get(right)) < 0) {
                right--;
            } else {
                swap(intervals, left, right);
            }
        }
        swap(intervals, start, right);
        qsort(intervals, start, right - 1);
        qsort(intervals, right + 1, end);
    }

    private boolean isOverlap(Interval in1, Interval in2) {
        return !(in1.end < in2.start) && !(in1.start > in2.end);
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private List<Interval> inplaceMerge(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;

        // sort the list by start
        qsort(intervals, 0, intervals.size() - 1);
        // merge if necessary
        int pos = 0;
        while (pos < intervals.size()) {
            Interval current = intervals.get(pos);
            if (pos < intervals.size() - 1) {
                Interval next = intervals.get(pos + 1);
                if (isOverlap(current, next)) {
                    current.end = max(next.end, current.end);
                    intervals.remove(pos + 1);
                } else {
                    pos++;
                }
            } else {
                pos++;
            }
        }
        return intervals;
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        return inplaceMerge(intervals);
    }

}