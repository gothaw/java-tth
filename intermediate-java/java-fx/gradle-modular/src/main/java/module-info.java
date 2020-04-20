module com.teamtreehouse.pomodoro {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.teamtreehouse.pomodoro to javafx.fxml;
    opens com.teamtreehouse.pomodoro.controllers to javafx.fxml;
    exports com.teamtreehouse.pomodoro;
    exports com.teamtreehouse.pomodoro.controllers;
    exports com.teamtreehouse.pomodoro.model;
}