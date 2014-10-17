package com.jiaz.leetj;

public class Q009_PalindromeNumber {

    private static final int INT_MAX = ((1 << 31) - 1);
    private static final int SENTINAL = ((1 << 31) - 1) / 10;
    private static final int INT_MAX_ABS_MOD_10 = INT_MAX % 10;
    
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int xcopy = x;
        int reverse = 0;

        while (xcopy != 0) {
            int d = xcopy % 10;

            if (reverse == SENTINAL) {
                // overflow not possible palindrom number
                if (x > 0 && d > INT_MAX_ABS_MOD_10) return false;
            } else if (reverse > SENTINAL) {
                // overflow not possible palindrom number
                return false;
            }

            xcopy /= 10;

            reverse *= 10;
            reverse += d;

        }


        return (reverse == x);
    }

}
