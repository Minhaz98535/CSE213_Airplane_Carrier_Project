package sohan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

public class AircraftrepairController {

    @FXML
    private TextArea observationsArea;

    @FXML
    private TextArea requiredPartsArea;

    @FXML
    private ComboBox<String> aircraftIdComboBox;

    @FXML
    private DatePicker repairDatePicker;

    @FXML
    private ComboBox<String> issueIdComboBox;

    @FXML
    private TextArea repairDetailsArea;

    @FXML
    public void initialize() {
        aircraftIdComboBox.getItems().setAll("252622", "252628");
        issueIdComboBox.getItems().setAll("A5363", "G62822");
    }

    @FXML
    public void clearButton(ActionEvent actionEvent) {
        aircraftIdComboBox.getSelectionModel().clearSelection();
        issueIdComboBox.getSelectionModel().clearSelection();
        repairDatePicker.setValue(null);

        observationsArea.clear();
        requiredPartsArea.clear();
        repairDetailsArea.clear();
    }

    @FXML
    public void saverepairButton(ActionEvent actionEvent) {
        String aircraftId = aircraftIdComboBox.getValue();
        String issueId = issueIdComboBox.getValue();
        String repairDate = repairDatePicker.getValue() == null
                ? ""
                : repairDatePicker.getValue().toString();

        String observations = observationsArea.getText().trim();
        String requiredParts = requiredPartsArea.getText().trim();
        String repairDetails = repairDetailsArea.getText().trim();

        if (aircraftId == null || issueId == null
                || repairDate.isBlank()
                || repairDetails.isBlank()) {
            System.out.println("Please fill in the required fields.");
            return;
        }

        // Ekhane RepairRecord object create kore save korbe.
        System.out.println("Aircraft: " + aircraftId);
        System.out.println("Issue: " + issueId);
        System.out.println("Repair date: " + repairDate);
        System.out.println("Observations: " + observations);
        System.out.println("Required parts: " + requiredParts);
        System.out.println("Repair details: " + repairDetails);
    }
}