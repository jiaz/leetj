package com.jiaz.leetj;

// Write a function to find the longest common prefix string amongst an array of strings.

public class Q014_LongestCommonPrefix {
    
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        StringBuilder sb = new StringBuilder();
        String master = strs[0];
        for (int i = 0; i < master.length(); ++i) {
            char masterC = master.charAt(i);
            boolean allMatch = true;
            for (int j = 1; j < strs.length; ++j) {
                String s = strs[j];
                if (s.length() < i + 1) {
                    allMatch = false;
                    break;
                } else {
                    char c = s.charAt(i);
                    if (c != masterC) {
                        allMatch = false;
                        break;
                    }
                }
            }
            if (!allMatch) break;
            sb.append(masterC);
        }
        return sb.toString();
    }

}