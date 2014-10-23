package com.jiaz.leetj;

import java.util.*;

// Given two words word1 and word2, find the minimum number of steps required 
// to convert word1 to word2. (each operation is counted as 1 step.)

// You have the following 3 operations permitted on a word:

// a) Insert a character
// b) Delete a character
// c) Replace a character

public class Q072_EditDistance {

    private int minDis;

    private int minDistance1(String word1, String word2) {
        minDis = word1.length() + word2.length();
        recMinDis(word1, 0, word2, 0, 0);
        return minDis;
    }

    private int min(int a, int b, int c) {
        int x = a;
        if (x > b) {
            x = b;
        }
        if (x > c) {
            x = c;
        }
        return x;
    }

    private int minDistance2(String word1, String word2) {
        int[][] matrix = new int[word1.length() + 1][];
        for (int i = 0; i < matrix.length; ++i) {
            matrix[i] = new int[word2.length() + 1];
        }
        // init matrix
        for (int i = 0; i < word1.length() + 1; ++i) {
            matrix[i][0] = i;
        }
        for (int i = 0; i < word2.length() + 1; ++i) {
            matrix[0][i] = i;
        }
        // DP
        for (int i = 1; i < word1.length() + 1; ++i) {
            for (int j = 1; j < word2.length() + 1; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else {
                    matrix[i][j] = min(matrix[i - 1][j - 1] + 1,
                        matrix[i][j - 1] + 1,
                        matrix[i - 1][j] + 1);
                }
            }
        }
        return matrix[word1.length()][word2.length()];
    }

    private void recMinDis(String w1, int pos1, String w2, int pos2, int dis) {
        if (pos1 == w1.length()) {
            dis += (w2.length() - pos2);
            if (dis < minDis) {
                minDis = dis;
            }
        } else if (pos2 == w2.length()) {
            dis += (w1.length() - pos1);
            if (dis < minDis) {
                minDis = dis;
            }
        } else {
            char c1 = w1.charAt(pos1);
            char c2 = w2.charAt(pos2);
            if (c1 == c2) {
                recMinDis(w1, pos1+1, w2, pos2+1, dis);
            } else {
                // replace either one
                recMinDis(w1, pos1+1, w2, pos2+1, dis+1);
                // insert in w1
                recMinDis(w1, pos1, w2, pos2+1, dis+1);
                // insert in w2
                recMinDis(w1, pos1+1, w2, pos2, dis+1);
            }
        }
    }
    
    public int minDistance(String word1, String word2) {
        return minDistance2(word1, word2);
    }

}