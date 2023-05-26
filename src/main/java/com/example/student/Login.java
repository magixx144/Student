package com.example.student;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.*;

/**
 * @Author Magixx
 * @Date 2023 04 17 21 19
 **/

public class Login extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 570, 470);
        Controller controller=fxmlLoader.getController();
        controller.init();


        stage.setResizable(false);
        stage.setTitle("StudentManagement");
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch();
    }
}


