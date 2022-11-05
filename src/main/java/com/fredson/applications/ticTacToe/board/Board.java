package com.fredson.applications.ticTacToe.board;

import com.fredson.applications.ticTacToe.game.Player;

import java.util.Random;

public class Board {

    private final char[][] board = new char[3][3];
    private final Position position = new Position();

    public Board() {
        clearBoard();
    }

    private void clearBoard() {
        for (int i = 0; i < board.length; i ++ ) for (int j = 0; j < board.length; j ++)  board[i][j] = ' ';
    }

    public String getBoard() {
        StringBuilder boardString = new StringBuilder();
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board.length; j ++) {
                boardString.append(board[i][j]);
                if (j != 2) boardString.append(" | ");
            }
            boardString.append("\n");
            if (i != 2) boardString.append("---------");
            boardString.append("\n");
        }
        return boardString.toString();
    }

    public void setPosition(int row, int column, Player player) {
        if (!isEmpty(position)) throw new IllegalArgumentException("Position is invalid!");
        setPosition(row, column);
        inputPositionPlayer(position, player);
    }

    private boolean isEmpty(Position position) {
        return board[position.getRow() - 1][position.getColumn() - 1] == ' ';
    }

    public void setPosition(Player player) {
        Random positionRadom = new Random();
        while (true) {
            setPosition(positionRadom.nextInt(1, 4), positionRadom.nextInt(1, 4));
            if (isEmpty(position)) {
                inputPositionPlayer(position, player);
                break;
            }
        }
    }

    private void setPosition(int row, int column) {
        position.setRow(row);
        position.setColumn(column);
    }

    public boolean isEmpty() {
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board.length; j ++) {
                setPosition(i, j);
                if (board[position.getRow()][position.getColumn()] == ' ') return true;
            }
        }
        return true;
    }

    private void inputPositionPlayer(Position position, Player player) {
        board[position.getRow() - 1][position.getColumn() - 1] = player.getType();
    }

    public boolean getWinner(Player player) {
        return getWinnerRow(player) || getWinnerColumn(player) || getWinnerDiagonal(player);
    }

    private boolean getWinnerRow(Player player) {
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board.length; j ++) {
                setPosition(i, j);
                if (board[position.getRow()][position.getColumn()] != player.getType()) break;
                if (position.getColumn() == 2) return true;
            }
        }
        return false;
    }

    private boolean getWinnerColumn(Player player) {
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board.length; j ++) {
                setPosition(j, i);
                if (board[position.getRow()][position.getColumn()] != player.getType()) break;
                if (position.getRow() == 2) return true;
            }
        }
        return false;
    }

    private boolean getWinnerDiagonal(Player player) {
        for (int i = 0; i < board.length; i ++) {
            setPosition(i, i);
            if (board[position.getRow()][position.getColumn()] != player.getType()) break;
            if (position.getRow() == 2) return true;
        }
        for (int i = 0; i < board.length; i ++) {
            for (int j = board.length - 1; j >= 0 ; j --) {
                setPosition(i, j);
                if (board[position.getRow()][position.getColumn()] != player.getType()) return false;
                i = i + 1;
            }
            if (position.getRow() == 2 && position.getColumn() == 0) return true;
        }
        return false;
    }
}
