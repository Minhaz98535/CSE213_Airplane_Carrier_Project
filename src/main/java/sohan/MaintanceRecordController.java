//package sohan;
//
//import javafx.fxml.FXML;
//import javafx.event.ActionEvent;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TextField;
//
//public class MaintanceRecordController {
//
//    @FXML
//    private TableView<MaintenanceRecord> maintenanceTable;
//
//    @FXML
//    private TableColumn<MaintenanceRecord, String> aircraftIdColumn;
//
//    @FXML
//    private TextField searchField;
//
//    @FXML
//    private TableColumn<MaintenanceRecord, String> statusColumn;
//
//    @FXML
//    private TableColumn<MaintenanceRecord, String> recordIdColumn;
//
//    @FXML
//    private TableColumn<MaintenanceRecord, String> dateColumn;
//
//    @FXML
//    private TableColumn<MaintenanceRecord, String> typeColumn;
//
//    @FXML
//    public void initialize() {
//
//    }
//
//    @FXML
//    public void searchButton(ActionEvent actionEvent) {
//
//        String searchText = searchField.getText().trim();
//
//        if (searchText.isEmpty()) {
//            System.out.println("Please enter a Record ID or Aircraft ID.");
//            return;
//        }
//
//        System.out.println("Searching for: " + searchText);
//
//        // Ekhane maintenance records filter korbe.
//    }
//}