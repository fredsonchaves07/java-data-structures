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
        System.out.println("TURN: " + ticTacToeMatch.getTurn());
        System.out.print("Select position (row,column): ");
        String inputPosition = scanner.nextLine();
        int row = Integer.parseInt(String.valueOf(inputPosition.charAt(0)));
        int column = Integer.parseInt(inputPosition.split(",")[1]);
        ticTacToeMatch.setPosition(row, column);
        while (!ticTacToeMatch.isFinish()) {
            clear();
            System.out.print(ticTacToeMatch.getBoard());
            System.out.println("TURN: " + ticTacToeMatch.getTurn());
            System.out.print("Select position (row,column): ");
            inputPosition = scanner.nextLine();
            row = Integer.parseInt(String.valueOf(inputPosition.charAt(0)));
            column = Integer.parseInt(inputPosition.split(",")[1]);
            ticTacToeMatch.setPosition(row, column);
        }
        clear();
        System.out.print(ticTacToeMatch.getBoard());
        System.out.println("FINISH!!");
        System.out.println("WINNER: " + ticTacToeMatch.getWinner());
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
