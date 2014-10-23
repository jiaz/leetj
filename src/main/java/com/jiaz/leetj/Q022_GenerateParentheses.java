package com.jiaz.leetj;

import java.util.ArrayList;
import java.util.List;

// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// For example, given n = 3, a solution set is:

// "((()))", "(()())", "(())()", "()(())", "()()()"

public class Q022_GenerateParentheses {

    private void recGen(char[] buff, int pos, int leftSingles, int remainingPairs, List<String> res) {
        if (remainingPairs == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < pos; ++i) {
                sb.append(buff[i]);
            }
            for (int i = pos; i < buff.length; ++i) {
                sb.append(')');
            }
            res.add(sb.toString());
        } else {
            buff[pos] = '(';
            recGen(buff, pos + 1, leftSingles + 1, remainingPairs - 1, res);

            if (leftSingles > 0) {
                buff[pos] = ')';
                recGen(buff, pos + 1, leftSingles - 1, remainingPairs, res);
            }
        }
    }
    
    public List<String> generateParenthesis(int n) {
        char[] buff = new char[n * 2];
        List<String> res = new ArrayList<String>();
        recGen(buff, 0, 0, n, res);
        return res;
    }

}