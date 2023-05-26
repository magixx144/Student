package com.example.student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminstratorController extends Controller{

    @FXML
    private TextField CourseCreditTextfield;

    @FXML
    private TextField CourseGradefield;

    @FXML
    private TextField CourseNumTextfield;

    @FXML
    private TextField CourseSemesterfield;

    @FXML
    private TextField CourseTextfield;

    @FXML
    private TextField UsernameTextfield;

    @FXML
    private TextField UsernameTextfield1;

    @FXML
    private TextField Year1ContributionRateTextfield;

    @FXML
    private TextField Year1ContributionTextfield;

    @FXML
    private TextField Year2ContributionRateTextfield;

    @FXML
    private TextField Year2ContributionTextfield;

    @FXML
    private TextField Year3ContributionRateTextfield;

    @FXML
    private TextField Year3ContributionTextfield;

    @FXML
    private TextField Year4ContributionRateTextfield;

    @FXML
    private TextField Year4ContributionTextfield;



    @FXML
    private Button okButton1;

    @FXML
    private Button okButton2;
    @FXML
    private Label adminExit;


    private StringBuilder ContributionData = new StringBuilder();
    File file = new File("");
    String conFile = file.getCanonicalPath()+"/Student/info/Contribution.txt";
    String GPAFile = file.getCanonicalPath()+"/Student/info/GPA.txt";

    public AdminstratorController() throws IOException {
    }

    @Override
    public void init() throws Exception {

    }

    @FXML
    void OnContributionchangebuttonClicked(ActionEvent event) throws FileNotFoundException {
        boolean isText=false;
        boolean isBlank=false;

        String username = UsernameTextfield1.getText();
        String year1ContributionRate = Year1ContributionRateTextfield.getText();
        String year1Contribution = Year1ContributionTextfield.getText();
        String year2ContributionRate = Year2ContributionRateTextfield.getText();
        String year2Contribution = Year2ContributionTextfield.getText();
        String year3ContributionRate = Year3ContributionRateTextfield.getText();
        String year3Contribution = Year3ContributionTextfield.getText();
        String year4ContributionRate = Year4ContributionRateTextfield.getText();
        String year4Contribution = Year4ContributionTextfield.getText();
        if(year1Contribution.matches("^[A-Za-z]+$")&&year2Contribution.matches("^[A-Za-z]+$")&&
                year3Contribution.matches("^[A-Za-z]+$")&&year4Contribution.matches("^[A-Za-z]+$")&&
                year1ContributionRate.matches("^[A-Za-z]+$")&&year2ContributionRate.matches("^[A-Za-z]+$")&&
                year3ContributionRate.matches("^[A-Za-z]+$")&&year4ContributionRate.matches("^[A-Za-z]+$")){
            isText=true;
        }
        if(year1Contribution.isBlank()||year2Contribution.isBlank()||year3Contribution.isBlank()
                ||year4Contribution.isBlank()||year1ContributionRate.isBlank()||year2ContributionRate.isBlank()
                ||year3ContributionRate.isBlank()||year4ContributionRate.isBlank()){
            isBlank=true;
        }


        // 构造数据行
        if(isText&&(!isBlank)) {
            String dataRow =
                    "1,1," + year1Contribution + "," + year1ContributionRate + "/" +
                            "2,2," + year2Contribution + "," + year2ContributionRate + "/" +
                            "3,3," + year3Contribution + "," + year3ContributionRate + "/" +
                            "4,4," + year4Contribution + "," + year4ContributionRate + "/";

            File file = new File(conFile);
            //boolean fileExists = file.exists();
            boolean isNew=isNewUser(username,conFile);

            try (FileWriter writer = new FileWriter(file, true)) {
                if (isNew) {
                    showAlert("No such user");
                }else{
                    appendToEnd(conFile, dataRow, username);
                    showAlert("Data has been saved to Contribution.txt file");
                }

            } catch (IOException e) {
                showAlert("Error while saving data: " + e.getMessage());
            }
        } else if(!isText){
            showAlert("Contribution and rate must be a word without number!!!");
        } else if (isBlank) {
            showAlert("You must have missed something?");
        }

        // 清空输入框
        clearContributionFields();
    }




    @FXML
    void homeExitOnMouseClicked(MouseEvent event) throws Exception {
        PageController pageController=new PageController();
        pageController.changePage(adminExit);
    }

    //private StringBuilder gpaData = new StringBuilder();

    private void clearFields() {
        CourseNumTextfield.clear();
        CourseTextfield.clear();
        CourseGradefield.clear();
        CourseCreditTextfield.clear();
        CourseSemesterfield.clear();
    }

    private void  clearContributionFields(){
        Year1ContributionRateTextfield.clear();
        Year2ContributionRateTextfield.clear();
        Year3ContributionRateTextfield.clear();
        Year4ContributionRateTextfield.clear();
        Year1ContributionTextfield.clear();
        Year2ContributionTextfield.clear();
        Year3ContributionTextfield.clear();
        Year4ContributionTextfield.clear();
    }


    @FXML
    void OnGradeChangeButtonClicked(ActionEvent event) throws FileNotFoundException {
        // 获取用户输入的信息
        boolean legalInput=false;
        boolean isEmpty=false;
        boolean isNum=true;

        String a = CourseNumTextfield.getText();
        String b=CourseSemesterfield.getText();
        String c=CourseGradefield.getText();
        String d=CourseCreditTextfield.getText();

        if (a.matches("^[1-9]\\d*$")&&b.matches("^[1-9]\\d*$")
                &&c.matches("^[1-9]\\d*$")&&d.matches("^(\\-|\\+)?\\d+(\\.\\d+)?$")){
            System.out.println("true");
            isNum=true;
        }else{
            System.out.println("not true");
            isNum=false;
        }
        if(isNum) {
            System.out.println("yes");
            String username = UsernameTextfield.getText();
            int courseNum = Integer.parseInt(CourseNumTextfield.getText());
            String course = CourseTextfield.getText();
            int semester = Integer.parseInt(CourseSemesterfield.getText());
            int courseGrade = Integer.parseInt(CourseGradefield.getText());
            double courseCredit = Double.parseDouble(CourseCreditTextfield.getText());
            if (courseNum > 20 || semester > 4 || courseGrade > 100 || courseCredit > 5
                    || courseNum < 0 || semester < 0 || courseGrade < 0 || courseCredit < 0) {
                legalInput = true;
                showAlert("Illegal input. Check again.");
            }
            if (UsernameTextfield.getText().isBlank() || CourseTextfield.getText().isBlank()
                    || CourseSemesterfield.getText().isBlank() || CourseGradefield.getText().isBlank()
                    || CourseCreditTextfield.getText().isBlank()) {
                isEmpty = true;
                showAlert("Please enter all the information");
            }

            // 构造数据行
            if (!legalInput && !isEmpty) {
                StringBuilder gpaData = new StringBuilder();
                String dataRow = courseNum + "," + course + "," + semester + "," + courseGrade + "," + courseCredit;
                // 如果已有其他用户数据，并且是新用户，则另起一行
                boolean isNew=isNewUser(username,GPAFile);
                gpaData.append(dataRow).append("/");
                if (isNew) {
                    //gpaData.append("\n");
                    showAlert("No such USER,check again!");
                }else {
                    try (FileWriter writer = new FileWriter(GPAFile, true)) {
                        appendToEnd(GPAFile, gpaData.toString(), username);
                        showAlert("Data has been saved to GPA.txt file");
                    } catch (IOException e) {
                        showAlert("Error while saving data: " + e.getMessage());
                    }
                }
                // 清空输入框
                clearFields();
            }
        }
        else{
            clearFields();
            showAlert("Please enter a NUMBER!!!");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Tips");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public boolean isNewUser(String username,String filename) throws FileNotFoundException {
        //int lineNum = 0;
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        boolean flag=true;
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] data = line.split(";");
            //lineNum++;
            if(data[0].equals(username)){
                flag=false;
            }
        }
        return flag;
    }

    private void appendToEnd(String filename,String newRecord,String username) throws IOException {
        File iFile=new File(filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(iFile)));
        StringBuffer outBuf = new StringBuffer();
        String line;
        while ((line =br.readLine()) != null) {

            System.out.println("测试");
            String cprName;//用于比对


            cprName=line.split(";")[0];
            if(cprName.equals(username)){
                line = line + newRecord;//直接修改该行
            }

            outBuf.append(line+"\n");//
        }
        br.close();
        PrintWriter pw = new PrintWriter(iFile);// 建立一个输出流，把东西写入文件
        pw.write(outBuf.toString());

        pw.close();

    }

}
