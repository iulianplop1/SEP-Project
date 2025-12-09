package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/GUI.fxml"));

            Parent root = loader.load();
            Scene scene = new Scene(root);

            scene.getStylesheets().add("style.css");


            primaryStage.setTitle("CloverVille");
            primaryStage.setScene(scene);
            primaryStage.resizableProperty().setValue(Boolean.FALSE);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("\n*** ERROR: Failed to load GUI.fxml. Check the file path and placement in your resources. ***\n");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}