package com.jiaz.leetj;

import java.util.*;

// Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

// A region is captured by flipping all 'O's into 'X's in that surrounded region .

// For example,

// X X X X
// X O O X
// X X O X
// X O X X
// After running your function, the board should be:

// X X X X
// X X X X
// X X X X
// X O X X

public class Q130_SurroundedRegions {

    private char[][] board;
    private boolean[][] openMap;
    private Queue<Pair> openQueue;
    private int m;
    private int n;

    private static class Pair {
        public int row;
        public int col;
        public Pair(int r, int c) {
            row = r;
            col = c;
        }
    }

    private void enqueue(int i, int j) {
        if (!openMap[i][j] && board[i][j] == 'O') {
            openMap[i][j] = true;
            openQueue.add(new Pair(i, j));
        }
    }

    public char[][] solve(char[][] board) {
        this.board = board;

        m = board.length;
        if (m == 0) return board;
        n = board[0].length;
        if (n == 0) return board;

        openMap = new boolean[m][n];
        openQueue = new LinkedList<>();

        for (int i = 0; i < m; ++i) {
            enqueue(i, 0);
            enqueue(i, n - 1);
        }
        for (int j = 1; j < n - 1; ++j) {
            enqueue(0, j);
            enqueue(m - 1, j);
        }

        while (!openQueue.isEmpty()) {
            int size = openQueue.size();
            for (int i = 0; i < size; ++i) {
                Pair p = openQueue.remove();
                if (p.row > 0) {
                    enqueue(p.row - 1, p.col);
                }
                if (p.row < m - 1) {
                    enqueue(p.row + 1, p.col);
                }
                if (p.col > 0) {
                    enqueue(p.row, p.col - 1);
                }
                if (p.col < n - 1) {
                    enqueue(p.row, p.col + 1);
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O' && openMap[i][j] == false) {
                    board[i][j] = 'X';
                }
            }
        }
        return board;
    }

}
