package com.radsoltan.model;

public class AttemptConfig {

    private String mDisplayName;
    private int mSeconds;

    public AttemptConfig(String displayName) {
        mDisplayName = displayName;
        mSeconds = 0;
    }

    public String getDisplayName() {
        return mDisplayName;
    }

    public int getSeconds() {
        return mSeconds;
    }

    public void decreaseSeconds() {
        if (mSeconds > 0) {
            mSeconds = mSeconds - 15;
        }
    }

    public void increaseSeconds() {
        if (mSeconds < 60 * 60) {
            mSeconds = mSeconds + 15;
        }
    }

    @Override
    public String toString() {
        return "AttemptConfig{" +
                "mDisplayName='" + mDisplayName + '\'' +
                ", mSeconds=" + mSeconds +
                '}';
    }
}
