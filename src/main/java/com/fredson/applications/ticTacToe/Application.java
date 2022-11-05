package com.fredson.applications.ticTacToe;

import com.fredson.applications.ticTacToe.game.TicTacToeMatch;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToeMatch ticTacToeMatch = new TicTacToeMatch();
        printBoard(ticTacToeMatch);
        printWelcomeGame(ticTacToeMatch);
        while (!ticTacToeMatch.isFinish()) {
            printTurn(ticTacToeMatch);
            inputPosition(scanner, ticTacToeMatch);
            clear();
            printBoard(ticTacToeMatch);
        }
        clear();
        printEndGame(ticTacToeMatch);
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printBoard(TicTacToeMatch ticTacToeMatch) {
        System.out.print(ticTacToeMatch.getBoard());
    }

    public static void printWelcomeGame(TicTacToeMatch ticTacToeMatch) {
        System.out.println("Welcome to Tic Tac Toe Game!");
        System.out.println("You: " + ticTacToeMatch.getCurrentPlayer());
        System.out.println("Opponet: " + ticTacToeMatch.getOpponentPlayer());
    }

    public static void printTurn(TicTacToeMatch ticTacToeMatch) {
        System.out.println("TURN: " + ticTacToeMatch.getTurn());
    }

    public static void inputPosition(Scanner scanner, TicTacToeMatch ticTacToeMatch) {
        System.out.print("Select position (row,column): ");
        String inputPosition = scanner.nextLine();
        int row = Integer.parseInt(String.valueOf(inputPosition.charAt(0)));
        int column = Integer.parseInt(inputPosition.split(",")[1]);
        ticTacToeMatch.setPosition(row, column);
    }

    public static void printEndGame(TicTacToeMatch ticTacToeMatch) {
        printBoard(ticTacToeMatch);
        System.out.println("FINISH!!");
        System.out.println("WINNER: " + ticTacToeMatch.getWinner());
    }
}
