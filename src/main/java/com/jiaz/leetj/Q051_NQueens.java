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

    private void recSolve(Boolean[] rows, Boolean[] cols, Boolean[] ldiag, Boolean[] rdiag,
        int pos, Stack<Integer> marked, List<String[]> res) {
        int n = rows.length;
        if (marked.size() == n) {
            // construct result
            String[] oneRes = new String[n];
            int k = 0;
            for (int i = 0; i < n; ++i) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; ++j) {
                    if (k < n && i * n + j == marked.get(k)) {
                        sb.append('Q');
                        k++;
                    } else {
                        sb.append('.');
                    }
                }
                oneRes[i] = sb.toString();
            }
            res.add(oneRes);
        } else {
            for (int i = pos; i < n * n; ++i) {
                int row = i / n;
                int col = i % n;
                int ld = row - col + n - 1;
                int rd = row + col;

                if (!rows[row] && !cols[col] && !ldiag[ld] && !rdiag[rd]) {
                    rows[row] = true;
                    cols[col] = true;
                    ldiag[ld] = true;
                    rdiag[rd] = true;
                    marked.push(i);

                    recSolve(rows, cols, ldiag, rdiag, i + 1, marked, res);
                    
                    marked.pop();
                    rows[row] = false;
                    cols[col] = false;
                    ldiag[ld] = false;
                    rdiag[rd] = false;
                }
            }
        }
    }
    
    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<>();
        Boolean[] rows = new Boolean[n];
        Boolean[] cols = new Boolean[n];
        Boolean[] ldiag = new Boolean[2 * n - 1];
        Boolean[] rdiag = new Boolean[2 * n - 1];
        Stack<Integer> marked = new Stack<>();

        for (int i = 0; i < n; ++i) {
            rows[i] = false;
            cols[i] = false;
        }
        for (int i = 0; i < 2 * n - 1; ++i) {
            ldiag[i] = false;
            rdiag[i] = false;
        }

        recSolve(rows, cols, ldiag, rdiag, 0, marked, result);

        return result;
    }

}