package com.example.student;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class GradeController extends Controller {
    @FXML
    private URL location;
    @FXML
    private TableView<Course> gradeTable;
    @FXML
    private TableColumn<Course, String> courseColumn;
    @FXML
    private TableColumn<Course, Double> gpaColumn;
    @FXML
    private TableColumn<Course, Integer> gradeColumn;
    @FXML
    private TableColumn<Course, Integer> numColumn;
    @FXML
    private TableColumn<Course, Integer> semesterColumn;

    @FXML
    private Button gradeBackToHome;
    @FXML
    private Button gradeGoToGPA;
    File file = new File("");
    String path = file.getCanonicalPath();

    public GradeController() throws IOException {
    }
    //相对路径，勿改动

    public void init() {
        try {
            GradeReader reader = new GradeReader(path+"/Student/info/Grade.txt");

            // Convert GradeReader to Course list
            List<Course> courses = Course.fromGradeReader(reader);

            // Create ObservableList from course list
            ObservableList<Course> data = FXCollections.observableArrayList(courses);

            // Set the data for the table
            gradeTable.setItems(data);

            // Set cell value factories for each column
            courseColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
            gpaColumn.setCellValueFactory(new PropertyValueFactory<>("courseGPA"));
            gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
            numColumn.setCellValueFactory(new PropertyValueFactory<>("courseNumber"));
            semesterColumn.setCellValueFactory(new PropertyValueFactory<>("semester"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void gradeBackToHomeOnAction(ActionEvent e) throws Exception {
        PageController pageController=new PageController();
        pageController.changePage(gradeBackToHome);
    }
    public void gradeGoToGPAOnAction(ActionEvent e) throws Exception {
        PageController pageController=new PageController();
        pageController.changePage(gradeGoToGPA);
    }
}
