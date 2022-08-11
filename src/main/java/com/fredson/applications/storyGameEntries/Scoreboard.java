package com.fredson.applications.storyGameEntries;

public class Scoreboard {

    private int numEntries;
    private GameEntry[] board;

    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }

    public void add(GameEntry gameEntry) {
        int newScore = gameEntry.getScore();
        if (numEntries < board.length || newScore > board[numEntries - 1].getScore()) {
            if (numEntries < board.length) numEntries ++;
            int gameEntryIndex = numEntries - 1;
            while(gameEntryIndex > 0 && board[gameEntryIndex].getScore() < newScore) {
                board[gameEntryIndex] = board[gameEntryIndex - 1];
                gameEntryIndex --;
            }
            board[gameEntryIndex] = gameEntry;
        }
    }

//    public GameEntry remove(GameEntry gameEntry) {
//        for (int gameEntryIndex = 0; gameEntryIndex <= board.length; gameEntryIndex ++) {
//            if (board[gameEntryIndex].equals(gameEntry)) {
//                GameEntry gameEntryRemoved = gameEntry;
//                for (int gameEntryIndex = 0; gameEntryIndex < numEntries - 1; gameEntryIndex ++) {
//                    board[gameEntryIndex] = board[gameEntryIndex + 1];
//                }
//                board[numEntries - 1] = null;
//                numEntries --;
//                return gameEntryRemoved;
//            }
//        }
//        return null;
//    }

    public GameEntry remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= numEntries) throw new IndexOutOfBoundsException("Invalid index: " + index);
        GameEntry gameEntryRemoved = board[index];
        for (int gameEntryIndex = index; gameEntryIndex < numEntries - 1; gameEntryIndex ++) {
            board[gameEntryIndex] = board[gameEntryIndex + 1];
        }
        board[numEntries - 1] = null;
        numEntries --;
        return gameEntryRemoved;
    }
}
