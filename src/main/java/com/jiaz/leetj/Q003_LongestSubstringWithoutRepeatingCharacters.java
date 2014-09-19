package com.jiaz.leetj;

// Given a string, find the length of the longest substring without repeating characters. 
// For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
// For "bbbbb" the longest substring is "b", with the length of 1.

public class Q003_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int[] counting = new int[26];
        for(int i = 0; i < 26; ++i) counting[i] = 0;
        
        int len = 0;
        boolean lookahead = true;
        int begin = 0;
        int end = 0;
        while (end < s.length()) {
            if (lookahead) {
                int pos = (int)(s.charAt(end) - 'a');
                counting[pos] = counting[pos] + 1;
                if (counting[pos] > 1) {
                    lookahead = false;
                }
                end++;
                if (lookahead && (end - begin > len)) len = end - begin;
            } else {
                int pos = (int)(s.charAt(begin) - 'a');
                counting[pos] = counting[pos] - 1;
                if (counting[pos] == 1) {
                    lookahead = true;
                }
                begin++;
            }
        }

        return len;
    }
}
