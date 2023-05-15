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
    private TableView<Grade> gradeTable;
    @FXML
    private TableColumn<Grade, String> courseColumn;
    @FXML
    private TableColumn<Grade, Double> gpaColumn;
    @FXML
    private TableColumn<Grade, Integer> gradeColumn;
    @FXML
    private TableColumn<Grade, Integer> numColumn;
    @FXML
    private TableColumn<Grade, Integer> semesterColumn;

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
            //GradeReader reader = new GradeReader(path+"/Student/info/Grade.txt");
            GPAReader reader = new GPAReader(path+"/Student/info/GPA.txt");

            // Convert GradeReader to Course list
            List<Grade> course = Grade.fromGradeReader(reader);

            // Create ObservableList from course list
            ObservableList<Grade> data = FXCollections.observableArrayList(course);

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
        } catch (IOException e) {
            throw new RuntimeException(e);
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
