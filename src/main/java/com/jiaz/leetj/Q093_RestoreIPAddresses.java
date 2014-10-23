package com.jiaz.leetj;

import java.util.*;

// Given a string containing only digits, restore it by returning all possible valid IP address combinations.

// For example:
// Given "25525511135",

// return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

public class Q093_RestoreIPAddresses {

    private boolean isValid(String v) {
        if (v.length() > 1 && v.charAt(0) == '0') return false;
        if (v.length() > 3) return false;
        Integer val = Integer.valueOf(v);
        return val != null && val >= 0 && val <= 255;
    }

    private void recRestoreIp(String s, int pos, Stack<Integer> dots, List<String> res) {
        if (dots.size() == 3) {
            // nothing left
            if (pos >= s.length()) return;
            // check remaining is >= 0 and <= 255
            String sub = s.substring(pos);
            if (isValid(sub)) {
                StringBuilder sb = new StringBuilder();
                int j = 0;
                for (int i = 0; i < s.length(); ++i) {
                    if (j < dots.size() && i == dots.get(j)) {
                        sb.append(".");
                        j++;
                    }
                    sb.append(s.charAt(i));
                }
                res.add(sb.toString());
            }
        } else {
            for (int i = 1; i <= 3 && pos + i <= s.length(); ++i) {
                String subs = s.substring(pos, pos + i);
                if (isValid(subs)) {
                    dots.push(pos + i);
                    recRestoreIp(s, pos + i, dots, res);
                    dots.pop();
                }
            }
        }
    }
    
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        recRestoreIp(s, 0, new Stack<Integer>(), result);
        return result;
    }

}