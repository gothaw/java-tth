package com.main;

import java.util.Scanner;

public class Prompter {
    private Game game;

    public Prompter(Game game) {
        this.game = game;
    }

    public void promptForGuess() {
        Scanner scanner = new Scanner(System.in);
        boolean isAcceptable = false;
        do{
            System.out.print("Enter a later:   ");
            String guessInput = scanner.nextLine();
            try{
                game.applyGuess(guessInput);
                isAcceptable = true;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        } while (!isAcceptable);
    }

    public void displayProgress(){
        System.out.printf("You have %d tries left to solve: %s%n", game.getRemainingTries(), game.getCurrentProgress());
    }

    public void displayOutcome(){
        if(game.isWon()){
            System.out.printf("Congratulation you have won with %d tries left. %n", game.getRemainingTries());
        } else{
            System.out.printf("Bummer. You've lost. The word was: %s %n.", game.getAnswer());
        }
    }

}
