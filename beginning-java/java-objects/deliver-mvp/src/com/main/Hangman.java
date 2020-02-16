package com.main;

public class Hangman {

    public static void main(String[] args) {
        /*if(args.length == 0){
            System.out.println("Usage: java Hangman <answer>");
            System.err.println("answer is required");
            System.exit(1);
        }*/
        Game game = new Game("treehouse");
        Prompter prompter = new Prompter(game);
        prompter.askForName();
        while (game.getRemainingTries() > 0 && !game.isWon()){
            prompter.displayProgress();
            prompter.promptForGuess();
        }
        prompter.displayOutcome();
    }
}
