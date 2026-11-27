package sohan;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MaintenanceStatusController {

    @FXML
    private TextField previousStatusField;

    @FXML
    private ComboBox<String> aircraftIdComboBox;

    @FXML
    private ComboBox<String> newStatusComboBox;

    @FXML
    private TextArea remarksArea;

    @FXML
    public void initialize() {

        aircraftIdComboBox.getItems().setAll(
                "252622",
                "252628"
        );

        newStatusComboBox.getItems().setAll(
                "Scheduled",
                "In Progress",
                "Completed",
                "Pending"
        );
    }

    @FXML
    public void UpdateStatusButton(ActionEvent actionEvent) {

        String aircraftId = aircraftIdComboBox.getValue();
        String previousStatus = previousStatusField.getText().trim();
        String newStatus = newStatusComboBox.getValue();
        String remarks = remarksArea.getText().trim();

        if (aircraftId == null || previousStatus.isBlank()
                || newStatus == null) {

            System.out.println("Please fill in all required fields.");
            return;
        }

        System.out.println("Aircraft ID: " + aircraftId);
        System.out.println("Previous Status: " + previousStatus);
        System.out.println("New Status: " + newStatus);
        System.out.println("Remarks: " + remarks);
    }

    @FXML
    public void ClearButton(ActionEvent actionEvent) {

        previousStatusField.clear();
        aircraftIdComboBox.getSelectionModel().clearSelection();
        newStatusComboBox.getSelectionModel().clearSelection();
        remarksArea.clear();
    }
}
