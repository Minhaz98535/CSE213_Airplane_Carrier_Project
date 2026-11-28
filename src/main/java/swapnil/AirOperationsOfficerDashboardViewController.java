package swapnil;

import NonUser.Aircraft;
import NonUser.FlightSchedule;
import NonUser.Mission;
import com.example.airplane_carrier_project_cse213.Helper;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class AirOperationsOfficerDashboardViewController
{
    @javafx.fxml.FXML
    private TableView <FlightSchedule> FlightSchdeuleTableView;
    @javafx.fxml.FXML
    private TableColumn <FlightSchedule, String> aircraftNameCol;
    @javafx.fxml.FXML
    private TableColumn <FlightSchedule, String> flightIdCol;
    @javafx.fxml.FXML
    private Label showSchedeuleFlightsCntLabel;
    @javafx.fxml.FXML
    private Label showReadyAircraftCountLabel;
    @javafx.fxml.FXML
    private TableColumn <FlightSchedule, String> flightStatusCol;

    public ArrayList<FlightSchedule> readFlightSchedules(String binFile) throws IOException {
        ArrayList <FlightSchedule> alerts = new ArrayList<FlightSchedule>();
        File f;
        FileInputStream fis;
        ObjectInputStream ois;
        f = new File(binFile);
        if (!f.exists() || f.length() == 0) {
            return alerts;
        }
        fis = new FileInputStream(f);
        ois = new ObjectInputStream(fis);
        FlightSchedule m;
        try{
            while(true){
                m = (FlightSchedule) ois.readObject();
                alerts.add(m);
            }
        }catch (EOFException | ClassNotFoundException e){
        }

        ois.close();
        return alerts;
    }

    public ArrayList<Aircraft> readAircrafts(String binFile) throws IOException {
        ArrayList <Aircraft> aircrafts = new ArrayList<Aircraft>();
        File f;
        FileInputStream fis;
        ObjectInputStream ois;
        f = new File(binFile);
        if (!f.exists() || f.length() == 0) {
            return aircrafts;
        }
        fis = new FileInputStream(f);
        ois = new ObjectInputStream(fis);
        Aircraft m;
        try{
            while(true){
                m = (Aircraft) ois.readObject();
                aircrafts.add(m);
            }
        }catch (EOFException | ClassNotFoundException e){
        }

        ois.close();
        return aircrafts;
    }

    @javafx.fxml.FXML
    public void initialize() throws IOException {
        flightIdCol.setCellValueFactory(new PropertyValueFactory<>("flightId"));
        aircraftNameCol.setCellValueFactory(new PropertyValueFactory<>("aircraftName"));
        flightStatusCol.setCellValueFactory(new PropertyValueFactory<>("flightStatus"));

        ArrayList <FlightSchedule> flights = readFlightSchedules("flightSchedules.bin");
        ArrayList <Aircraft> aircrafts = readAircrafts("aircrafts.bin");
        int flightCnt = 0;
        for(FlightSchedule f : flights){
            if(!f.getFlightStatus().equals("Cancelled") || !f.getFlightStatus().equals("Complete")){
                flightCnt++;
            }
        }

        int aircraftCnt = 0;
        for(Aircraft m : aircrafts){
            if(m.getAircraftStatus().equals("Ready")){
                aircraftCnt++;
            }
        }

        showSchedeuleFlightsCntLabel.setText("" + flightCnt);
        showReadyAircraftCountLabel.setText("" + aircraftCnt);
        for(FlightSchedule f : flights){
            if(f.getFlightDate().equals(LocalDate.now())){
                FlightSchdeuleTableView.getItems().add(f);
            }
        }

    }

    @javafx.fxml.FXML
    public void updateFlightStatusPageBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/updateFlightStatus-view.fxml");
    }

    @javafx.fxml.FXML
    public void viewDailyOperationPageBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/dailyFlightOperation-view.fxml");
    }

    @javafx.fxml.FXML
    public void assignPilotPageBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/assignPilot-view.fxml");
    }

    @javafx.fxml.FXML
    public void dashboardPageBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/airOperationsOfficerDashboard-view.fxml");
    }

    @javafx.fxml.FXML
    public void missionMonitorPageBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/missionMonitor-view.fxml");
    }

    @javafx.fxml.FXML
    public void createEmergencyALertPageBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/emergencyAlerts-view.fxml");
    }

    @javafx.fxml.FXML
    public void createFlightSchedulePageBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/createFlightSchedule-view.fxml");
    }

    @javafx.fxml.FXML
    public void updateFlightSchdeulePageBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/updateFlightSchedule-view.fxml");
    }

    @javafx.fxml.FXML
    public void assignAircraftPageBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/assignAircraft-view.fxml");
    }

    @javafx.fxml.FXML
    public void userLogOutBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "login-view.fxml");
    }
}