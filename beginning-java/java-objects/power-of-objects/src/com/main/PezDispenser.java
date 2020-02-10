package com.main;

class PezDispenser {
    // class scope
    private final String characterName;
    public static final int MAX_PEZ = 12;
    private int pezCount;

    public PezDispenser(String characterName) {
        this.characterName = characterName;
        pezCount = 0;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void fill() {
        fill(MAX_PEZ);
    }

    public void fill(int pezAmount){
        int newAmount = pezCount + pezAmount;
        if(newAmount > MAX_PEZ){
            throw new IllegalArgumentException("To many PEZ!");
        }
        pezCount += pezAmount;
    }

    public boolean isEmpty() {
        return pezCount == 0;
    }

    public boolean dispense(){
        boolean wasDispensed = false;
        if(!isEmpty()){
            pezCount--;
            wasDispensed = true;
        }
        return wasDispensed;
    }
}
