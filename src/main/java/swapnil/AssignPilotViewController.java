package swapnil;

import NonUser.Aircraft;
import NonUser.Flight;
import NonUser.FlightSchedule;
import User.Pilot;
import com.example.airplane_carrier_project_cse213.Helper;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.time.LocalDate;

public class AssignPilotViewController
{
    @javafx.fxml.FXML
    private TableView <Pilot> PilotTableView;
    @javafx.fxml.FXML
    private TableColumn <Aircraft, Integer> aircraftIdCol;
    @javafx.fxml.FXML
    private ComboBox <Integer> selectPilotIdCB;
    @javafx.fxml.FXML
    private TableView <Aircraft> AircraftTableView;
    @javafx.fxml.FXML
    private TableColumn <FlightSchedule, Integer> flightIdCol;
    @javafx.fxml.FXML
    private TableColumn <FlightSchedule, LocalDate> flightDateCol;
    @javafx.fxml.FXML
    private TableColumn <Pilot,Integer> pilotIdCol;
    @javafx.fxml.FXML
    private TableColumn <Pilot, String> signNameCol;
    @javafx.fxml.FXML
    private ComboBox <Integer> selectAircraftIdCB;
    @javafx.fxml.FXML
    private TableColumn <Aircraft, String> assignPilotSignNameCol;
    @javafx.fxml.FXML
    private TableColumn <Pilot, String> pilotAvailabilityCol;
    @javafx.fxml.FXML
    private TableColumn <FlightSchedule, LocalDate> FlightTimeCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void assignPilotToAircraftBTN(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backToDashboardBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/airOperationsOfficerDashboard-view.fxml");
    }
}