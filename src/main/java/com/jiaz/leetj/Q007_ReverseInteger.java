package com.jiaz.leetj;

// Reverse digits of an integer.

// Example1: x = 123, return 321
// Example2: x = -123, return -321

public class Q007_ReverseInteger {
	
	public int reverse(int x) {
        boolean isNeg = (x < 0);
        if (isNeg) {
        	x = -1 * x;
        }

        int res = 0;
        while (x > 0) {
        	int d = x % 10;
        	res *= 10;
        	res += d;

        	x /= 10;
        }

        return isNeg ? -1 * res : res;
    }

}
