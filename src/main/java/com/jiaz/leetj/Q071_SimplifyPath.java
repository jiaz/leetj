package com.jiaz.leetj;

import java.util.*;

// Given an absolute path for a file (Unix-style), simplify it.
//
// For example,
// path = "/home/", => "/home"
// path = "/a/./b/../../c/", => "/c"

public class Q071_SimplifyPath {

    public String simplifyPath(String path) {
        Stack<String> stk = new Stack<>();
        String[] components = path.split("/");
        for (String comp : components) {
            if (comp.equals("..")) {
                if (!stk.isEmpty()) stk.pop();
            } else if (comp.equals(".")) {
                // ignore
            } else if (comp.length() == 0 || comp.equals("")) {
                // ignore
            } else {
                stk.push(comp);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (stk.isEmpty()) {
            sb.append("/");
        } else {
            for (String s : stk) {
                sb.append("/").append(s);
            }
        }
        return sb.toString();
    }

}
