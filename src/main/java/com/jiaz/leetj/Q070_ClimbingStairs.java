package com.jiaz.leetj;

import java.util.*;

// You are climbing a stair case. It takes n steps to reach to the top.
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways
// can you climb to the top?

public class Q070_ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int p = 1;
        int pp = 2;
        for (int i = 3; i <= n; ++i) {
            int w = p + pp;
            p = pp;
            pp = w;
        }
        return pp;
    }

}
