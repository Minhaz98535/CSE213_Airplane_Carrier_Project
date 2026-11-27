package sohan;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SubmitFlightReportController {

    @FXML
    private Label destinationmassage;

    @FXML
    private TextField arriveltextfield;

    @FXML
    private ComboBox<String> completedflightComboBox;

    @FXML
    private Label flightidmassage;

    @FXML
    private Label aircraftidmassage;

    @FXML
    private Label submitflightreportfxid;

    @FXML
    private TextArea flightObservstionstextArea;

    @FXML
    private Label pleasecompleteallinfomassage;

    @FXML
    private TextArea addtionalRemarkstextarea;

    @FXML
    private TextField deparaturetextfield;

    @FXML
    public void initialize() {

        completedflightComboBox.getItems().setAll(
                "FL-101",
                "FL-102",
                "FL-103"
        );

        pleasecompleteallinfomassage.setVisible(false);
    }

    @FXML
    public void submitreportButton(ActionEvent actionEvent) {

        String flightId = completedflightComboBox.getValue();

        String departureTime = deparaturetextfield
                .getText().trim();

        String arrivalTime = arriveltextfield
                .getText().trim();

        String observations = flightObservstionstextArea
                .getText().trim();

        String additionalRemarks = addtionalRemarkstextarea
                .getText().trim();

        if (flightId == null || departureTime.isBlank()
                || arrivalTime.isBlank() || observations.isBlank()) {

            pleasecompleteallinfomassage.setText(
                    "Please complete all required fields."
            );

            pleasecompleteallinfomassage.setVisible(true);
            return;
        }

        pleasecompleteallinfomassage.setText(
                "Flight report submitted successfully!"
        );

        pleasecompleteallinfomassage.setVisible(true);

        System.out.println("Flight ID: " + flightId);
        System.out.println("Departure Time: " + departureTime);
        System.out.println("Arrival Time: " + arrivalTime);
        System.out.println("Observations: " + observations);
        System.out.println("Additional Remarks: " + additionalRemarks);
    }
}