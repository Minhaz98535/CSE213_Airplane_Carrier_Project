package sohan;

import NonUser.RepairRecord;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class MaintanceRecordController {

    @FXML
    private TableView<RepairRecord> maintenanceTable;

    @FXML
    private TableColumn<RepairRecord, String> recordIdColumn;

    @FXML
    private TableColumn<RepairRecord, String> aircraftIdColumn;

    @FXML
    private TableColumn<RepairRecord, String> dateColumn;

    @FXML
    private TableColumn<RepairRecord, String> typeColumn;

    @FXML
    private TableColumn<RepairRecord, String> statusColumn;

    @FXML
    private TextField searchField;

    private ObservableList<RepairRecord> repairRecords;
    private FilteredList<RepairRecord> filteredRecords;

    @FXML
    public void initialize() {

        // Connect TableColumns with Model attributes
        recordIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("recordId"));

        aircraftIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("aircraftId"));

        dateColumn.setCellValueFactory(
                new PropertyValueFactory<>("date"));

        typeColumn.setCellValueFactory(
                new PropertyValueFactory<>("type"));

        statusColumn.setCellValueFactory(
                new PropertyValueFactory<>("status"));

        // Sample records
        repairRecords = FXCollections.observableArrayList(

                new RepairRecord(
                        "R001", "252622",
                        "2026-11-20", "Engine Repair", "Completed"),

                new RepairRecord(
                        "R002", "252628",
                        "2026-11-22", "Wing Repair", "Pending"),

                new RepairRecord(
                        "R003", "252622",
                        "2026-11-25", "Fuel System", "Completed")
        );

        // Create FilteredList
        filteredRecords = new FilteredList<>(
                repairRecords, p -> true);

        maintenanceTable.setItems(filteredRecords);
    }

    @FXML
    public void searchButton(ActionEvent actionEvent) {

        String searchText = searchField.getText()
                .trim().toLowerCase();

        if (searchText.isEmpty()) {

            filteredRecords.setPredicate(record -> true);
            return;
        }

        filteredRecords.setPredicate(record ->

                record.getRecordId().toLowerCase()
                        .contains(searchText)

                        ||

                        record.getAircraftId().toLowerCase()
                                .contains(searchText)
        );
    }
}
