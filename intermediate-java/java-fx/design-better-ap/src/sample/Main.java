package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Group root = new Group();
        Text txt = new Text("Sup?");
        txt.setFont(new Font("Gabriola", 80));
        Label label = new Label("Name:");
        TextField nameFld = new TextField();
        GridPane grid = new GridPane();
        Button btn = new Button();
        VBox box = new VBox();

        grid.add(label, 0, 0);
        grid.add(nameFld, 1, 0);
        grid.add(btn, 1, 1);
//        grid.setGridLinesVisible(true);
        grid.setHgap(20);
        btn.setText("Say Sup!");
        btn.setOnAction(evt -> System.out.printf("Sup %s!? %n", nameFld.getText()));
        txt.setY(50);

        box.getChildren().addAll(txt, grid);
        root.getChildren().add(box);

        primaryStage.setTitle("Sup App");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
