package com.main.java;

public class PezDispenser {
    // class scope
    private final String characterName;

    public PezDispenser(String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterName() {
        return characterName;
    }

    // doesn't work with final keyword
    /*public String swapHead(String characterName) {
        String originalCharacterName = this.characterName;
        this.characterName = characterName;
        return originalCharacterName;
    }*/
}
