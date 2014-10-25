package com.jiaz.leetj;

import java.util.*;

// Given a set of non-overlapping intervals, insert a new interval into the intervals 
// (merge if necessary).

// You may assume that the intervals were initially sorted according to their start times.

// Example 1:
// Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

// Example 2:
// Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

// This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].


public class Q057_InsertInterval {

    public boolean isOverlap(Interval interval, int n) {
        if (n >= interval.start && n <= interval.end) return true;
        return false;
    }

    public boolean isOverlap(Interval in1, Interval in2) {
        return (in2.end >= in1.start) && (in2.start <= in1.end);
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }

    public int min(int a, int b) {
        return a > b ? b : a;
    }

    private List<Interval> insertRaw(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        boolean inserted = false;
        boolean checkMerge = false;
        int j = -1;
        for (int i = 0; i < intervals.size(); ++i) {
            Interval in = intervals.get(i);
            if (!inserted) {
                if (isOverlap(in, newInterval)) {
                    // merge
                    Interval insertedInterval = new Interval(min(newInterval.start, in.start),
                        max(newInterval.end, in.end));
                    res.add(insertedInterval);
                    inserted = true;
                    checkMerge = true;
                    j = res.size() - 1;
                } else if (newInterval.start <= in.start) {
                    // insert
                    Interval insertedInterval = new Interval(newInterval.start, newInterval.end);
                    res.add(insertedInterval);
                    i--;
                    inserted = true;
                    j = res.size() - 1;
                } else {
                    res.add(in);
                }
            } else if (checkMerge) {
                // check merge i, j
                Interval lastIn = res.get(j);
                if (isOverlap(lastIn, in)) {
                    // merge
                    if (in.end > lastIn.end) {
                        lastIn.end = in.end;
                    }
                } else {
                    // no merge anymore
                    checkMerge = false;
                    res.add(in);
                }
            } else {
                res.add(in);
            }
        }
        if (!inserted) {
            res.add(newInterval);
        }
        return res;
    }

    public List<Interval> insertSmart(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        for (Interval in : intervals) {
            if (in.end < newInterval.start) {
                result.add(in);
            } else if (in.start > newInterval.end) {
                result.add(newInterval);
                newInterval = in;
            } else {
                newInterval.start = min(newInterval.start, in.start);
                newInterval.end = max(newInterval.end, in.end);
            }
        }
        result.add(newInterval);
        return result;
    }

    public List<Interval> insertInplace(List<Interval> intervals, Interval newInterval) {
        int start = 0;
        int end = 0;
        for (Interval in : intervals) {
            if (newInterval.start > in.end) start++;
            if (newInterval.end >= in.start) end++;
            else break;
        }

        if (start == end) {
            intervals.add(start, newInterval);
        } else {
            Interval merged = new Interval(
                min(newInterval.start, intervals.get(start).start),
                max(newInterval.end, intervals.get(end - 1).end)
                );
            for (int i = start; i < end; ++i) {
                intervals.remove(start);
            }
            intervals.add(start, merged);
        }
        return intervals;
    }
    
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        return insertSmart(intervals, newInterval);
    }

}