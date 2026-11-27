package sohan;

import NonUser.FlightClearance;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class requestClearanceController {

    @FXML
    private TableColumn<FlightClearance,Integer> flightidCol;

    @FXML
    private TableColumn<FlightClearance,Integer> aircraftidCol;

    @FXML
    private TableColumn<FlightClearance,String> missionCol;

    @FXML
    private Label showaicraftnotreadymassage;

    @FXML
    private ComboBox<String> flightComboBox;

    @FXML
    private TableColumn<?, ?> statusCol;

    @FXML
    private Label aircraftreadinessmassage;

    @FXML
    private TableView<?> flightdetailsTabileview;

    @FXML
    private Label cheaklistmassage;

    @FXML
    private TableColumn<?, ?> timeCol;

    @FXML
    public void initialize() {

        flightComboBox.getItems().setAll(
                "FL-101",
                "FL-102",
                "FL-103"
        );

        showaicraftnotreadymassage.setVisible(false);
        aircraftreadinessmassage.setVisible(false);
        cheaklistmassage.setVisible(false);
    }

    @FXML
    public void requestclearanceButton(ActionEvent actionEvent) {

        String flightId = flightComboBox.getValue();

        if (flightId == null) {
            cheaklistmassage.setText("Please select a flight.");
            cheaklistmassage.setVisible(true);
            return;
        }

        System.out.println("Selected Flight: " + flightId);

        // Ekhane aircraft readiness ebong checklist verify korbe.

        System.out.println("Clearance request submitted.");
    }
}