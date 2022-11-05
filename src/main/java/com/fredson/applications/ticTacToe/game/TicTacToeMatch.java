package com.fredson.applications.ticTacToe.game;

import com.fredson.applications.ticTacToe.board.Board;

public class TicTacToeMatch {

    private final Board board;
    private final Player opponentPlayer;
    private final Player currentPlayer;
    private int turn;
    private static final char X = 'X';
    private static final char O = 'O';

    public TicTacToeMatch() {
        board = new Board();
        currentPlayer = new Player(X);
        opponentPlayer = new Player(O);
        turn = 1;
    }

    public boolean isFinish() {
        return !board.isEmpty() || getWinner() != null;
    }

    public String getWinner() {
        if (isCurrentPlayerWinner()) return getCurrentPlayer();
        if (isOpponentPlayerWinner()) return getOpponentPlayer();
        if (isTie()) return "TIE!";
        return null;
    }

    private boolean isCurrentPlayerWinner() {
        return board.getWinner(currentPlayer);
    }

    private boolean isOpponentPlayerWinner() {
        return board.getWinner(opponentPlayer);
    }

    private boolean isTie() {
        return !board.isEmpty();
    }

    public String getCurrentPlayer() {
        return currentPlayer.toString();
    }

    public String getOpponentPlayer() {
        return opponentPlayer.toString();
    }

    public String getBoard() {
        return board.getBoard();
    }

    public int getTurn() {
        return turn;
    }

    public void setPosition(int row, int column) {
        if (!haveWinner()) setCurrentPlayerPosition(row, column);
        if (!haveWinner()) setOpponentPlayerPosition();
        turn += 1;
    }

    private boolean haveWinner() {
        return getWinner() != null;
    }

    private void setCurrentPlayerPosition(int row, int column) {
        board.setPosition(row, column, currentPlayer);
    }

    private void setOpponentPlayerPosition() {
        board.setPosition(opponentPlayer);
    }
}
