package com.example.student;

import java.io.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @Author jakkson
 * @Date 2023 05 23 18:13
 **/

    public class PasswordChanger extends Application {

        @Override
        public void start(Stage primaryStage) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("changePassword.fxml"));
                primaryStage.setTitle("Change Password");
                primaryStage.setScene(new Scene(root, 570, 470));
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            launch(args);
        }
    }

