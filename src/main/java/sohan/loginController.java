package sohan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class loginController {

    @FXML
    private Label LoginErrorMassage;

    @FXML
    private PasswordField EnterPasswordField;

    @FXML
    private TextField enteridTextField;

    @FXML
    private ComboBox<String> UserTyperComboBox;

    @FXML
    public void initialize() {

        // Add user types to ComboBox
        UserTyperComboBox.getItems().addAll(
                "Pilot",
                "Maintenance Engineer"
        );

        // Default selection
        UserTyperComboBox.setValue("Pilot");

        // Hide error message initially
        LoginErrorMassage.setText("");
    }

    @FXML
    public void LogInButton(ActionEvent actionEvent) {

        String id = enteridTextField.getText();
        String password = EnterPasswordField.getText();

        // Check if ID or Password is empty
        if (id == null || id.trim().isEmpty()
                || password == null || password.trim().isEmpty()) {

            LoginErrorMassage.setText(
                    "Please enter ID and Password."
            );

        } else {

            LoginErrorMassage.setText("");

            
        }
    }
}