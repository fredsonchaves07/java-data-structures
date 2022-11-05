package com.fredson.applications.ticTacToe.game;

public class Player {

    private final char type;

    public Player(char type) {
        this.type = type;
    }

    public char getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.valueOf(type);
    }
}
