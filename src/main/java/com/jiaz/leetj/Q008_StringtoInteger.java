package com.jiaz.leetj;

// Implement atoi to convert a string to an integer.

public class Q008_StringtoInteger {
    private static int INT_MIN = -2147483648;
    private static int INT_MAX = 2147483647;
    
    public int atoi(String str) {
        int pos = 0;
        boolean isNeg = false;
        boolean isIntMin = false;
        int overflowSentinal = INT_MAX / 10;

        while (pos < str.length() && (str.charAt(pos) == ' ' || str.charAt(pos) == '\t')) {
            pos++;
        }

        if (pos >= str.length()) return 0;

        if (str.charAt(pos) == '+') {
            isNeg = false;
            pos++;
        } else if (str.charAt(pos) == '-') {
            isNeg = true;
            pos++;
        }

        int res = 0;
        while (pos < str.length()) {
            int d = str.charAt(pos) - '0';
            if (d < 0 || d > 9) break;

            if (isIntMin) {
                // overflow
                return INT_MIN;
            } else if (res == overflowSentinal) {
                if (isNeg && d == 8) {
                    isIntMin = true;
                } else if (isNeg && d > 8) {
                    // overflow
                    return INT_MIN;
                } else if (!isNeg && d > 7) {
                    // overflow
                    return INT_MAX;
                }
            } else if (res > overflowSentinal) {
                // overflow
                if (isNeg) return INT_MIN;
                if (!isNeg) return INT_MAX;
            }

            res *= 10;
            res += d;

            pos++;
        }

        if (isIntMin) return INT_MIN;

        return isNeg ? -1 * res : res;
        
    }

}
