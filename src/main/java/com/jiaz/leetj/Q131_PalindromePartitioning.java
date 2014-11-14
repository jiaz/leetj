package com.jiaz.leetj;

import java.util.*;

// Given a string s, partition s such that every substring of the partition is a palindrome.
//
// Return all possible palindrome partitioning of s.
//
// For example, given s = "aab",
// Return
//
//   [
//     ["aa","b"],
//     ["a","a","b"]
//   ]

public class Q131_PalindromePartitioning {

    private int[][] isPalindrome;

    private boolean isPal(String s, int i, int j) {
        if (i == j) return true;
        if (isPalindrome[i][j] == 2) return true;
        if (isPalindrome[i][j] == 1) return false;
        int start = i;
        int end = j;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                isPalindrome[i][j] = 1;
                return false;
            }
            start++;
            end--;
        }
        isPalindrome[i][j] = 2;
        return true;
    }

    private List<List<String>> recPartition(String s, int start, int end) {
        List<List<String>> res = new ArrayList<>();
        if (end < start) return res;
        if (end == start) {
            List<String> list = new ArrayList<>();
            list.add(s.substring(start, start + 1));
            res.add(list);
            return res;
        }

        for (int i = start; i <= end - 1; ++i) {
            // split at i
            if (isPal(s, start, i)) {
                String left = s.substring(start, i + 1);
                List<List<String>> right = recPartition(s, i + 1, end);
                for (List<String> rightList : right) {
                    List<String> combine = new ArrayList<String>();
                    combine.add(left);
                    combine.addAll(rightList);
                    res.add(combine);
                }
            }
        }

        if (isPal(s, start, end)) {
            List<String> list = new ArrayList<String>();
            list.add(s.substring(start, end + 1));
            res.add(list);
        }
        return res;
    }

    public List<List<String>> partition(String s) {
        isPalindrome = new int[s.length()][s.length()];
        List<List<String>> res = recPartition(s, 0, s.length() - 1);
        return res;
    }

}
