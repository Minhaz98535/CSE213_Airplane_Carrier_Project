package sohan;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

public class AircraftReadinessController {

    @FXML
    private ComboBox<String> aircraftIdComboBox;

    @FXML
    private TextArea remarksArea;

    @FXML
    private ComboBox<String> repairIdComboBox;

    @FXML
    private ComboBox<String> inspectionIdComboBox;

    @FXML
    private ComboBox<String> readinessStatusComboBox;

    @FXML
    private DatePicker verificationDatePicker;

    @FXML
    public void initialize() {
        aircraftIdComboBox.getItems().setAll("252622", "252628");

        repairIdComboBox.getItems().setAll("R001", "R002");

        inspectionIdComboBox.getItems().setAll("I001", "I002");

        readinessStatusComboBox.getItems().setAll(
                "Ready",
                "Not Ready",
                "Under Maintenance"
        );
    }

    @FXML
    public void clearButton(ActionEvent actionEvent) {
        aircraftIdComboBox.getSelectionModel().clearSelection();
        repairIdComboBox.getSelectionModel().clearSelection();
        inspectionIdComboBox.getSelectionModel().clearSelection();
        readinessStatusComboBox.getSelectionModel().clearSelection();

        verificationDatePicker.setValue(null);
        remarksArea.clear();
    }

    @FXML
    public void verifyAircraftButton(ActionEvent actionEvent) {

        String aircraftId = aircraftIdComboBox.getValue();
        String repairId = repairIdComboBox.getValue();
        String inspectionId = inspectionIdComboBox.getValue();
        String status = readinessStatusComboBox.getValue();

        String verificationDate = verificationDatePicker.getValue() == null
                ? ""
                : verificationDatePicker.getValue().toString();

        String remarks = remarksArea.getText().trim();

        if (aircraftId == null || repairId == null
                || inspectionId == null || status == null
                || verificationDate.isBlank()) {

            System.out.println("Please fill in all required fields.");
            return;
        }

        System.out.println("Aircraft ID: " + aircraftId);
        System.out.println("Repair ID: " + repairId);
        System.out.println("Inspection ID: " + inspectionId);
        System.out.println("Readiness Status: " + status);
        System.out.println("Verification Date: " + verificationDate);
        System.out.println("Remarks: " + remarks);
    }
}