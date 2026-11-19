package com.example.airplane_carrier_project_cse213;

import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class LoginViewController
{
    @javafx.fxml.FXML
    private TextField userIdTF;
    @javafx.fxml.FXML
    private ComboBox <String> userRoleCB;
    @javafx.fxml.FXML
    private PasswordField userPasswordPF;

    ArrayList <Login> userDB;

    public void initialize() {
        userDB = new ArrayList<Login>();
        Login u1 = new Login("Carrier Captain", 2530, "nil123");
        Login u2 = new Login("Carrier Captain", 2540, "test123");
        userDB.add(u1);
        userDB.add(u2);
        userRoleCB.getItems().addAll("Carrier Captain", "Air Operation Officer", "Pilot", "Aircraft Maintenance Engineer", "Flight Deck officer", "Maintenance Logistics Officer", "Carrier navigation officer", "Medical Officer");
    }

    @javafx.fxml.FXML
    public void userLoginBTN() {
        String userRole = userRoleCB.getValue();
        String userId = (userIdTF.getText()).trim();
        String userPassword = userPasswordPF.getText().trim();
        boolean isValid = false;

        Alert a = new Alert(Alert.AlertType.ERROR);

        if(userRole==null){
            a.setContentText("Select Your Role!");
            a.showAndWait();
            return;
        }
        if(userId.length()!=4 || !userId.matches("[0-9]{4}")){
            a.setContentText("Enter a valid 4 digit User ID!");
            a.showAndWait();
            return;
        }
        if(userPassword.isEmpty()){
            a.setContentText("Invalid Password");
            a.showAndWait();
            return;
        }
        for(Login u : userDB){
            if(u.getUserRole().equals(userRole) && u.getUserId().equals(Integer.parseInt(userId)) && u.getPassword().equals(userPassword)){
                isValid = true;
                break;
            }
        }

        Alert s = new Alert(Alert.AlertType.INFORMATION);
        if(isValid){
            s.setContentText("Login Successful!!!");
            s.showAndWait();
        }
        else{
            s.setAlertType(Alert.AlertType.ERROR);
            s.setContentText("Invalid User Id Or Password!!!");
            s.showAndWait();
        }

    }
}