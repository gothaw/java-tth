package com.main;

public class Game {

    private String answer;
    private String hits;
    private String misses;

    public Game(String answer) {
        this.answer = answer.toLowerCase();
        hits = "";
        misses = "";
    }

    public String getAnswer() {
        return answer;
    }

    private char normalizedGuess(char letter) {
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("A letter is required.");
        }
        letter = Character.toLowerCase(letter);
        if (hits.indexOf(letter) != -1 || misses.indexOf(letter) != -1) {
            throw new IllegalArgumentException(letter + " has already been guessed.");
        }
        return letter;
    }

    public void applyGuess(String letters) {
        if (letters.length() == 0) {
            throw new IllegalArgumentException("No letter found.");
        }
        applyGuess(letters.charAt(0));
    }

    public void applyGuess(char letter) {
        letter = normalizedGuess(letter);
        boolean isHit = answer.indexOf(letter) != -1;
        if (isHit) {
            hits += letter;
        } else {
            misses += letter;
        }
    }

    public boolean isWon() {
        return getCurrentProgress().indexOf('-') == -1;
    }

    public int getRemainingTries() {
        return Constants.MAX_MISSES - misses.length();
    }

    public String getCurrentProgress() {
        String progress = "";
        for (char letter : answer.toCharArray()) {
            char display = '-';
            // Checking if letter exists in hits string
            if (hits.indexOf(letter) != -1) {
                display = letter;
            }
            progress += display;
        }
        return progress;
    }
}
