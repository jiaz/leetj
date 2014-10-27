package com.jiaz.leetj;

import java.util.*;

// Divide two integers without using multiplication, division and mod operator.

public class Q029_DivideTwoIntegers {

    private int signof(int x) {
        if (x < 0) return 1;
        else return 0;
    }

    private int negate(int x) {
        if (x > 0) return ~x + 1;
        return x;
    }

    private int reflect(int x) {
        return ~x + 1;
    }

    public int divide(int dividend, int divisor) {
        if (divisor == 0) return 0; // should throw exception
        if (dividend == 0) return 0; // shortcut
        int sign = signof(dividend) ^ signof(divisor);
        dividend = negate(dividend);
        divisor = negate(divisor);
        int x = divisor;
        int[] buf = new int[32];
        int i = 0;
        for (; i < 32; ++i) {
            buf[i] = x;
            x <<= 1;
            if (x >= 0) break;
        }
        int res = 0;
        int sum = 0;
        for (int j = i; j >= 0; --j) {
            if (sum >= (1 << 31) - buf[j] && sum + buf[j] >= dividend) {
                sum += buf[j];
                res += (1 << j);
            }
        }
        if (sign == 1 && res > 0) res = reflect(res);
        return res;
    }

}
