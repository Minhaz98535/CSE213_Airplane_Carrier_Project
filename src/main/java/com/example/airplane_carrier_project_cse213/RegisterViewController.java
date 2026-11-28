package com.example.airplane_carrier_project_cse213;

import User.User;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.*;
import java.util.ArrayList;
import User.UserManager;

public class RegisterViewController
{
    @javafx.fxml.FXML
    private TextField fullNameTF;
    @javafx.fxml.FXML
    private ComboBox <String> roleCB;
    @javafx.fxml.FXML
    private TextField emailTF;
    @javafx.fxml.FXML
    private ComboBox <String> genderCB;
    @javafx.fxml.FXML
    private DatePicker dateOfBirthDP;
    @javafx.fxml.FXML
    private PasswordField passwordTF;
    @javafx.fxml.FXML
    private TextField mobileTF;

    @javafx.fxml.FXML
    public void initialize() {
        roleCB.getItems().addAll("Aircraft Carrier Captain", "Air Operation Officer", "Pilot", "Aircraft Maintenance Engineer", "Flight Deck officer", "Maintenance Logistics Officer", "Carrier navigation officer", "Medical Officer");
        genderCB.getItems().addAll("Male", "Female");
    }

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

    public void writeToBin(String binFile, Object u) throws IOException {
        File f;
        FileOutputStream fos;
        ObjectOutputStream oos;
        f = new File(binFile);
        if(f.exists()){
            fos = new FileOutputStream(f, true);
            oos = new AppendableObjectOutputStream(fos);
        }
        else{
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
        }
        oos.writeObject(u);
    }

    @javafx.fxml.FXML
    public void userRegisterBTN(ActionEvent actionEvent) throws IOException {
        ArrayList<User> users =  readUsers("users.bin");
        UserManager userManager = new UserManager();
        int uid = userManager.generateNewUserId(roleCB.getValue(), users);
        User u = new User(
                fullNameTF.getText(),
                emailTF.getText(),
                passwordTF.getText(),
                mobileTF.getText(),
                genderCB.getValue(),
                roleCB.getValue(),
                dateOfBirthDP.getValue(),
                uid
        );
        writeToBin("users.bin", u);

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("You have successfully register!");
        a.setContentText("Your UserID is " + uid);
        a.showAndWait();
        Helper.sceneSwitcher(actionEvent,"login-view.fxml");
    }
}