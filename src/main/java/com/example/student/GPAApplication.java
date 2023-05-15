package com.example.student;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class GPAApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GPAApplication.class.getResource("GPA.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 564, 408);

        stage.setTitle("GPA");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) throws IOException {
        new GPAController();

        launch();

    }

}
