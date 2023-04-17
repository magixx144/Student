package com.example.student;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class GradeController {
    @FXML
    private Button CaculateText;
    @FXML
    private Label Text1;
    @FXML
    private Button GetaverageText;
    @FXML
    private Label Text2;
    @FXML
    private Label GetTrendsText;




    @FXML
    protected void onCaculateButtonClicked(){
        Text1.setText("Your BUPT algorithm GPA is:3.33\n "+
                "Your easy algorithm GPA is:4.44\n");
    }
    @FXML
    protected void onGetaverageTextClicked() {
        Text2.setText("Year 1:100\n" +
                "Year 2:90\n" +
                "Year 3:80\n" +
                "Year 4:123\n");
    }
}