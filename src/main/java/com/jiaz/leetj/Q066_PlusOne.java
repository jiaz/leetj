package com.jiaz.leetj;

import java.util.*;

// Given a non-negative number represented as an array of digits, plus one to the number.
//
// The digits are stored such that the most significant digit is at the head of the list.

public class Q066_PlusOne {

    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; --i) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] = digits[i] % 10;
            if (carry == 0) break;
        }

        if (carry == 1) {
            int[] tmp = new int[digits.length + 1];
            tmp[0] = 1;
            System.arraycopy(digits, 0, tmp, 1, digits.length);
            digits = tmp;
        }
        return digits;
    }

}
