package com.example.student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

/**
 * @Author Magixx
 * @Date 2023 04 17 18 12
 **/
public class CourseController {
    @FXML
    private Label courseLabel1;
    @FXML
    private Label courseLabel2;
    @FXML
    private Label courseLabel3;
    @FXML
    private Label courseLabel4;
    @FXML
    private Label courseLabel5;
    @FXML
    private Label courseLabel6;
    @FXML
    private CheckBox all;
    @FXML
    private CheckBox optional;
    @FXML
    private CheckBox compulsory;

    public void allOnAction(ActionEvent e){
        if(all.isSelected()){
            courseLabel1.setText("1");
            courseLabel2.setText("1");
            courseLabel3.setText("1");
            courseLabel4.setText("1");
            courseLabel5.setText("1");
            courseLabel6.setText("1");
            optional.setSelected(false);
            compulsory.setSelected(false);
        }else{
            courseLabel1.setText("");
            courseLabel2.setText("");
            courseLabel3.setText("");
            courseLabel4.setText("");
            courseLabel5.setText("");
            courseLabel6.setText("");
        }
    }
    public void optionalOnAction(ActionEvent e) {
        if (optional.isSelected()) {
            courseLabel1.setText("1");
            courseLabel2.setText("1");
            courseLabel3.setText("1");
            courseLabel4.setText("");
            courseLabel5.setText("");
            courseLabel6.setText("");
            all.setSelected(false);
            compulsory.setSelected(false);
        }else{
            courseLabel1.setText("");
            courseLabel2.setText("");
            courseLabel3.setText("");
            courseLabel4.setText("");
            courseLabel5.setText("");
            courseLabel6.setText("");
        }
    }
    public void compulsoryOnAction(ActionEvent e) {
        if (compulsory.isSelected()) {
            courseLabel1.setText("");
            courseLabel2.setText("");
            courseLabel3.setText("");
            courseLabel4.setText("1");
            courseLabel5.setText("1");
            courseLabel6.setText("1");
            all.setSelected(false);
            optional.setSelected(false);
        }else{
            courseLabel1.setText("");
            courseLabel2.setText("");
            courseLabel3.setText("");
            courseLabel4.setText("");
            courseLabel5.setText("");
            courseLabel6.setText("");
        }
    }


}
