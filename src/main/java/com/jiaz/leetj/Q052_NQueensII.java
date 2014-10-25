package com.jiaz.leetj;

import java.util.*;

// Follow up for N-Queens problem.

// Now, instead outputting board configurations, return the total number of distinct solutions.

public class Q052_NQueensII {
    private int totalCount;
    private boolean[] rows;
    private boolean[] cols;
    private boolean[] ldiag;
    private boolean[] rdiag;

    private void recSolve(int row, int n) {
        if (row == n) {
            totalCount++;
            return;
        }

        for (int i = 0; i < n; ++i) {
            int r = row;
            int c = i;
            int ld = n - 1 - (r - c);
            int rd = r + c;
            if (!rows[r] && !cols[c] && !ldiag[ld] && !rdiag[rd]) {
                rows[r] = true; cols[c] = true;
                ldiag[ld] = true; rdiag[rd] = true;

                recSolve(row + 1, n);

                rows[r] = false; cols[c] = false;
                ldiag[ld] = false; rdiag[rd] = false;
            }
        }
    }
    
    public int totalNQueens(int n) {
        totalCount = 0;

        rows = new boolean[n];
        cols = new boolean[n];
        ldiag = new boolean[2 * n - 1];
        rdiag = new boolean[2 * n - 1];

        for (int i = 0; i < n; ++i) {
            rows[i] = false;
            cols[i] = false;
        }

        for (int i = 0; i < 2 * n - 1; ++i) {
            ldiag[i] = false;
            rdiag[i] = false;
        }

        recSolve(0, n);

        return totalCount;
    }

}