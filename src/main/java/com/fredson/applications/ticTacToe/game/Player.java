package com.fredson.applications.ticTacToe.game;

public class Player {

    private char type;

    public Player(char type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.valueOf(type);
    }
}
