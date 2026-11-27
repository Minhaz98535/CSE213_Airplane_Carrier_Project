package sohan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

public class AircraftInspectionController {

    @FXML
    private DatePicker Inspectiondarepicker;

    @FXML
    private ComboBox<String> aircraftidComboBox;

    @FXML
    private ComboBox<String> fuelsystemComboBox;

    @FXML
    private TextArea inspectionRemarksID;

    @FXML
    private ComboBox<String> wingsComboBox;

    @FXML
    private ComboBox<String> enginecomboBox;

    @FXML
    private ComboBox<String> landinggearComboBox;

    @FXML
    private ComboBox<String> saftyComboBox;

    @FXML
    public void initialize() {
        aircraftidComboBox.getItems().setAll("252622", "252628");

        fuelsystemComboBox.getItems().setAll("Pass", "Fail");
        wingsComboBox.getItems().setAll("Pass", "Fail");
        enginecomboBox.getItems().setAll("Pass", "Fail");
        landinggearComboBox.getItems().setAll("Pass", "Fail");
        saftyComboBox.getItems().setAll("Pass", "Fail");
    }

    @FXML
    public void submitInspectionButton(ActionEvent actionEvent) {
        String aircraftId = aircraftidComboBox.getValue();

        String inspectionDate = Inspectiondarepicker.getValue() == null
                ? ""
                : Inspectiondarepicker.getValue().toString();

        String fuelSystem = fuelsystemComboBox.getValue();
        String wings = wingsComboBox.getValue();
        String engine = enginecomboBox.getValue();
        String landingGear = landinggearComboBox.getValue();
        String safety = saftyComboBox.getValue();

        String remarks = inspectionRemarksID.getText().trim();

        if (aircraftId == null || inspectionDate.isBlank()
                || fuelSystem == null || wings == null
                || engine == null || landingGear == null
                || safety == null) {

            System.out.println("Please complete all inspection fields.");
            return;
        }

        System.out.println("Aircraft ID: " + aircraftId);
        System.out.println("Inspection Date: " + inspectionDate);
        System.out.println("Fuel System: " + fuelSystem);
        System.out.println("Wings: " + wings);
        System.out.println("Engine: " + engine);
        System.out.println("Landing Gear: " + landingGear);
        System.out.println("Safety: " + safety);
        System.out.println("Remarks: " + remarks);
    }
}