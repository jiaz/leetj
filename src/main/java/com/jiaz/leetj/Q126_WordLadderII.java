package com.jiaz.leetj;

import java.util.*;

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

    private static class LinkableString {
        public char[] buff;
        public List<LinkableString> linkedWords;

        public LinkableString(char[] buff) {
            this.buff = buff;
            linkedWords = new ArrayList<>();
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
            LinkableString or = (LinkableString)o;
            for (int i = 0; i < buff.length; ++i) {
                if (this.buff[i] != or.buff[i]) return false;
            }
            return true;
        }
    }

    public void buildResult(LinkableString head, LinkableString end,
        Stack<String> current, List<List<String>> res) {
        current.push(new String(head.buff));
        if (head == end) {
            res.add(new ArrayList<>(current));
        } else {
            for (LinkableString l : head.linkedWords) {
                buildResult(l, end, current, res);
            }
        }
        current.pop();
    }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<>();
        HashMap<LinkableString, LinkableString> available = new HashMap<>();
        for (String s : dict) {
            LinkableString ls = new LinkableString(s.toCharArray());
            available.put(ls, ls);
        }
        LinkableString startLS = new LinkableString(start.toCharArray());
        LinkableString endLS = new LinkableString(end.toCharArray());
        available.put(startLS, startLS);
        available.put(endLS, endLS);
        Queue<LinkableString> queue = new ArrayDeque<>();
        HashSet<LinkableString> queued = new HashSet<>();
        queue.offer(startLS);
        queued.add(startLS);
        boolean found = false;
        char[] buff = new char[start.length()];
        while (!found && !queue.isEmpty()) {
            int qSize = queue.size();
            for (LinkableString l : queue) {
                available.remove(l);
            }
            for (int i = 0; i < qSize; ++i) {
                LinkableString s = queue.poll();
                System.arraycopy(s.buff, 0, buff, 0, s.buff.length);
                for (int j = 0; j < buff.length; ++j) {
                    int tmp = (int)(buff[j] - 'a');
                    for (int k = 0; k < 26; ++k) {
                        if (k != tmp) {
                            buff[j] = (char)('a' + k);
                            LinkableString testStr = new LinkableString(buff);
                            if (available.containsKey(testStr)) {
                                LinkableString child = available.get(testStr);
                                s.linkedWords.add(child);
                                if (!queued.contains(child)) {
                                    queue.offer(child);
                                    queued.add(child);
                                }
                                if (child.equals(endLS)) found = true;
                            }
                        }
                    }
                    buff[j] = (char)('a' + tmp);
                }
            }
        }
        if (found) {
            buildResult(startLS, endLS, new Stack<String>(), result);
        }
        return result;
    }

}
