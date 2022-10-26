package com.fredson.applications.ticTacToe.board;

public class Board {

    private final char[][] board = new char[3][3];
    private static final char X = 'X';
    private static final char O = 'O';

    public Board() {
        clearBoard();
    }

    private void clearBoard() {
        for (int i = 0; i <= board.length; i ++ ) {
            for (int j = 0; j <= board.length; j ++) {
                board[i][j] = ' ';
            }
        }
    }
}
