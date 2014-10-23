package com.jiaz.leetj;

public class Q012_IntegertoRoman {
    
    private String romanChar(int digit, int magnitude) {
        String[][] mappings = new String[][] {
            { "I", "V" },
            { "X", "L" },
            { "C", "D" },
            { "M", "?" },
            { "?", "?" }
        };

        StringBuilder sb = new StringBuilder();

        String base = mappings[magnitude][0];
        String mid = mappings[magnitude][1];
        String next = mappings[magnitude + 1][0];

        if (magnitude < 3) {
            if (digit >= 5) {
                if (digit == 9) {
                    sb.append(base).append(next);
                    digit -= 9;
                } else {
                    sb.append(mid);
                    digit -= 5;
                }
            }
            if (digit == 4) {
                sb.append(base).append(mid);
            } else {
                for (int i = 0; i < digit; ++i) {
                    sb.append(base);
                }
            }
        } else {
            for (int i = 0; i < digit; ++i) {
                sb.append(base);
            }
        }
        return sb.toString();
    }

    public String intToRoman(int num) {
        String result = "";
        int magnitude = 0;
        while (num > 0) {
            int digit = num % 10;
            result = romanChar(digit, magnitude) + result;
            magnitude++;
            num /= 10;
        }
        return result;
    }

}