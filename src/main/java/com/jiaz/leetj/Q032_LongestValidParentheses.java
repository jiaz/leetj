package com.jiaz.leetj;

import java.util.*;

// Given a string containing just the characters '(' and ')', find the length of
// the longest valid (well-formed) parentheses substring.
//
// For "(()", the longest valid parentheses substring is "()", which has length = 2.
//
// Another example is ")()())", where the longest valid parentheses substring is
// "()()", which has length = 4.

public class Q032_LongestValidParentheses {

    private int solveDP(String s) {
        int currentLongest = 0;
        int[] longest = new int[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                longest[i] = 0;
            } else if (c == ')') {
                if (i > 0) {
                    // check i - 1
                    if (s.charAt(i - 1) == '(') {
                        longest[i] = (i > 1 ? longest[i - 2] : 0) + 2;
                    } else {
                        if (i - longest[i - 1] - 1 >= 0) {
                            if (s.charAt(i - longest[i - 1] - 1) == '(') {
                                longest[i] = (i - longest[i - 1] - 1 >= 1 ? longest[i - longest[i - 1] - 2] : 0) + (longest[i - 1] + 2);
                            } else {
                                longest[i] = 0;
                            }
                        } else {
                            longest[i] = 0;
                        }
                    }
                } else {
                    longest[i] = 0;
                }
            } else {
                // throw exception
            }
            if (longest[i] > currentLongest) currentLongest = longest[i];
        }
        return currentLongest;
    }

    private int solveStack(String s) {
        Stack<Integer> closedStack = new Stack<Integer>();
        int lastClosed = 0;
        int longestSoFar = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                closedStack.push(lastClosed);
                lastClosed = 0;
            } else if (c == ')') {
                if (closedStack.isEmpty()) {
                    lastClosed = 0;
                } else {
                    int prevClosed = closedStack.pop();
                    lastClosed += (prevClosed + 1);
                    if (lastClosed > longestSoFar) {
                        longestSoFar = lastClosed;
                    }
                }
            }
        }
        return longestSoFar << 1;
    }

    public int longestValidParentheses(String s) {
        return solveDP(s);
    }

}
