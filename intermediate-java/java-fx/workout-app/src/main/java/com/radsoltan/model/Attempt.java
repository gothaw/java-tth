package com.radsoltan.model;

public class Attempt {
    private int mRemainingSeconds;
    private AttemptType mKind;

    public Attempt(AttemptType kind) {
        mKind = kind;
        mRemainingSeconds = mKind.getTotalSeconds();
    }

    public int getRemainingSeconds() {
        return mRemainingSeconds;
    }

    public AttemptType getKind() {
        return mKind;
    }

    public void tick() {
        mRemainingSeconds--;
    }

    @Override
    public String toString() {
        return "Attempt{" +
                "mRemainingSeconds=" + mRemainingSeconds +
                ", mKind=" + mKind +
                '}';
    }
}
