package sohan;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MaintenanceScheduleController {

    @FXML
    private TextArea maintanceRemarksTextArea;

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    private ComboBox<String> aircraftidComboBox;

    @FXML
    private DatePicker selectdatepicker;

    @FXML
    private TextField Timetextfield;

    @FXML
    public void initialize() {

        statusComboBox.getItems().setAll(
                "Scheduled",
                "In Progress",
                "Completed",
                "Pending"
        );

        aircraftidComboBox.getItems().setAll(
                "252622",
                "252628"
        );
    }

    @FXML
    public void savescheduleButton(ActionEvent actionEvent) {

        String aircraftId = aircraftidComboBox.getValue();
        String status = statusComboBox.getValue();

        String scheduleDate = selectdatepicker.getValue() == null
                ? ""
                : selectdatepicker.getValue().toString();

        String time = Timetextfield.getText().trim();

        String remarks = maintanceRemarksTextArea.getText().trim();

        if (aircraftId == null || status == null
                || scheduleDate.isBlank() || time.isBlank()) {

            System.out.println("Please fill in all required fields.");
            return;
        }

        System.out.println("Aircraft ID: " + aircraftId);
        System.out.println("Status: " + status);
        System.out.println("Schedule Date: " + scheduleDate);
        System.out.println("Time: " + time);
        System.out.println("Remarks: " + remarks);
    }
}