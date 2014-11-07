package com.jiaz.leetj;

import java.util.*;

// Given two binary strings, return their sum (also a binary string).
//
// For example,
// a = "11"
// b = "1"
// Return "100".

public class Q067_AddBinary {

    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        int n = a.length();
        char[] buff = new char[n + 1];
        int carry = 0;
        int j = b.length() - 1;
        for (int i = n - 1; i >= 0; --i) {
            int d = (int)(a.charAt(i) - '0');
            if (j >= 0) {
                d += (int)(b.charAt(j) - '0');
                --j;
            }
            d += carry;
            carry = d / 2;
            d %= 2;
            buff[i + 1] = (char)('0' + d);
        }
        if (carry != 0) {
            buff[0] = (char)('0' + carry);
        } else {
            char[] trimmedBuff = new char[n];
            System.arraycopy(buff, 1, trimmedBuff, 0, n);
            buff = trimmedBuff;
        }
        return new String(buff);
    }

}
