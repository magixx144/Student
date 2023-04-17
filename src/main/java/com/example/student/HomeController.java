package com.example.student;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Magixx
 * @Date 2023 04 17 21 19
 **/
public class HomeController {
    @FXML
    private Label homeFirstname;
    @FXML
    private Label homeLastname;
    @FXML
    private Label homeUsername;
    @FXML
    private ImageView homeCourse;
    @FXML
    private ImageView homeGrade;
    @FXML
    private ImageView homeMail;
    @FXML
    private ImageView homeRecharge;
    @FXML
    private Label homeExit;
    @FXML
    private ImageView profileImage;

    public static String paths="D:\\work\\SoftwareEngineering\\Student\\Student\\info\\temp.txt";
    public void homeExitOnMouseClicked(MouseEvent e){
        Stage stage = (Stage) homeExit.getScene().getWindow();
        stage.close();
    }

    public void profileImageOnMouseMoved(MouseEvent e){
        setHomeFirstname();
        setHomeLastname();
        setHomeUsername();
    }
    public TxtObject initialize()throws Exception{
        List userinfo=User.readTxts(paths);
        Object[] o=userinfo.toArray();
        TxtObject user=(TxtObject) o[0];
        return user;
    }

    public void setHomeFirstname(){
        try {
            homeFirstname.setText(initialize().getFirstname());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void setHomeLastname(){
        try {
            homeLastname.setText(initialize().getLastname());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void setHomeUsername(){
        try {
            homeUsername.setText(initialize().getUsername());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void homeCourseOnMouseClicked(MouseEvent e) throws Exception{
        PageController pageController=new PageController();
        pageController.changePage(homeCourse);
    }
    public void homeGradeOnMouseClicked(MouseEvent e) throws Exception{
        PageController pageController=new PageController();
        pageController.changePage(homeGrade);
    }

}
