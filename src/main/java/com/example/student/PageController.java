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

    public void changePage(Button Btu) throws Exception {
        Stage PrimaryStage = (Stage)Btu.getScene().getWindow();
        String Path = null;
        String title = null;


        System.out.println(Btu.getId());

        if(Btu.getId().equals("loginButton")){
            Path = "home.fxml";
            title = "Home";
        }else if(Btu.getId().equals("courseBackToHome")){
            Path = "home.fxml";
            title = "Home";
        }else if(Btu.getId().equals("gradeBackToHome")){
            Path="home.fxml";
            title = "Home";
        } else if (Btu.getId().equals("gradeGoToGPA")) {
            Path="GPA.fxml";
            title = "GPA";
        } else if (Btu.getId().equals("GPABackToGrade")) {
            Path="Grade.fxml";
            title = "Grade";
        } else if (Btu.getId().equals("GPABackToHome")) {
            Path="home.fxml";
            title = "Home";
        } else if (Btu.getId().equals("contributionBackToHome")) {
            Path="home.fxml";
            title = "Home";
        } else if (Btu.getId().equals("conGoToGrade")) {
            Path="Grade.fxml";
            title = "Grade";
        } else if (Btu.getId().equals("signUpButton")) {
            Path="signUp.fxml";
            title = "signUp";
        } else if (Btu.getId().equals("changePasswordButton")) {
            Path="login.fxml";
            title="login";
        } else if (Btu.getId().equals("registerButton")) {
            Path="login.fxml";
            title="login";
        } else if (Btu.getId().equals("registerLoginButton")) {
            Path="login.fxml";
            title="login";
        } else if (Btu.getId().equals("loginChangeButton")) {
            Path="changePassword.fxml";
            title="changePassword";
        } else if (Btu.getId().equals("changeToLog")) {
            Path="login.fxml";
            title="login";
        } else if (Btu.getId().equals("adminButton")) {
            Path="administrator.fxml";
            title="admin";
        }

        assert Path != null;
        FXMLLoader root = new FXMLLoader(Login.class.getResource(Path));
        Scene scene = new Scene(root.load(),640, 400);
        Controller controller=root.getController();
        controller.init();

        Stage stage = new Stage();
        stage.setResizable(false);

        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
        PrimaryStage.close();

    }
    public void changePage(ImageView imageView) throws Exception {
        Stage PrimaryStage = (Stage)imageView.getScene().getWindow();
        String Path = null;
        String title=null;


        System.out.println(imageView.getId());

        if(imageView.getId().equals("homeCourse")){
            Path = "course.fxml";
            title = "Course";
        } else if (imageView.getId().equals("homeGrade")) {
            Path = "Grade.fxml";
            title = "Grade";
        } else if (imageView.getId().equals("homeContribution")) {
            Path = "Contribution.fxml";
            title = "Contribution";
        } else if (imageView.getId().equals("GPABackToHomeNew")) {
            Path = "home.fxml";
            title = "home";
        }

        assert Path != null;
        FXMLLoader root = new FXMLLoader(Login.class.getResource(Path));
        Scene scene = new Scene(root.load(),640, 400);
        Controller controller=root.getController();
        controller.init();

        Stage stage = new Stage();
        stage.setResizable(false);

        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
        PrimaryStage.close();

    }
    public void changePage(Label label) throws Exception {
        Stage PrimaryStage = (Stage)label.getScene().getWindow();
        String Path = null;
        String title=null;


        System.out.println(label.getId());

        if(label.getId().equals("adminExit")){
            Path = "login.fxml";
            title = "login";
        }

        assert Path != null;
        FXMLLoader root = new FXMLLoader(Login.class.getResource(Path));
        Scene scene = new Scene(root.load(),640, 400);
        Controller controller=root.getController();
        controller.init();

        Stage stage = new Stage();
        stage.setResizable(false);

        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
        PrimaryStage.close();

    }

}
