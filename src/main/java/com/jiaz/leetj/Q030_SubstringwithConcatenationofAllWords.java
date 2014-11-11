package com.jiaz.leetj;

import java.util.*;

public class Q030_SubstringwithConcatenationofAllWords {

    private void increment(HashMap<String, Integer> map, String str) {
        if (map.containsKey(str)) {
            map.put(str, map.get(str) + 1);
        }
    }

    private void decrement(HashMap<String, Integer> map, String str) {
        if (map.containsKey(str)) {
            map.put(str, map.get(str) - 1);
        }
    }

    private boolean isAllZero(HashMap<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) return false;
        }
        return true;
    }

    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<>();

        if (L.length == 0) return result;

        int n = L[0].length();
        HashMap<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < L.length; ++i) {
            if (counts.containsKey(L[i])) {
                counts.put(L[i], counts.get(L[i]) + 1);
            } else {
                counts.put(L[i], 1);
            }
        }

        for (int i = 0; i < n; ++i) {
            int count = 0;
            int j = i;
            LinkedList<String> q = new LinkedList<>();
            while (j + n <= S.length()) {
                if (count == L.length) {
                    // remove first
                    increment(counts, q.remove());
                } else {
                    // increment count
                    count++;
                }
                String substr = S.substring(j, j + n);
                decrement(counts, substr);
                q.add(substr);

                j += n;

                if (count == L.length && isAllZero(counts)) {
                    result.add(j - n * L.length);
                }
            }
            for (String s : q) {
                increment(counts, s);
            }
        }
        Collections.sort(result);
        return result;
    }

}
