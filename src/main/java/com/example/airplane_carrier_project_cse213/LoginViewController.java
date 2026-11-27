package com.example.airplane_carrier_project_cse213;

import User.User;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;

public class LoginViewController
{
    @javafx.fxml.FXML
    private TextField userIdTF;
    @javafx.fxml.FXML
    private ComboBox <String> userRoleCB;
    @javafx.fxml.FXML
    private PasswordField userPasswordPF;

    ArrayList<User> userDB;

    public ArrayList<User> readUsers(String binFile) throws IOException {
        ArrayList <User> users = new ArrayList<User>();
        File f;
        FileInputStream fis;
        ObjectInputStream ois;
        f = new File(binFile);
        if (!f.exists() || f.length() == 0) {
            return users;
        }
        fis = new FileInputStream(f);
        ois = new ObjectInputStream(fis);
        User u;
        try{
            while(true){
                u = (User) ois.readObject();
                users.add(u);
            }
        }catch (EOFException | ClassNotFoundException e){
        }

        ois.close();
        return users;
    }


    public void initialize() {
        userRoleCB.getItems().addAll("Aircraft Carrier Captain", "Air Operation Officer", "Pilot", "Aircraft Maintenance Engineer", "Flight Deck officer", "Maintenance Logistics Officer", "Carrier navigation officer", "Medical Officer");

        try {
            userDB = readUsers("users.bin");
        } catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void userLoginBTN(ActionEvent actionEvent) throws IOException {
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
        if(userId.length()!=6 || !userId.matches("[0-9]{6}")){
            a.setContentText("Enter a valid 6 digit User ID!");
            a.showAndWait();
            return;
        }
        if(userPassword.isEmpty()){
            a.setContentText("Invalid Password");
            a.showAndWait();
            return;
        }
        for(User u : userDB){
            if(u.getRole().equals(userRole) && u.getUserId() == (Integer.parseInt(userId)) && u.getPassword().equals(userPassword)){
                isValid = true;
                break;
            }
        }

        Alert s = new Alert(Alert.AlertType.INFORMATION);
        if(isValid){
            s.setContentText("Login Successful!!!");
            s.showAndWait();
            if(userRole.equals("Aircraft Carrier Captain")){
                Helper.sceneSwitcher(actionEvent,"/com/example/airplane_carrier_project_cse213/swapnil/carrierCaptainDashboard-view.fxml");
            }
            else if(userRole.equals("Air Operation Officer")){
                Helper.sceneSwitcher(actionEvent,"airOperationsOfficerDashboard-view.fxml");
            }
            else if(userRole.equals("Pilot")){

            }
            else if(userRole.equals("Aircraft Maintenance Engineer")){

            }
            else if(userRole.equals("Flight Deck officer")){

            }
            else if(userRole.equals("Maintenance Logistics Officer")){

            }
            else if(userRole.equals("Carrier navigation officer")){

            }
            else if(userRole.equals("Medical Officer")){

            }
        }
        else{
            s.setAlertType(Alert.AlertType.ERROR);
            s.setContentText("Invalid User Id Or Password!!!");
            s.showAndWait();
        }

    }

    @javafx.fxml.FXML
    public void userRegisterBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent,"register-view.fxml");
    }
}