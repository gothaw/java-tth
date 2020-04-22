package com.radsoltan.controllers;

import com.radsoltan.model.Attempt;
import com.radsoltan.model.AttemptConfig;
import com.radsoltan.model.AttemptKind;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

import java.lang.annotation.AnnotationTypeMismatchException;

public class Home {
    @FXML
    private VBox container;
    @FXML
    private Label title;

    private Attempt mCurrentAttempt;
    private final AttemptConfig breakConfig;
    private final AttemptConfig workoutConfig;
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

        breakConfig = new AttemptConfig("Break Time!");
        workoutConfig = new AttemptConfig("Workout!!!");
        mSound = new AudioClip(getClass().getResource("/sounds/alarm_beep.wav").toExternalForm());
    }

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
        setTimerText(prepareTimerString(remainingSeconds));
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
        setBreakTimeConfigText(prepareTimerString(totalSeconds));
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
        setWorkoutTimeConfigText(prepareTimerString(totalSeconds));
    }

    private String prepareTimerString(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    private void prepareAttempt(AttemptKind kind) {
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
            prepareAttempt(mCurrentAttempt.getKind() == AttemptKind.FOCUS ? AttemptKind.BREAK : AttemptKind.FOCUS);
        });
    }

    private void reset() {
        clearAttemptStyles();
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

    private void addAttemptStyle(AttemptKind kind) {
        container.getStyleClass().add(kind.toString().toLowerCase());
    }

    private void clearAttemptStyles() {
        container.getStyleClass().remove("playing");
        for (AttemptKind kind : AttemptKind.values()) {
            container.getStyleClass().remove(kind.toString().toLowerCase());
        }
    }

    public void handleRestart(ActionEvent actionEvent) {
        prepareAttempt(AttemptKind.FOCUS);
        playTimer();
    }

    public void handlePlay(ActionEvent actionEvent) {
        if (mCurrentAttempt == null){
            handleRestart(actionEvent);
        } else {
            playTimer();
        }
    }

    public void handlePause(ActionEvent actionEvent) {
        pauseTimer();
    }

    public void handleBreakTimeIncrease(ActionEvent actionEvent) {
        breakConfig.increaseSeconds();
        setBreakTimeConfigText(breakConfig.getSeconds());
    }

    public void handleBreakTimeDecrease(ActionEvent actionEvent) {
        breakConfig.decreaseSeconds();
        setBreakTimeConfigText(breakConfig.getSeconds());
    }

    public void handleWorkoutTimeIncrease(ActionEvent actionEvent) {
        workoutConfig.increaseSeconds();
        setWorkoutTimeConfigText(workoutConfig.getSeconds());
    }

    public void handleWorkoutTimeDecrease(ActionEvent actionEvent) {
        workoutConfig.decreaseSeconds();
        setWorkoutTimeConfigText(workoutConfig.getSeconds());
    }
}
