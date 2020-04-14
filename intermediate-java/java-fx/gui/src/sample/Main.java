package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Group root = new Group();
        Text txt = new Text("Sup?");
        Button btn = new Button();
        btn.setText("Say Sup!");
        root.getChildren().add(btn);
        txt.setY(25);
        root.getChildren().add(txt);
        primaryStage.setTitle("Sup App");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
