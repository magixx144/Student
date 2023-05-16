package com.example.student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;


public class GPAController extends Controller {
    private final GPAReader gradeReader;

    @FXML
    private Button calculateButton;

    @FXML
    private Button getAverageButton;

    @FXML
    private Button getTrendGradesButton;

    @FXML
    private Label text1;

    @FXML
    private Label text2;
    @FXML
    private Label name;

    @FXML
    private NumberAxis Grades;

    @FXML
    private CategoryAxis SemesterYear;
    @FXML
    private Button GPABackToGrade;
    @FXML
    private ImageView GPABackToHomeNew;
    @FXML
    private Button GPABackToHome;
    File file = new File("");
    String path = file.getCanonicalPath();
    //相对路径，勿改动



    public GPAController() throws IOException {
        // 指定读取文件的路径
        String filePath = path+"/Student/info/GPA.txt";
        this.gradeReader = new GPAReader(filePath);
    }

    @Override
    public void init() {
        name.setText(gradeReader.getUsername()+"\nWelcome!");
    }
    public void GPABackToGradeOnAction(ActionEvent e) throws Exception {
        PageController pageController=new PageController();
        pageController.changePage(GPABackToGrade);
    }
    public void GPABackToHomeOnAction(ActionEvent e) throws Exception {
        PageController pageController=new PageController();
        pageController.changePage(GPABackToHome);
    }
    public void GPABackToHomeNewOnAction(MouseEvent e) throws Exception {
        PageController pageController=new PageController();
        pageController.changePage(GPABackToHomeNew);
    }

    @FXML
    void onTrendGradesButtonClicked(ActionEvent event) {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(1);
        xAxis.setUpperBound(4);
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(60);
        yAxis.setUpperBound(100);
        yAxis.setTickUnit(4);

        xAxis.setLabel("Year");
        yAxis.setLabel("Weighted Average Grade");

        for (int i = 1; i <= 4; i++) {
            double grade = gradeReader.calculateWeightedAverage(i);
            int gradeInt = (int) grade;
            series.getData().add(new XYChart.Data<>(i, gradeInt));
        }

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.getData().add(series);
        Scene scene = new Scene(lineChart, 564, 408);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onGetAverageButtonClicked(ActionEvent event) {
        String result = "";
        for (int i = 1; i < 5; i++) {
            DecimalFormat df = new DecimalFormat("#.##");
            result += "At Year " + i + ", Your Weighted Average Score is " + df.format(gradeReader.calculateWeightedAverage(i)) +
                    ", Your Easy Average Score is " + df.format(gradeReader.calculateSimpleAverage(i)) + "\n";
        }
        text2.setText(result);

    }

    @FXML
    public void onCalculateButtonClicked(ActionEvent event) {
        String result = "";
        for (int i = 1; i < 5; i++) {
            DecimalFormat df = new DecimalFormat("#.##");
            result += "At Year " + i + ", Your Weighted Average GPA is " + df.format(gradeReader.calculateWeightedGPA(i)) +
                    ", Your Easy Average GPA is " + df.format(gradeReader.calculateSimpleGPA(i)) + "\n";
        }
        text1.setText(result);
    }
}

