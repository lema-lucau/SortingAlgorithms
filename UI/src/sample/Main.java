package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent startScreenroot = FXMLLoader.load(getClass().getResource("Resources/startScreen.fxml"));
        Parent loginformroot = FXMLLoader.load(getClass().getResource("Resources/Home.fxml"));
        Scene loginform = new Scene(loginformroot);
        Scene startScreen = new Scene(startScreenroot,850,600);

        primaryStage.setTitle("Sorting Algorithms");
        primaryStage.setScene(startScreen);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
