package com.jiaz.leetj;

// Given two words (start and end), and a dictionary, find all shortest transformation 
// sequence(s) from start to end, such that:

// Only one letter can be changed at a time
// Each intermediate word must exist in the dictionary
// For example,

// Given:
// start = "hit"
// end = "cog"
// dict = ["hot","dot","dog","lot","log"]

// Return

//   [
//     ["hit","hot","dot","dog","cog"],
//     ["hit","hot","lot","log","cog"]
//   ]
// Note:

// All words have the same length.
// All words contain only lowercase alphabetic characters.

public class Q126_WordLadderII {

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
    
    public void method() {
        
    }

}