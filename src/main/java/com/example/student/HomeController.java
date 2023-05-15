package com.example.student;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author Magixx
 * @Date 2023 04 17 21 19
 **/
public class HomeController extends Controller {
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
    private ImageView homeContribution;
    @FXML
    private ImageView homeRecharge;
    @FXML
    private Label homeExit;
    @FXML
    private ImageView profileImage;
    public Course c=new Course();
    public CourseTxtObj txt=new CourseTxtObj();
    File file = new File("");
    String path = file.getCanonicalPath();
    //相对路径，勿改动

    public String paths=path+"/Student/info/temp.txt";
    public String pathsCourse=path+"/Student/info/courseinfo.txt";

    public HomeController() throws IOException {
    }

    public void init(){
        setHomeFirstname();
        setHomeLastname();
        setHomeUsername();
    }
    public void homeExitOnMouseClicked(MouseEvent e){
        Stage stage = (Stage) homeExit.getScene().getWindow();
        stage.close();
    }

//    public void profileImageOnMouseMoved(MouseEvent e)throws Exception{
//
//        setHomeFirstname();
//        setHomeLastname();
//        setHomeUsername();
//
//    }
    public LoginTxtObject initialize()throws Exception{
        List userinfo=User.readTxts(paths);
        Object[] o=userinfo.toArray();
        LoginTxtObject user=(LoginTxtObject) o[0];
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
    public void HomeContributionOnMouseClicked(MouseEvent e) throws Exception {
        PageController pageController=new PageController();
        pageController.changePage(homeContribution);
    }

}
