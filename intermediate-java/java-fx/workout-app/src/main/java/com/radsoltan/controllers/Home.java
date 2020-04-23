package com.radsoltan.controllers;

import com.radsoltan.model.Attempt;
import com.radsoltan.model.AttemptKind;
import com.radsoltan.model.AttemptType;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

public class Home {
    @FXML
    private VBox container;
    @FXML
    private Label title;

    private Attempt mCurrentAttempt;
    private final AttemptKind breakConfig;
    private final AttemptKind workoutConfig;
    private final AttemptKind prepConfig;
    private final StringProperty mTimerText;
    private final StringProperty mBreakTimeConfigText;
    private final StringProperty mWorkoutTimeConfigText;
    private Timeline mTimeline;
    private final AudioClip mSound;

    public Home() {
        mTimerText = new SimpleStringProperty();
        mBreakTimeConfigText = new SimpleStringProperty();
        mWorkoutTimeConfigText = new SimpleStringProperty();

        setTimerText(0);
        setBreakTimeConfigText(0);
        setWorkoutTimeConfigText(0);

        breakConfig = new AttemptKind("break", "Break Time!");
        workoutConfig = new AttemptKind("workout", "Workout!!!");
        prepConfig = new AttemptKind("prep", "Prepare for workout", 10);

        mSound = new AudioClip(getClass().getResource("/sounds/alarm_beep.wav").toExternalForm());
    }

    /* Getters and Setters */

    public String getTimerText() {
        return mTimerText.get();
    }

    public StringProperty timerTextProperty() {
        return mTimerText;
    }

    public void setTimerText(String timerText) {
        mTimerText.set(timerText);
    }

    public void setTimerText(int remainingSeconds) {
        setTimerText(AttemptKind.createTimerString(remainingSeconds));
    }

    public String getBreakTimeConfigText() {
        return mBreakTimeConfigText.get();
    }

    public StringProperty breakTimeConfigTextProperty() {
        return mBreakTimeConfigText;
    }

    public void setBreakTimeConfigText(String breakTimeConfigText) {
        mBreakTimeConfigText.set(breakTimeConfigText);
    }

    public void setBreakTimeConfigText(int totalSeconds) {
        setBreakTimeConfigText(AttemptKind.createTimerString(totalSeconds));
    }

    public String getWorkoutTimeConfigText() {
        return mWorkoutTimeConfigText.get();
    }

    public StringProperty workoutTimeConfigTextProperty() {
        return mWorkoutTimeConfigText;
    }

    public void setWorkoutTimeConfigText(String workoutTimeConfigText) {
        mWorkoutTimeConfigText.set(workoutTimeConfigText);
    }

    public void setWorkoutTimeConfigText(int totalSeconds) {
        setWorkoutTimeConfigText(AttemptKind.createTimerString(totalSeconds));
    }

    /* Prepare Attempt */

    private void prepareAttempt(AttemptType kind) {
        reset();
        mCurrentAttempt = new Attempt(kind);
        addAttemptStyle(kind);
        title.setText(kind.getDisplayName());
        setTimerText(mCurrentAttempt.getRemainingSeconds());

        // Create new Timeline
        mTimeline = new Timeline();
        mTimeline.setCycleCount(kind.getTotalSeconds());
        mTimeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), e -> {
            mCurrentAttempt.tick();
            setTimerText(mCurrentAttempt.getRemainingSeconds());
        }));

        // Sets an event after timeline is finished
        mTimeline.setOnFinished(e -> {
            mSound.play();
            prepareAttempt(mCurrentAttempt.getKind() == AttemptType.FOCUS ? AttemptType.BREAK : AttemptType.FOCUS);
            playTimer();
        });
    }

    private void reset() {
        clearAttemptStyles();
        setTimerText(0);
        mCurrentAttempt = null;
        if (mTimeline != null && mTimeline.getStatus() == Animation.Status.RUNNING) {
            mTimeline.stop();
        }
    }

    public void playTimer() {
        container.getStyleClass().add("playing");
        mTimeline.play();
    }

    public void pauseTimer() {
        container.getStyleClass().remove("playing");
        mTimeline.pause();
    }

    private void addAttemptStyle(AttemptType kind) {
        container.getStyleClass().add(kind.toString().toLowerCase());
    }

    private void clearAttemptStyles() {
        container.getStyleClass().remove("playing");
        for (AttemptType kind : AttemptType.values()) {
            container.getStyleClass().remove(kind.toString().toLowerCase());
        }
    }

    /* Button Handlers */

    public void handleRestart(ActionEvent actionEvent) {
        reset();
    }

    public void handlePlay(ActionEvent actionEvent) {
        if (mCurrentAttempt == null) {
            prepareAttempt(AttemptType.FOCUS);
        }
        playTimer();
    }

    public void handlePause(ActionEvent actionEvent) {
        pauseTimer();
    }

    public void handleBreakTimeIncrease(ActionEvent actionEvent) {
        breakConfig.increaseSeconds();
        setBreakTimeConfigText(breakConfig.getTotalSeconds());
    }

    public void handleBreakTimeDecrease(ActionEvent actionEvent) {
        breakConfig.decreaseSeconds();
        setBreakTimeConfigText(breakConfig.getTotalSeconds());
    }

    public void handleWorkoutTimeIncrease(ActionEvent actionEvent) {
        workoutConfig.increaseSeconds();
        setWorkoutTimeConfigText(workoutConfig.getTotalSeconds());
    }

    public void handleWorkoutTimeDecrease(ActionEvent actionEvent) {
        workoutConfig.decreaseSeconds();
        setWorkoutTimeConfigText(workoutConfig.getTotalSeconds());
    }
}
