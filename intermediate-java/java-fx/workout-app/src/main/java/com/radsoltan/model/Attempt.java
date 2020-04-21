package com.radsoltan.model;

public class Attempt {
    private int mRemainingSeconds;
    private AttemptKind mKind;

    public Attempt(AttemptKind kind) {
        mKind = kind;
        mRemainingSeconds = mKind.getTotalSeconds();
    }


    public int getRemainingSeconds() {
        return mRemainingSeconds;
    }

    public AttemptKind getKind() {
        return mKind;
    }

    public void tick() {
        mRemainingSeconds--;
    }

    public void save() {
        // Mock of the method
        System.out.printf("Saving: %s %n", this);
    }

    @Override
    public String toString() {
        return "Attempt{" +
                "mRemainingSeconds=" + mRemainingSeconds +
                ", mKind=" + mKind +
                '}';
    }
}
