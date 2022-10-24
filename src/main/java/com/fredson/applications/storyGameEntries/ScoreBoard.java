package com.fredson.applications.storyGameEntries;

import java.util.Arrays;

public class ScoreBoard {

    private int size;
    private final GameEntry[] board;

    public ScoreBoard(int capacity) {
        board = new GameEntry[capacity];
    }

    public void add(GameEntry gameEntry) {
        if (isMaxCapacity()) throw new IndexOutOfBoundsException("Max GameEntry array capacity");
        for (int i = 0; i <= size; i ++)
            if (board[i] == null) board[i] = gameEntry;
        size ++;
    }

    public GameEntry get(int index) {
        if (isInvalidIndex(index)) throw new IndexOutOfBoundsException("Invalid index");
        return board[index];
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        if (isInvalidIndex(index)) throw new IndexOutOfBoundsException("Invalid index");
        board[index] = null;
        size --;
    }

    private boolean isMaxCapacity() {
        return size >= board.length;
    }

    private boolean isInvalidIndex(int index) {
        return index < 0 || index >= board.length;
    }

    public void sort() {
        for (int i = 0; i < size; i ++) {
            for (int j = i + 1; j < size; j ++) {
                if (board[j].getScore() < board[i].getScore()) {
                    GameEntry gameEntryAux = board[j];
                    board[j] = board[i];
                    board[i] = gameEntryAux;
                }
            }
        }
    }

    public int size() {
        return size;
    }
    @Override
    public String toString() {
        return Arrays.toString(board);
    }
}
