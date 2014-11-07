package com.jiaz.leetj;

import java.util.*;

// Implement pow(x, n).

public class Q050_PowXN {

    public double powPos(double x, int n) {
        if (n == 0) return 1;
        else if (n == 1) return x;
        else {
            int k = n / 2;
            int m = n % 2;
            double powk = pow(x, k);
            return powk * powk * pow(x, m);
        }
    }

    public double pow(double x, int n) {
        if (n < 0) {
            double res = powPos(x, -1 * n);
            return 1.0 / res;
        } else {
            return powPos(x, n);
        }
    }

}
