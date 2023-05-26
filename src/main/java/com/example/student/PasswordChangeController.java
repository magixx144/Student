package com.example.student;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PasswordChangeController extends Controller{

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField oldPasswordField;

    @FXML
    private PasswordField newPasswordField;

    @FXML
    private Label warningLabel;

    @FXML
    private Button changePasswordButton;
    @FXML
    private Button changeToLog;

    File file = new File("");
    String path = file.getCanonicalPath()+"/Student/info/stuinfo.txt";

    public PasswordChangeController() throws IOException {
    }
    public void changeToLogOnAction() throws Exception {
        PageController pageController=new PageController();
        pageController.changePage(changeToLog);
    }
    @FXML
    public void init() {
        changePasswordButton.setOnAction(e -> changePassword());
    }

    private void changePassword() {
        String username = usernameField.getText();
        String oldPassword = oldPasswordField.getText();
        String newPassword = newPasswordField.getText();

        File usersFile = new File(path);
        List<String> newLines = new ArrayList<>();
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(usersFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4 && parts[2].equals(username) && parts[3].equals(oldPassword)) {
                    newLines.add(parts[0] + "," + parts[1] + "," + username + "," + newPassword);
                    found = true;
                } else {
                    newLines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (found) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(usersFile))) {
                for (String line : newLines) {
                    writer.write(line);
                    writer.newLine();
                }
                warningLabel.setText("Password changed successfully!");
                PageController pageController=new PageController();
                pageController.changePage(changePasswordButton);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            warningLabel.setText("Username or old password not found.");
        }
    }

    public void testOnMouseClicked(MouseEvent mouseEvent) {
    }


}



