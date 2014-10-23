package com.jiaz.leetj;

import java.util.Stack;

// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

public class Q020_ValidParentheses {
    
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            Character c = s.charAt(i);
            Character tc;
            switch(c) {
                case '}':
                    if (stk.isEmpty()) return false;
                    tc = stk.pop();
                    if ('{' != tc) return false;
                    break;
                case ']':
                    if (stk.isEmpty()) return false;
                    tc = stk.pop();
                    if ('[' != tc) return false;
                    break;
                case ')':
                    if (stk.isEmpty()) return false;
                    tc = stk.pop();
                    if ('(' != tc) return false;
                    break;
                default:
                    stk.push(c);
                    break;
            }
        }

        return stk.isEmpty();
    }

}