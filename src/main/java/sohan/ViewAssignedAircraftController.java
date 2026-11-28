package sohan;

import NonUser.Aircraft;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewAssignedAircraftController {

    @FXML
    private Label messageLabel;

    @FXML
    private TableView<Aircraft> aircraftTable;

    @FXML
    private TableColumn<Aircraft, String> aircraftIdColumn;

    @FXML
    private TableColumn<Aircraft, String> modelColumn;

    @FXML
    private TableColumn<Aircraft, String> statusColumn;

    @FXML
    private TableColumn<Aircraft, String> flightColumn;

    @FXML
    private Label aircraftIdLabel;

    @FXML
    private Label aircraftModelLabel;

    @FXML
    private Label aircraftStatusLabel;

    @FXML
    private Label assignedFlightLabel;

    // Demo value: login/session theke actual pilot ID nite hobe
    private final String loggedInPilotId = "PILOT-001";

    private final ObservableList<Aircraft> allAircraft =
            FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // TableColumn-er property name model class-er field/getter-er shathe match korte hobe
        aircraftIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("aircraftId"));

        modelColumn.setCellValueFactory(
                new PropertyValueFactory<>("model"));

        statusColumn.setCellValueFactory(
                new PropertyValueFactory<>("status"));

        flightColumn.setCellValueFactory(
                new PropertyValueFactory<>("assignedFlight"));

        loadSampleData();
        showAssignedAircraft();

        aircraftTable.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldAircraft, selectedAircraft) -> {
                    if (selectedAircraft != null) {
                        showAircraftDetails(selectedAircraft);
                    }
                });
    }

    private void loadSampleData() {
        // Demo data only — pore database/service theke load korbe
        allAircraft.setAll(
                new Aircraft("AC-101", "Boeing 737", "Available",
                        "FL-201", "PILOT-001"),

                new Aircraft("AC-102", "Airbus A320", "In Flight",
                        "FL-202", "PILOT-002"),

                new Aircraft("AC-103", "Boeing 777", "Maintenance",
                        "N/A", "PILOT-001")
        );
    }

    private void showAssignedAircraft() {
        ObservableList<Aircraft> assignedAircraft =
                FXCollections.observableArrayList();

        for (Aircraft aircraft : allAircraft) {
            if (loggedInPilotId.equals(aircraft.getAssignedPilotId())) {
                assignedAircraft.add(aircraft);
            }
        }

        aircraftTable.setItems(assignedAircraft);

        if (assignedAircraft.isEmpty()) {
            messageLabel.setText("No aircraft is currently assigned.");
            clearAircraftDetails();
        } else {
            messageLabel.setText("Select an aircraft to view its information.");
        }
    }

    private void showAircraftDetails(Aircraft aircraft) {
        // Assignment validation
        if (!loggedInPilotId.equals(aircraft.getAssignedPilotId())) {
            messageLabel.setText("Error: This aircraft is not assigned to you.");
            clearAircraftDetails();
            return;
        }

        messageLabel.setText("Aircraft information displayed.");

        aircraftIdLabel.setText(aircraft.getAircraftId());
        aircraftModelLabel.setText(aircraft.getModel());
        aircraftStatusLabel.setText(aircraft.getStatus());
        assignedFlightLabel.setText(aircraft.getAssignedFlight());
    }

    private void clearAircraftDetails() {
        aircraftIdLabel.setText("-");
        aircraftModelLabel.setText("-");
        aircraftStatusLabel.setText("-");
        assignedFlightLabel.setText("-");
    }

    @FXML
    private void handleRefresh() {
        // Demo data refresh; database integration hole ekhane update korte hobe
        showAssignedAircraft();
        aircraftTable.getSelectionModel().clearSelection();
        clearAircraftDetails();
    }
}