package com.example.student;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ContributionController extends Controller {

    @FXML
    private TableView<Contribution> contributionTable;

    @FXML
    private TableColumn<Contribution, Integer> numColumn;

    @FXML
    private TableColumn<Contribution, String> contributionColumn;

    @FXML
    private TableColumn<Contribution, Integer> semesterColumn;

    @FXML
    private TableColumn<Contribution, String> detailColumn;
    @FXML
    private Button conGoToGrade;

    @FXML
    private Button checkButton;
    @FXML
    private Button contributionBackToHome;

    private ContributionReader contributionReader;
    File file = new File("");
    String path = file.getCanonicalPath();

    public ContributionController() throws IOException {
    }
    public void ContributionBackToHomeOnAction(ActionEvent e) throws Exception {
        PageController pageController=new PageController();
        pageController.changePage(contributionBackToHome);
    }
    public void ContributionBackToGradeOnAction(ActionEvent e) throws Exception {
        PageController pageController=new PageController();
        pageController.changePage(conGoToGrade);
    }

    @FXML
    public void checkButtonOnAction(ActionEvent s) throws Exception {
        init();
    }

    @Override
    public void init() throws Exception {
        numColumn.setCellValueFactory(cellData -> cellData.getValue().contributionNumberProperty().asObject());
        contributionColumn.setCellValueFactory(cellData -> cellData.getValue().contributionProperty());
        semesterColumn.setCellValueFactory(cellData -> cellData.getValue().semesterProperty().asObject());
        detailColumn.setCellValueFactory(cellData -> cellData.getValue().detailProperty());

        checkButton.setOnAction(event -> {
            try {
                contributionReader = new ContributionReader(path+"/Student/info/Contribution.txt");
                ArrayList<Contribution> contributions = Contribution.fromContributionReader(contributionReader);
                ObservableList<Contribution> contributionData = FXCollections.observableArrayList(contributions);
                contributionTable.setItems(contributionData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}
