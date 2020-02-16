package com.main;

import java.io.IOException;
import java.util.Scanner;

public class Prompter {
    private Game game;
    private String playerName;
    private Scanner scanner = new Scanner(System.in);
    public static int highestScore = 0;
    public static String highestScoredPlayer = "";

    public Prompter(Game game) {
        this.game = game;
    }

    public void promptForGuess() {
        boolean isAcceptable = false;
        do {
            System.out.print("Enter a later:   ");
            String guessInput = scanner.nextLine();
            try {
                game.applyGuess(guessInput);
                isAcceptable = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!isAcceptable);
    }

    public void displayProgress() {
        System.out.printf("You have %d tries left to solve: %s%n", game.getRemainingTries(), game.getCurrentProgress());
    }

    public void displayOutcome() {
        try {
            FileHandler.readScoreFromFile();
        } catch (IOException e) {
            System.out.println("Error occurred - can't read the highest score from the database.");
        }
        if (game.isWon()) {
            System.out.printf("Congratulation you have won with %d tries left. %n", game.getRemainingTries());
            try {
                saveIfHighestScore();
            } catch (IOException e) {
                System.out.println("Error occurred - can't save the score to the database.");
            }
        } else {
            System.out.printf("Bummer. You've lost. The word was: %s %n.", game.getAnswer());
        }
        System.out.printf("====> Leader Board <====%nPlayer Name: %s    Highest Score: %d", highestScoredPlayer, highestScore);
    }

    public void askForName() {
        System.out.println("Hello! What is your name?");
        playerName = scanner.nextLine();
        System.out.printf("Nice to meet you %s. Let's play a game of Hangman! %n", playerName);
    }

    public void saveIfHighestScore() throws IOException {
        if (game.getRemainingTries() > highestScore) {
            highestScore = game.getRemainingTries();
            highestScoredPlayer = playerName;
            FileHandler.saveScoreToFile(playerName);
        }
    }

}
