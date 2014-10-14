package com.jiaz.leetj;

// Given a string S, find the longest palindromic substring in S. 
// You may assume that the maximum length of S is 1000, 
// and there exists one unique longest palindromic substring.

public class Q005_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
    	if (s.length() <= 1) return s;

        System.out.println(s.length());

    	StringBuilder sb = new StringBuilder();
    	sb.append('a');
    	for (int i = 0; i < s.length(); ++i) {
    		sb.append(s.charAt(i));
    		sb.append('a');
    	}
    	String padded = sb.toString();

        int[] longestPals = new int[padded.length()];
        boolean[] closed = new boolean[padded.length()];
        for (int i = 0; i < padded.length(); ++i) {
        	longestPals[i] = 0;
        	closed[i] = false;
        }
        int far = 0;
        int current = 0;
        while (current < padded.length()) {
        	if (closed[current] == false) {
        		int rad = longestPals[current];
        		int l = current - rad;
        		int r = current + rad;
        		while (l >= 1 && r < padded.length() - 1) {
        			l--;
        			r++;
        			if (padded.charAt(l) == padded.charAt(r)) rad++;
        			else break;
        		}
        		longestPals[current] = rad;
        		closed[current] = true;
        		if (far < current + rad) far = current + rad;
        		for (int i = 1; i <= rad && current + i < padded.length(); ++i) {
        			int mirrorRad = longestPals[current - i];
        			if (mirrorRad + current + i >= far) {
        				closed[current+i] = false;
        				longestPals[current+i] = far - current - i;
        			} else {
        				closed[current+i] = true;
        				longestPals[current+i] = mirrorRad;
        			}
        		}
        	}
    		current++;
        }
        int pos = 0;
        for (int i = 0; i < longestPals.length; ++i) {
        	if (longestPals[i] > longestPals[pos]) {
        		pos = i;
        	}
        }
        StringBuilder resSb = new StringBuilder();
        for (int i = pos - longestPals[pos]; i <= pos + longestPals[pos]; ++i) {
        	if (i % 2 == 1) {
        		resSb.append(padded.charAt(i));
        	}
        }
        return resSb.toString();
    }
}