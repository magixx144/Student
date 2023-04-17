package com.example.student;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

/**
 * @Author Magixx
 * @Date 2023 04 17 19 09
 **/
public class PageController {
    public void changePage(Button Btu) throws IOException {
        Stage PrimaryStage = (Stage)Btu.getScene().getWindow();
        String Path = null;
        String title = null;


        System.out.println(Btu.getId());

        if(Btu.getId().equals("loginButton")){
            Path = "home.fxml";
            title = "Home";
        }

        assert Path != null;
        FXMLLoader root = new FXMLLoader(Login.class.getResource(Path));
        Scene scene = new Scene(root.load(),640, 400);

        Stage stage = new Stage();
        stage.setResizable(false);

        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
        PrimaryStage.close();

    }
    public void changePage(ImageView imageView) throws IOException {
        Stage PrimaryStage = (Stage)imageView.getScene().getWindow();
        String Path = null;
        String title=null;


        System.out.println(imageView.getId());

        if(imageView.getId().equals("homeCourse")){
            Path = "course.fxml";
            title = "Course";
        } else if (imageView.getId().equals("homeGrade")) {
            Path = "grade.fxml";
            title = "Grade";
        }

        assert Path != null;
        FXMLLoader root = new FXMLLoader(Login.class.getResource(Path));
        Scene scene = new Scene(root.load(),640, 400);

        Stage stage = new Stage();
        stage.setResizable(false);

        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
        PrimaryStage.close();

    }

}
