package com.example.student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;

/**
 * @Author Magixx
 * @Date 2023 04 17 18 12
 **/
public class CourseController extends Controller {
    @FXML
    private TextArea c1;
    @FXML
    private TextArea c2;
    @FXML
    private TextArea c3;
    @FXML
    private TextArea c4;
    @FXML
    private TextArea c5;
    @FXML
    private TextArea c6;
    @FXML
    private CheckBox optional;
    @FXML
    private CheckBox compulsory;
    @FXML
    private Button courseBackToHome;
    public Grade grade=new Grade();
    File file = new File("");
    String path = file.getCanonicalPath();
    //相对路径，勿改动
    public String filePath=path+"/Student/info/courseinfo.txt";

    public CourseController() throws IOException {
    }


    public void init() throws Exception {
        CourseTxtObj course=grade.readCourse(filePath);
        if(course.getInteractiveMediaDesign().equals("true")){
            c1.setText("Interactive\n" +
                    "Media \n" +
                    "Design");
        }else{
            c1.setText("Null");
        }
        if(course.getTelecommunicationSystem().equals("true")){
            c2.setText("Telecom-\n" +
                    "munication\n" +
                    "System");
        }else{
            c2.setText("Null");
        }
        if(course.getInternetProtocol().equals("true")){
            c3.setText("Internet\n" +
                    "Protocol");
        }else{
            c3.setText("Null");
        }
        if(course.getInternetProtocol().equals("true")){
            c3.setText("Internet\n" +
                    "Protocol");
        }else{
            c3.setText("Null");
        }
        if(course.getTravelTheWorldTogether().equals("true")){
            c4.setText("Travel the \n" +
                    "world\n" +
                    "together");
        }else{
            c4.setText("Null");
        }
        if(course.getImageAndVideoProcessing().equals("true")){
            c5.setText("Image\n" +
                    "and video\n" +
                    "Processing");
        }else{
            c5.setText("Null");
        }
        if(course.getCareerPlaning().equals("true")){
            c6.setText("Career\n" +
                    "Planning");
        }else{
            c6.setText("Null");
        }
    }

    public void courseBackToHomeOnAction(ActionEvent e) throws Exception{
        PageController pageController=new PageController();
        pageController.changePage(courseBackToHome);
    }


}
