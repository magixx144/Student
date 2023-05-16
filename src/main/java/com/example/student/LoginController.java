package com.example.student;

/**
 * @Author Magixx
 * @Date 2023 04 17 21 19
 **/
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


public class LoginController extends Controller {
    @FXML
    private Label warningLabel;
    @FXML
    private Button loginButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private ImageView test;
    File file = new File("");
    String path = file.getCanonicalPath();

    public LoginController() throws IOException {
    }
    //相对路径，勿改动


    public void init() {
        System.out.println("Initial.");
    }

    public void testOnMouseClicked(MouseEvent e){
        Stage stage = (Stage) test.getScene().getWindow();
        stage.close();
    }
    public void cancelButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void loginButtonOnAction(ActionEvent e) {
        if (usernameTextField.getText().isBlank() || passwordPasswordField.getText().isBlank()) {
            warningLabel.setText("The username and password cannot be empty.");
        } else {
            validateLogin();
        }

    }

    public void validateLogin() {
        PageController pageController=new PageController();
        String paths=path+"/Student/info/stuinfo.txt";
        try{

            List userinfo=User.readTxts(paths);
            Object[] o=userinfo.toArray();
            for(int i=0;i< userinfo.size();i++){
                LoginTxtObject user=(LoginTxtObject) o[i];
                System.out.println(user);
                if(user.getUsername().equals(usernameTextField.getText())
                &&user.getPassword().equals(passwordPasswordField.getText())){
                    warningLabel.setText("Keep it real,baby!");
                    writeFile(user);
                    pageController.changePage(loginButton);
                    break;
                }else{
                    warningLabel.setText("Check your username and password!");
                }

            }passwordPasswordField.setText("");

        }catch(Exception e){
            System.out.println("io wrong");
        }
    }
    public void writeFile(LoginTxtObject stu) throws IOException {
        try {
            String filename=path+"/Student/info/temp.txt";
            FileOutputStream fout=new FileOutputStream(filename);
            OutputStreamWriter osw=new OutputStreamWriter(fout, "UTF-8");
            BufferedWriter  bw=new BufferedWriter(osw);
            bw.write(stu.getFirstname()+","+stu.getLastname()+","+stu.getUsername()+","+stu.getPassword());
            bw.close();
            osw.close();
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}


