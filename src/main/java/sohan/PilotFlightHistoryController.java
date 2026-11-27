package sohan;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PilotFlightHistoryController {

    @FXML
    private TableColumn<?, ?> flightidCol;

    @FXML
    private TableColumn<?, ?> arrivalCol;

    @FXML
    private TableColumn<?, ?> aircraftIdCol;

    @FXML
    private TableColumn<?, ?> statusCol;

    @FXML
    private Label noflighthistorymassage;

    @FXML
    private TableColumn<?, ?> destinationCol;

    @FXML
    private DatePicker fromdatepicker;

    @FXML
    private TableView<?> pilotflighthistorytabileview;

    @FXML
    private DatePicker todatepicker;

    @FXML
    private TableColumn<?, ?> departureCol;

    @FXML
    public void initialize() {
        noflighthistorymassage.setVisible(false);
    }

    @FXML
    public void applyfilterButton(ActionEvent actionEvent) {

        if (fromdatepicker.getValue() == null
                || todatepicker.getValue() == null) {

            noflighthistorymassage.setText(
                    "Please select both dates."
            );
            noflighthistorymassage.setVisible(true);
            return;
        }

        if (fromdatepicker.getValue().isAfter(todatepicker.getValue())) {
            noflighthistorymassage.setText(
                    "From date cannot be after To date."
            );
            noflighthistorymassage.setVisible(true);
            return;
        }

        noflighthistorymassage.setVisible(false);

        System.out.println("From: " + fromdatepicker.getValue());
        System.out.println("To: " + todatepicker.getValue());

        // Ekhane selected date range onujayi flight history filter korbe.
    }
}