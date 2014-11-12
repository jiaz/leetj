package com.jiaz.leetj;

import java.util.*;

// Say you have an array for which the ith element is the price of a given
// stock on day i.
//
// If you were only permitted to complete at most one transaction
// (ie, buy one and sell one share of the stock), design an algorithm to
// find the maximum profit.

public class Q121_BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int min = prices[0];
        int max = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] < min) {
                min = prices[i];
                max = prices[i];
            } else {
                max = Math.max(max, prices[i]);
                if (max - min > profit) {
                    profit = max - min;
                }
            }
        }
        return profit;
    }

}
