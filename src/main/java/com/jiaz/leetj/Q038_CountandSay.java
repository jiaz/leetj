package com.jiaz.leetj;

import java.util.*;

// The count-and-say sequence is the sequence of integers beginning as follows:
// 1, 11, 21, 1211, 111221, ...

// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
// Given an integer n, generate the nth sequence.

// Note: The sequence of integers will be represented as a string.

public class Q038_CountandSay {
    
    public String countAndSay(int n) {
        return countAndSay2(n);
    }

    public String countAndSay2(int n) {
        List<Integer> ints = new ArrayList<>();
        List<Integer> nextInts = new ArrayList<>();
        ints.add(1);
        while (n > 1) {
            n--;
            Integer ii = ints.get(0);
            int count = 1;
            for (int j = 1; j < ints.size(); ++j) {
                int i = ints.get(j);
                if (i == ii) count++;
                else {
                    nextInts.add(count);
                    nextInts.add(ii);
                    ii = i;
                    count = 1;
                }
            }
            nextInts.add(count);
            nextInts.add(ii);
            List<Integer> tmp = ints;
            ints = nextInts;
            nextInts = tmp;
            nextInts.clear();
        }
        StringBuilder sb = new StringBuilder();
        for (Integer i : ints) {
            sb.append(i);
        }
        return sb.toString();
    }

    public String countAndSay1(int n) {
        if (n < 1) return "";
        if (n == 1) {
            return "1";
        } else {
            String r = countAndSay(n - 1);
            StringBuilder sb = new StringBuilder();
            char c = r.charAt(0);
            int count = 1;
            for (int i = 1; i < r.length(); ++i) {
                char x = r.charAt(i);
                if (x == c) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(c);
                    c = x;
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(c);
            return sb.toString();
        }
    }

}