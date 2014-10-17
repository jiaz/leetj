package com.jiaz.leetj;

import java.util.List;
import java.util.ArrayList;

// '.' Matches any single character.
// '*' Matches zero or more of the preceding element.

// The matching should cover the entire input string (not partial).

// The function prototype should be:
// bool isMatch(const char *s, const char *p)

// Some examples:
// isMatch("aa","a") → false
// isMatch("aa","aa") → true
// isMatch("aaa","aa") → false
// isMatch("aa", "a*") → true
// isMatch("aa", ".*") → true
// isMatch("ab", ".*") → true
// isMatch("aab", "c*a*b") → true

public class Q010_RegularExpressionMatching {
    private static class Token {
        public char c;
        public boolean isWildcard;
        public boolean isMultiple;
        public Token() {
            c = '\0';
            isWildcard = false;
            isMultiple = false;
        }

        public boolean isMatch(char c) {
            if (isWildcard) return true;
            else return c == this.c;
        }
    }

    private List<Token> tokenize(String p) {
        List<Token> tokens = new ArrayList<Token>();
        int pos = 0;
        while (pos < p.length()) {
            char c = p.charAt(pos);
            if (c == '*') {
                tokens.get(tokens.size() - 1).isMultiple = true;
            } else {
                Token t = new Token();
                if (c == '.') {
                    t.isWildcard = true;
                }
                t.c = c;
                tokens.add(t);
            }
            pos++;
        }
        return tokens;
    }

    private boolean recMatch(String s, int sPos, List<Token> tokens, int tPos) {
        if (sPos == s.length() && tPos == tokens.size()) return true;

        if (tPos == tokens.size()) return false;

        Token t = tokens.get(tPos);
        if (t.isMultiple) {
            int count = 0;
            char c = '\0';
            do {
                if (recMatch(s, sPos + count, tokens, tPos + 1)) {
                    return true;
                }
                
                if (sPos + count >= s.length()) break;

                c = s.charAt(sPos + count);
                count++;
            } while (t.isMatch(c));

            return false;
        } else {
            if (sPos == s.length()) return false;

            char c = s.charAt(sPos);
            if (!t.isMatch(c)) return false;
            return recMatch(s, sPos + 1, tokens, tPos + 1);
        }
    }
    
    public boolean isMatch(String s, String p) {
        if (s == null) return false;

        List<Token> tokens = tokenize(p);
        return recMatch(s, 0, tokens, 0);
    }

}
