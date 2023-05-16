package com.example.student;
/*
Copyright (C) [2023] [Kehao Lyu]
This code is owned and solely developed by [Kehao Lyu]. Any unauthorized copying, usage, modification, or distribution of this software is strictly prohibited without the written permission of [Kehao Lyu].
@Kuangxiaokao
*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ContributionApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ContributionApplication.class.getResource("Contribution.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 564, 408);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}