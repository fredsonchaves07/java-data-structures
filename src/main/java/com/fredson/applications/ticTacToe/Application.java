package com.fredson.applications.ticTacToe;

import com.fredson.applications.ticTacToe.game.TicTacToeMatch;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        TicTacToeMatch ticTacToeMatch = new TicTacToeMatch();
        System.out.print(ticTacToeMatch.getBoard());
        System.out.println("Welcome to Tic Tac Toe Game!");
        System.out.println("You: " + ticTacToeMatch.getCurrentPlayer());
        System.out.println("Opponet: " + ticTacToeMatch.getOpponentPlayer());
        System.out.print("Select position (row,column): ");
        String inputPosition = scanner.nextLine();
        int column = Integer.parseInt(String.valueOf(inputPosition.charAt(0)));
        int row = Integer.parseInt(inputPosition.split(",")[1]);
        ticTacToeMatch.setPosition(row, column);
        System.out.print(ticTacToeMatch.getBoard());
//        while (!ticTacToeMatch.isFinish()) {
//            ticTacToeMatch.getBoard();
//        }
    }
}
