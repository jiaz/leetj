package com.jiaz.leetj;

import java.util.*;

// Given two numbers represented as strings, return multiplication
// of the numbers as a string.
//
// Note: The numbers can be arbitrarily large and are non-negative.

public class Q043_MultiplyStrings {

    private void times(char[] buffer, int pos, String num, int p) {
        int carry = 0;
        for (int i = num.length() - 1; i >= 0; --i) {
            int x = p * (int)(num.charAt(i) - '0') + carry + (int)(buffer[pos] - '0');
            carry = x / 10;
            x %= 10;
            buffer[pos] = (char)(x + '0');
            pos--;
        }
        if (carry != 0) {
            buffer[pos] += carry;
            while (pos >= 0 && buffer[pos] > '9') {
                buffer[pos] -= 10;
                buffer[pos-1] += 1;
                pos--;
            }
        }
    }

    public String multiply(String num1, String num2) {
        boolean neg1 = false;
        boolean neg2 = false;
        if (num1.charAt(0) == '-') {
            neg1 = true;
            num1 = num1.substring(1);
        }
        if (num2.charAt(0) == '-') {
            neg2 = true;
            num2 = num2.substring(1);
        }
        boolean neg = neg1 ^ neg2;
        char[] buffer = new char[num1.length() + num2.length()];
        for (int i = 0; i < buffer.length; ++i) {
            buffer[i] = '0';
        }
        for (int i = num1.length() - 1; i >= 0; --i) {
            // proccess ith num1 * num2
            times(buffer, num2.length() + i, num2, (int)(num1.charAt(i) - '0'));
        }
        String res = new String(buffer);
        int i = 0;
        while (i < res.length() - 1 && res.charAt(i) == '0') i++;
        if (i != 0) res = res.substring(i);
        if (neg == true) {
            res = "-" + res;
        }
        return res;
    }

}
