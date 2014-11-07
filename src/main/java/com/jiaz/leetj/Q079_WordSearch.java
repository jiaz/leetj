package com.jiaz.leetj;

import java.util.*;

// Given a 2D board and a word, find if the word exists in the grid.
//
// The word can be constructed from letters of sequentially adjacent cell,
// where "adjacent" cells are those horizontally or vertically neighboring.
// The same letter cell may not be used more than once.
//
// For example,
// Given board =
//
// [
//   ["ABCE"],
//   ["SFCS"],
//   ["ADEE"]
// ]
// word = "ABCCED", -> returns true,
// word = "SEE", -> returns true,
// word = "ABCB", -> returns false.

public class Q079_WordSearch {

    private boolean recSearch(char[][] board, boolean[][] map, int y, int x, int pos, String w) {
        if (pos == w.length()) return true;

        if ((y < 0 || y >= map.length) || (x < 0 || x >= map[y].length) || map[y][x] == true) {
            return false;
        }
        if (board[y][x] == w.charAt(pos)) {
            map[y][x] = true;
            if (recSearch(board, map, y + 1, x, pos + 1, w)) {
                return true;
            }
            if (recSearch(board, map, y - 1, x, pos + 1, w)) {
                return true;
            }
            if (recSearch(board, map, y, x - 1, pos + 1, w)) {
                return true;
            }
            if (recSearch(board, map, y, x + 1, pos + 1, w)) {
                return true;
            }
            map[y][x] = false;
            return false;
        } else {
            return false;
        }
    }

    private boolean search(char[][] board, int sy, int sx, String word) {
        boolean[][] map = new boolean[board.length][];
        for (int i = 0; i < map.length; ++i) {
            map[i] = new boolean[board[i].length];
            for (int j = 0; j < map[i].length; ++j) {
                map[i][j] = false;
            }
        }
        return recSearch(board, map, sy, sx, 0, word);
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    if (search(board, i, j, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
