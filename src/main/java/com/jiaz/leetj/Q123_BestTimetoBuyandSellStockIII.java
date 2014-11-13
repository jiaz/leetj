package com.jiaz.leetj;

import java.util.*;

// Say you have an array for which the ith element is the price of a given stock on day i.

// Design an algorithm to find the maximum profit. You may complete at most two transactions.

// Note:
// You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

public class Q123_BestTimetoBuyandSellStockIII {

    private int[] getProfitsArr(int[] prices, boolean fromLeft) {
        int[] arr = new int[prices.length + 1];
        arr[0] = 0;
        int min = 0;
        int max = 0;
        int profit = 0;
        if (fromLeft) {
            min = prices[0];
            max = min;
        } else {
            min = prices[prices.length - 1];
            max = min;
        }
        for (int i = 1; i < arr.length; ++i) {
            int k = 0;
            if (fromLeft) {
                k = prices[i - 1];
                if (k < min) {
                    min = k;
                    max = k;
                } else {
                    max = Math.max(max, k);
                    profit = Math.max(profit, max - min);
                }
            } else {
                k = prices[prices.length - i];
                if (k > max) {
                    min = k;
                    max = k;
                } else {
                    min = Math.min(min, k);
                    profit = Math.max(profit, max - min);
                }
            }
            arr[i] = profit;
        }
        return arr;
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int[] leftToRight = getProfitsArr(prices, true);
        int[] rightToLeft = getProfitsArr(prices, false);

        int p0 = 0;

        for (int i = 0; i < leftToRight.length; ++i) {
            p0 = Math.max(p0, leftToRight[leftToRight.length - 1 - i] + rightToLeft[i]);
        }

        return p0;
    }

}
