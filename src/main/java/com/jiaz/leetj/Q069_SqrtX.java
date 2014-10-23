package com.jiaz.leetj;

import java.util.*;

// Implement int sqrt(int x).

// Compute and return the square root of x.

public class Q069_SqrtX {

    private static final int INT_MAX = (1 << 31) - 1;
    
    public int sqrt1(int x) {
        if (x < 0) return 0;
        if (x == 0 || x == 1) return x;
        int begin = 1; int end = x;
        while(begin < end) {
            int mid = (begin + end) / 2 + 1;
            if (mid > INT_MAX / mid) {
                end = mid - 1;
            } else {
                int midsqr = mid * mid;
                if (midsqr > x) {
                    end = mid - 1;
                } else if (midsqr == x) {
                    return mid;
                } else {
                    begin = mid;
                }
            }
        }
        return begin;
    }

    public int sqrt(int x) {
        return sqrt2(x);
    }

    private int sqrt2(int x) {
        if (x < 0) return 0;
        int res = 0;
        int p = 1;
        while (true) {
            int n = res + p;
            int tmp = x / n;
            if (tmp > n) {
                p = (p << 1);
            } else if (tmp == n) {
                return n;
            } else {
                p = (p >> 1);
                res += p;
                if (p <= 1) return res;
                p = 1;
            }
        }
    }

}