package com.jiaz.leetj;

// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

// P   A   H   N
// A P L S I I G
// Y   I   R

// And then read line by line: "PAHNAPLSIIGYIR"
// Write the code that will take a string and make this conversion given a number of rows:
// convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

public class Q006_ZigZagConversion {
    
    public String convert(String s, int nRows) {

        if (nRows <= 1) return s;

        StringBuilder[] sbArray = new StringBuilder[nRows];
        for (int i = 0; i < nRows; ++i) {
            sbArray[i] = new StringBuilder();
        }
        boolean isDown = true;
        int currentSb = 0;
        int pos = 0;
        while (pos < s.length()) {
            StringBuilder sb = sbArray[currentSb];
            sb.append(s.charAt(pos));
            pos++;
            if (isDown && currentSb == nRows - 1) {
                isDown = false;
            } else if (!isDown && currentSb == 0) {
                isDown = true;
            }

            if (isDown) {
                currentSb++;
            } else {
                currentSb--;
            }
        }
        
        StringBuilder resBuilder = new StringBuilder();
        for (int i = 0; i < nRows; ++i) {
            resBuilder.append(sbArray[i].toString());
        }
        return resBuilder.toString();
    }

}
