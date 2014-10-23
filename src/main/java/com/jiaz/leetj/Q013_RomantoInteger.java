package com.jiaz.leetj;

public class Q013_RomantoInteger {
    
    public int romanToInt(String s) {
        int result = 0;
        boolean seenV = false;
        boolean seenL = false;
        boolean seenD = false;
        for (int i = s.length() - 1; i >= 0; --i) {
            char c = s.charAt(i);
            switch(c) {
                case 'I':
                    if (seenV) {
                        result -= 1;
                    } else {
                        result += 1;
                    }
                    break;
                case 'V':
                    result += 5;
                    seenV = true;
                    break;
                case 'X':
                    if (seenL) {
                        result -= 10;
                    } else {
                        result += 10;
                    }
                    seenV = true;
                    break;
                case 'L':
                    result += 50;
                    seenL = true;
                    break;
                case 'C':
                    if (seenD) {
                        result -= 100;
                    } else {
                        result += 100;
                    }
                    seenL = true;
                    break;
                case 'D':
                    result += 500;
                    seenD = true;
                    break;
                case 'M':
                    result += 1000;
                    seenD = true;
                    break;
                default:
                    break;
            }
        }
        return result;
    }

}