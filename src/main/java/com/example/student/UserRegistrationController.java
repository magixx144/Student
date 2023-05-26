package com.example.student;

import java.io.*;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.util.ResourceBundle;

public class UserRegistrationController extends Controller implements Initializable {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button registerButton;
    @FXML
    private Label warningLabel;
    @FXML
    private Button registerLoginButton;


    File file = new File("");
    String path = file.getCanonicalPath()+"/Student/info/stuinfo.txt";
    String pathGPA=file.getCanonicalPath()+"/Student/info/GPA.txt";
    String pathCons=file.getCanonicalPath()+"/Student/info/Contribution.txt";
    String pathCourse=file.getCanonicalPath()+"/Student/info/courseinfo.txt";

    public UserRegistrationController() throws IOException {
    }
    public void loginButtonOnAction() throws Exception {
        PageController pageController=new PageController();
        pageController.changePage(registerLoginButton);
    }


    private void register() throws IOException {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String username = usernameTextField.getText();
        String password = passwordField.getText();
        BufferedReader reader = new BufferedReader(new FileReader(path));
//        BufferedReader readerGPA=new BufferedReader(new FileReader(pathGPA));
//        BufferedReader readerCons=new BufferedReader(new FileReader(pathCons));
//        BufferedReader readerCourse=new BufferedReader(new FileReader(pathCourse));

        boolean flag=true;
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            System.out.println(parts[2]);
            if(parts[2].equals(username)){
                warningLabel.setText("User name exists!");
                firstNameField.setText("");
                lastNameField.setText("");
                usernameTextField.setText("");
                passwordField.setText("");
                flag=false;
                break;
            }
        }

        try {
            if(firstName.isBlank()||lastName.isBlank()||username.isBlank()||password.isBlank()){
                warningLabel.setText("Please enter all the information!");
            }else {
                if(flag) {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(path, true)); // true for append mode
                    writer.write(firstName + "," + lastName + "," + username + "," + password);
                    writer.write("\r\n"); // add new line
                    writer.close();

                    BufferedWriter writerGPA = new BufferedWriter(new FileWriter(pathGPA, true));
                    BufferedWriter writerCons = new BufferedWriter(new FileWriter(pathCons, true));
                    BufferedWriter writerCourse = new BufferedWriter(new FileWriter(pathCourse,true));
                    writerGPA.write(username+";\n");
                    writerCons.write(username+";\n");
                    writerCourse.write(username+",false,false,false,false,false,false\n");
                    writerGPA.close();writerCons.close();writerCourse.close();

                    warningLabel.setText("Registration successful!"); // Show success message
                    PageController pageController = new PageController();
                    pageController.changePage(registerButton);
                }else{
                    warningLabel.setText("User exists!");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            warningLabel.setText("Registration failed!"); // Show error message
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handleRegisterButtonAction() throws IOException {
        register();
    }

    @FXML
    public void init() {
        registerButton.setOnAction(e -> {
            try {
                handleRegisterButtonAction();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public void testOnMouseClicked(MouseEvent mouseEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        registerButton.setOnAction(e -> {
            try {
                handleRegisterButtonAction();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

}
