package com.jiaz.leetj;

import java.util.*;

public class Q068_TextJustification {

    private String packLine(List<String> words, int L, int len) {
        int space = L - len;
        int wc = words.size();
        StringBuilder sb = new StringBuilder();
        if (wc == 1) {
            sb.append(words.get(0));
            for (int i = 0; i < space; ++i) {
                sb.append(" ");
            }
        } else {
            int avgsp = space / (wc - 1);
            int remaining = space % (wc - 1);
            for (int i = 0; i < wc; ++i) {
                sb.append(words.get(i));
                if (i != wc - 1) {
                    for (int j = 0; j < avgsp; ++j) {
                        sb.append(" ");
                    }
                    if (i < remaining) {
                        sb.append(" ");
                    }
                }
            }
        }
        return sb.toString();
    }

    private String packLine(List<String> words, int L) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (String w : words) {
            if (!first) {
                sb.append(" ");
            }
            first = false;
            sb.append(w);
        }
        int remaining = L - sb.length();
        for (int i = 0; i < remaining; ++i) {
            sb.append(" ");
        }
        return sb.toString();
    }
    
    public List<String> fullJustify(String[] words, int L) {
        List<String> tmp = new ArrayList<>();
        List<String> result = new ArrayList<>();
        int pos = 0;
        int len = 0;
        while (pos < words.length) {
            if (len + words[pos].length() + tmp.size() > L) {
                // pack
                result.add(packLine(tmp, L, len));
                tmp.clear();
                len = 0;
            } else {
                tmp.add(words[pos]);
                len += words[pos].length();
                pos++;
            }
        }
        if (!tmp.isEmpty()) {
            result.add(packLine(tmp, L));
        }
        return result;
    }

}