package com.jiaz.leetj;

import java.util.*;

// Given an array of strings, return all groups of strings that are anagrams.
//
// Note: All inputs will be in lower-case.

public class Q049_Anagrams {

    private String getCanonicalString(String s) {
        if (s.length() <= 1) return s;
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public List<String> anagrams(String[] strs) {
        TreeMap<String, List<String>> res = new TreeMap<>();
        for (int i = 0; i < strs.length; ++i) {
            String cs = getCanonicalString(strs[i]);
            if (res.containsKey(cs)) {
                List<String> lst = res.get(cs);
                lst.add(strs[i]);
            } else {
                List<String> lst = new LinkedList<>();
                lst.add(strs[i]);
                res.put(cs, lst);
            }
        }
        List<String> lstHead = new LinkedList<>();
        for (List<String> lst : res.values()) {
            if (lst.size() > 1) {
                lstHead.addAll(lst);
            }
        }
        return lstHead;
    }

}
