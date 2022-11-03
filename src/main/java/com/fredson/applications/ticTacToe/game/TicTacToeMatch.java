package com.fredson.applications.ticTacToe.game;

import com.fredson.applications.ticTacToe.board.Board;

public class TicTacToeMatch {

    private Board board;
    private Player opponentPlayer;
    private Player currentPlayer;
    private int turn;

    public TicTacToeMatch() {
        board = new Board();
        currentPlayer = new Player('X');
        opponentPlayer = new Player('O');
        turn = 1;
    }

    public boolean isFinish() {
        return !board.isEmpty() || getWinner() != null;
    }

    public String getBoard() {
        return board.getBoard();
    }

    public String getCurrentPlayer() {
        return currentPlayer.toString();
    }

    public String getOpponentPlayer() {
        return opponentPlayer.toString();
    }

    public int getTurn() {
        return turn;
    }

    public String getWinner() {
        if (board.getWinner(currentPlayer.toString().charAt(0))) return currentPlayer.toString();
        if (board.getWinner(opponentPlayer.toString().charAt(0))) return opponentPlayer.toString();
        if (!board.isEmpty()) return "TIE!";
        return null;
    }

    private boolean isCurrentPlayerWinner() {
        return false;
    }

    public void setPosition(int row, int column) {
        if (!hasWinner()) setCurrentPlayerPosition(row, column);
        if (!hasWinner()) setOpponentPlayerPosition();
        turn += 1;
    }

    private boolean hasWinner() {
        return getWinner() != null;
    }

    private void setCurrentPlayerPosition(int row, int column) {
        board.setPosition(row, column, currentPlayer);
    }

    private void setOpponentPlayerPosition() {
        board.setPosition(opponentPlayer);
    }
}
