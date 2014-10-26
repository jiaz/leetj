package com.jiaz.leetj;

import java.util.*;

// Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
//
// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

public class Q036_ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][];
        boolean[][] cols = new boolean[9][];
        boolean[][] groups = new boolean[9][];
        for (int i = 0; i < 9; ++i) {
            rows[i] = new boolean[9];
            cols[i] = new boolean[9];
            groups[i] = new boolean[9];
        }
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                rows[i][j] = false;
                cols[i][j] = false;
                groups[i][j] = false;
            }
        }

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char c = board[i][j];
                if (c != '.') {
                    int grow = i / 3;
                    int gcol = j / 3;
                    int gnum = grow * 3 + gcol;
                    int x = c - '1';
                    if (rows[i][x] || cols[j][x] || groups[gnum][x]) return false;
                    rows[i][x] = true;
                    cols[j][x] = true;
                    groups[gnum][x] = true;
                }
            }
        }

        return true;
    }

}
