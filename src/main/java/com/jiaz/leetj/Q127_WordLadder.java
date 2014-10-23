package com.jiaz.leetj;

import java.util.*;

// Given two words (start and end), and a dictionary, find the length of shortest 
// transformation sequence from start to end, such that:

// Only one letter can be changed at a time
// Each intermediate word must exist in the dictionary
// For example,

// Given:
// start = "hit"
// end = "cog"
// dict = ["hot","dot","dog","lot","log"]
// As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
// return its length 5.

// Note:
// Return 0 if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.

public class Q127_WordLadder {

    private static class RawString {
        public char[] buff;

        public RawString(char[] buff) {
            this.buff = buff;
        }

        public int hashCode() {
            int h = 7;
            for (int i = 0; i < buff.length; ++i) {
                h *= 31;
                h += (int)buff[i];
            }
            return h;
        }

        public boolean equals(Object o) {
            if (o == this) return true;
            if (o == null || o.getClass() != this.getClass()) return false;
            RawString or = (RawString)o;
            for (int i = 0; i < buff.length; ++i) {
                if (this.buff[i] != or.buff[i]) return false;
            }
            return true;
        }
    }
    
    public int ladderLength(String start, String end, Set<String> dict) {
        List<RawString> currentLevel = new ArrayList<>();
        List<RawString> nextLevel = new ArrayList<>();
        HashMap<RawString, RawString> remaining = new HashMap<>();
        HashSet<RawString> seen = new HashSet<>();
        for (String s : dict) {
            RawString rs = new RawString(s.toCharArray());
            remaining.put(rs, rs);
        }
        int levels = 1;
        RawString rawStart = new RawString(start.toCharArray());
        RawString rawEnd = new RawString(end.toCharArray());
        remaining.put(rawStart, rawStart);
        remaining.put(rawEnd, rawEnd);
        currentLevel.add(rawStart);
        seen.add(rawStart);
        RawString rs = new RawString(new char[start.length()]);
        while (currentLevel.size() > 0) {
            int size = currentLevel.size();
            levels++;
            for (int n = 0; n < size; ++n) {
                RawString current = currentLevel.get(n);
                for (int i = 0; i < rs.buff.length; ++i) {
                    rs.buff[i] = current.buff[i];
                }
                for (int i = 0; i < rs.buff.length; ++i) {
                    char tc = rs.buff[i];
                    for (int j = 0; j < 26; ++j) {
                        char c = (char)('a' + j);
                        if (tc != c) {
                            rs.buff[i] = c;
                            if (remaining.containsKey(rs) && !seen.contains(rs)) {
                                if (rs.equals(rawEnd)) return levels;
                                RawString rrs = remaining.get(rs);
                                nextLevel.add(rrs);
                                seen.add(rrs);
                            }
                        }
                    }
                    rs.buff[i] = tc;
                }
            }
            List<RawString> temp = currentLevel;
            currentLevel.clear();
            currentLevel = nextLevel;
            nextLevel = temp;
        }

        return 0;
    }

}