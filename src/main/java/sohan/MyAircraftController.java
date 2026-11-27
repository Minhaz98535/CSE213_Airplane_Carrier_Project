
package sohan;

import NonUser.Aircraft;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Label;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

public class MyAircraftController {

    @FXML
    private TableView<Aircraft> myaircrafttabileview;

    @FXML
    private TableColumn<Aircraft, String> aircraftidcol;

    @FXML
    private TableColumn<Aircraft, String> modelcol;

    @FXML
    private TableColumn<Aircraft, String> statuscol;

    @FXML
    private TableColumn<Aircraft, String> assignedflightcol;

    @FXML
    private GridPane grid;

    // Aircraft details labels
    private Label aircraftIdLabel;
    private Label modelLabel;
    private Label statusLabel;
    private Label assignedFlightLabel;

    // Aircraft data
    private ObservableList<Aircraft> aircraftList =
            FXCollections.observableArrayList();


    @FXML
    public void initialize() {

        // Configure TableView columns
        aircraftidcol.setCellValueFactory(
                new PropertyValueFactory<>("aircraftId")
        );

        modelcol.setCellValueFactory(
                new PropertyValueFactory<>("model")
        );

        statuscol.setCellValueFactory(
                new PropertyValueFactory<>("status")
        );

        assignedflightcol.setCellValueFactory(
                new PropertyValueFactory<>("assignedFlight")
        );

        // Configure GridPane details
        setupAircraftDetails();

        // Load aircraft data
        loadAircraftData();

        // Select aircraft and show details
        myaircrafttabileview.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {

                    if (newValue != null) {
                        showAircraftDetails(newValue);
                    }
                });
    }


    private void loadAircraftData() {

        aircraftList.setAll(

                new Aircraft(
                        "AC-101",
                        "Boeing 737",
                        "Ready",
                        "FL-101"
                ),

                new Aircraft(
                        "AC-102",
                        "Airbus A320",
                        "Maintenance",
                        "Not Assigned"
                ),

                new Aircraft(
                        "AC-103",
                        "Boeing 777",
                        "Ready",
                        "FL-103"
                )
        );

        myaircrafttabileview.setItems(aircraftList);
    }


    private void setupAircraftDetails() {

        aircraftIdLabel = new Label("Not selected");
        modelLabel = new Label("Not selected");
        statusLabel = new Label("Not selected");
        assignedFlightLabel = new Label("Not selected");

        grid.add(new Label("Aircraft ID:"), 0, 0);
        grid.add(aircraftIdLabel, 1, 0);

        grid.add(new Label("Model:"), 0, 1);
        grid.add(modelLabel, 1, 1);

        grid.add(new Label("Status:"), 0, 2);
        grid.add(statusLabel, 1, 2);

        grid.add(new Label("Assigned Flight:"), 0, 3);
        grid.add(assignedFlightLabel, 1, 3);
    }


    private void showAircraftDetails(Aircraft aircraft) {

        aircraftIdLabel.setText(aircraft.getAircraftId());

        modelLabel.setText(aircraft.getModel());

        statusLabel.setText(aircraft.getStatus());

        assignedFlightLabel.setText(
                aircraft.getAssignedFlight()
        );
    }

}
