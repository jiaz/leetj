package com.jiaz.leetj;

import java.util.*;

// Given an integer n, return all distinct solutions to the n-queens puzzle.

// Each solution contains a distinct board configuration of the n-queens' placement, 
// where 'Q' and '.' both indicate a queen and an empty space respectively.

// For example,
// There exist two distinct solutions to the 4-queens puzzle:

// [
//  [".Q..",  // Solution 1
//   "...Q",
//   "Q...",
//   "..Q."],

//  ["..Q.",  // Solution 2
//   "Q...",
//   "...Q",
//   ".Q.."]
// ]

public class Q051_NQueens {

    private List<String[]> result;
    private Boolean[] rows;
    private Boolean[] cols;
    private Boolean[] ldiag;
    private Boolean[] rdiag;

    private void recSolve(Stack<Integer> marked, List<String[]> res, int n) {
        if (marked.size() == n) {
            // construct result
            String[] oneRes = new String[n];
            for (int i = 0; i < n; ++i) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; ++j) {
                    if (j == marked.get(i)) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                oneRes[i] = sb.toString();
            }
            res.add(oneRes);
        } else {
            for (int i = 0; i < n; ++i) {
                int row = marked.size();
                int col = i;
                int ld = row - col + n - 1;
                int rd = row + col;

                if (!rows[row] && !cols[col] && !ldiag[ld] && !rdiag[rd]) {
                    rows[row] = true; cols[col] = true;
                    ldiag[ld] = true; rdiag[rd] = true;
                    marked.push(i);

                    recSolve(marked, res, n);
                    
                    marked.pop();
                    rows[row] = false; cols[col] = false;
                    ldiag[ld] = false; rdiag[rd] = false;
                }
            }
        }
    }
    
    public List<String[]> solveNQueens(int n) {
        result = new ArrayList<>();
        rows = new Boolean[n];
        cols = new Boolean[n];
        ldiag = new Boolean[2 * n - 1];
        rdiag = new Boolean[2 * n - 1];

        Stack<Integer> marked = new Stack<>();

        for (int i = 0; i < n; ++i) {
            rows[i] = false;
            cols[i] = false;
        }
        for (int i = 0; i < 2 * n - 1; ++i) {
            ldiag[i] = false;
            rdiag[i] = false;
        }

        recSolve(marked, result, n);

        return result;
    }

}