package com.example.airplane_carrier_project_cse213;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.io.IOException;

public class RegisterViewController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void userRegisterBTN(ActionEvent actionEvent) throws IOException {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("You have succesfully register user id is 26101. now login");
        a.showAndWait();
        Helper.sceneSwitcher(actionEvent,"login-view.fxml");
    }
}