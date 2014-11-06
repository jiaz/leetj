package com.jiaz.leetj;

import java.util.*;

// Write a program to solve a Sudoku puzzle by filling the empty cells.
//
// Empty cells are indicated by the character '.'.
//
// You may assume that there will be only one unique solution.

public class Q037_SudokuSolver {

    private boolean[][] rows;
    private boolean[][] cols;
    private boolean[][] blks;

    private boolean recSolveSudoku(char[][] board, int pos, List<String> res) {
        if (pos == 81) {
            // found solution
            for (int i = 0; i < 9; ++i) {
                String s = new String(board[i]);
                res.add(s);
            }
            return true;
        }
        int row = pos / 9;
        int col = pos % 9;
        int blk = row / 3 * 3 + col / 3;
        if (board[row][col] != '.') {
            return recSolveSudoku(board, pos + 1, res);
        } else {
            for (int i = 0; i < 9; ++i) {
                if (!rows[row][i] && !cols[col][i] && !blks[blk][i]) {
                    board[row][col] = (char)('1' + i);
                    rows[row][i] = true;
                    cols[col][i] = true;
                    blks[blk][i] = true;
                    if (!recSolveSudoku(board, pos + 1, res)) {
                        board[row][col] = '.';
                        rows[row][i] = false;
                        cols[col][i] = false;
                        blks[blk][i] = false;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void initBoard(char[][] board) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] != '.') {
                    int x = (int)(board[i][j] - '1');
                    rows[i][x] = true;
                    cols[j][x] = true;
                    blks[i / 3 * 3 + j / 3][x] = true;
                }
            }
        }
    }

    public List<String> solveSudoku(char[][] board) {
        List<String> result = new ArrayList<>();

        rows = new boolean[9][];
        cols = new boolean[9][];
        blks = new boolean[9][];
        for (int i = 0; i < 9; ++i) {
            rows[i] = new boolean[9];
            cols[i] = new boolean[9];
            blks[i] = new boolean[9];
            for (int j = 0; j < 9; ++j) {
                rows[i][j] = false;
                cols[i][j] = false;
                blks[i][j] = false;
            }
        }
        initBoard(board);
        recSolveSudoku(board, 0, result);

        return result;
    }

}
