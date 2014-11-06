package com.jiaz.leetj;

import java.util.*;

// Implement wildcard pattern matching with support for '?' and '*'.
//
// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).
//
// The matching should cover the entire input string (not partial).
//
// The function prototype should be:
// bool isMatch(const char *s, const char *p)
//
// Some examples:
// isMatch("aa","a") → false
// isMatch("aa","aa") → true
// isMatch("aaa","aa") → false
// isMatch("aa", "*") → true
// isMatch("aa", "a*") → true
// isMatch("ab", "?*") → true
// isMatch("aab", "c*a*b") → false

public class Q044_WildcardMatching {

    private class Token {
        public char c;
        public boolean isAny;
        public boolean isAnySeq;
        public Token(char c) {
            this.c = c;
            isAny = (c == '?');
            isAnySeq = (c == '*');
        }
        public boolean isMatch(char c) {
            if (isAny || isAnySeq) return true;
            return this.c == c;
        }
    }

    private List<Token> tokenize(String p) {
        List<Token> tokens = new ArrayList<>();
        if (p == null) return tokens;
        for (int i = 0; i < p.length(); ++i) {
            char c = p.charAt(i);
            Token t = new Token(c);
            tokens.add(t);
        }
        return tokens;
    }

    private boolean recMatching(String s, int spos, List<Token> tokens, int tpos) {
        if (spos == s.length() && tpos == tokens.size()) {
            return true;
        }
        if (spos == s.length() || tpos == tokens.size()) {
            return false;
        }
        Token t = tokens.get(tpos);
        if (t.isAnySeq) {
            for (int i = spos; i < s.length(); ++i) {
                if (recMatching(s, i, tokens, tpos+1)) {
                    return true;
                }
            }
        } else {
            char c = s.charAt(spos);
            if (t.isMatch(c)) {
                return recMatching(s, spos+1, tokens, tpos+1);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        return isMatchStrStr(s, p);
    }

    private boolean isMatchRec(String s, String p) {
        List<Token> tokens = tokenize(p);
        return recMatching(s, 0, tokens, 0);
    }

    private int strStr(String s, String p, int start) {
        if (p.length() == 0) return start;

        boolean found = false;
        for (; start < s.length() - p.length() + 1; ++start) {
            int i = start;
            int j = 0;
            for (; i < s.length() && j < p.length(); ++i) {
                if (p.charAt(j) == '?') {
                    j++;
                } else {
                    if (p.charAt(j) != s.charAt(i)) {
                        break;
                    } else {
                        j++;
                    }
                }

                if (j == p.length()) {
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        if (!found) return -1;
        return start;
    }

    private boolean isMatchStrStr(String s, String p) {
        String[] patterns = p.split("\\*");

        int next = 0;
        for (String pattern : patterns) {
            next = strStr(s, pattern, next);
            if (next == -1) return false;
            next += pattern.length();
        }

        if (p.length() > 0 && p.charAt(0) != '*') {
            String pattern = patterns[0];
            String t = s.substring(0, pattern.length());
            if (strStr(t, pattern, 0) != 0) return false;
        }

        if (p.length() > 0 && p.charAt(p.length() - 1) != '*') {
            String pattern = patterns[patterns.length - 1];
            String t = s.substring(s.length() - pattern.length());
            if (strStr(t, pattern, 0) != 0) return false;
        }

        if (patterns.length == 1) {
            if (p.length() == 0 || (p.charAt(0) != '*' && p.charAt(p.length() - 1) != '*')) {
                return s.length() == p.length();
            }
        }

        return true;
    }


    private boolean isMatchDP(String s, String p) {
        boolean[][] matchTable = new boolean[s.length() + 1][];
        for (int i = 0; i <= s.length(); ++i) {
            matchTable[i] = new boolean[p.length() + 1];
            for (int j = 0; j <= p.length(); ++j) {
                matchTable[i][j] = false;
            }
        }
        matchTable[0][0] = true;
        for (int j = 1; j <= p.length(); ++j) {
            for (int i = 0; i <= s.length(); ++i) {
                char pc = p.charAt(j - 1);
                if (pc == '?') {
                    if (i > 0) {
                        matchTable[i][j] = matchTable[i - 1][j - 1];
                    } else {
                        matchTable[i][j] = false;
                    }
                } else if (pc == '*') {
                    boolean foundMatch = false;
                    for (int k = i; k >= 0; --k) {
                        if (matchTable[k][j - 1]) {
                            foundMatch = true;
                            break;
                        }
                    }
                    matchTable[i][j] = foundMatch;
                } else {
                    if (i > 0) {
                        char sc = s.charAt(i - 1);
                        if (sc == pc) {
                            matchTable[i][j] = matchTable[i - 1][j - 1];
                        } else {
                            matchTable[i][j] = false;
                        }
                    } else {
                        matchTable[i][j] = false;
                    }
                }
            }
        }
        return matchTable[s.length()][p.length()];
    }

}
