package swapnil;

import NonUser.EmergencyAlert;
import NonUser.FlightSchedule;
import NonUser.IncidentReport;
import NonUser.Mission;
import com.example.airplane_carrier_project_cse213.Helper;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class flightScheduleApprovalViewController
{
    @javafx.fxml.FXML
    private TableColumn <Mission, String> missionNameCol;
    @javafx.fxml.FXML
    private CheckBox isApprovedCHK;
    @javafx.fxml.FXML
    private TableColumn <FlightSchedule, Integer> flightIdCol;
    @javafx.fxml.FXML
    private TableColumn <FlightSchedule, LocalDate> flightDateCol;
    @javafx.fxml.FXML
    private TableView <FlightSchedule> FlightScheduleTableView;
    @javafx.fxml.FXML
    private ComboBox <Integer> selectFlightIdCB;
    @javafx.fxml.FXML
    private TableColumn <FlightSchedule, Boolean> isApprovedCol;
    @javafx.fxml.FXML
    private TableColumn <FlightSchedule, String> flightTimeCol;

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

    public void rewriteFlightSchedules(String binFile, ArrayList<FlightSchedule> alerts) throws IOException {
        FileOutputStream fos = new FileOutputStream(binFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (FlightSchedule m : alerts) {
            oos.writeObject(m);
        }
        oos.close();
    }

    @javafx.fxml.FXML
    public void initialize() throws IOException {
        flightIdCol.setCellValueFactory(new PropertyValueFactory<>("flightId"));
        flightDateCol.setCellValueFactory(new PropertyValueFactory<>("flightDate"));
        flightTimeCol.setCellValueFactory(new PropertyValueFactory<>("flightTime"));
        missionNameCol.setCellValueFactory(new PropertyValueFactory<>("missionName"));
        isApprovedCol.setCellValueFactory(new PropertyValueFactory<>("isApproved"));

        ArrayList <FlightSchedule> flights = readFlightSchedules("flightSchedules.bin");
        FlightScheduleTableView.getItems().addAll(flights);
        for(FlightSchedule f : flights){
            selectFlightIdCB.getItems().add(f.getFlightId());
        }

    }

    @javafx.fxml.FXML
    public void actionRejectBTN(ActionEvent actionEvent) throws IOException {
        ArrayList <FlightSchedule> flights = readFlightSchedules("flightSchedules.bin");
        for(FlightSchedule f : flights){
            if(f.getFlightId()==selectFlightIdCB.getValue()){
                f.setApproved(false);
                f.setPending(false);
                break;
            }
        }
        rewriteFlightSchedules("flightSchedules.bin", flights);
        flights = readFlightSchedules("flightSchedules.bin");

        FlightScheduleTableView.getItems().clear();
        FlightScheduleTableView.getItems().addAll(flights);
    }

    @javafx.fxml.FXML
    public void backToDashboardBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/carrierCaptainDashboard-view.fxml");
    }

    @javafx.fxml.FXML
    public void flterFlightScheduleByApprovedCheckBoxBTN(ActionEvent actionEvent) throws IOException {
        ArrayList <FlightSchedule> flights = readFlightSchedules("flightSchedules.bin");
        FlightScheduleTableView.getItems().clear();
        for(FlightSchedule f : flights){
            if(isApprovedCHK.isSelected() && f.getPending()){
                FlightScheduleTableView.getItems().add(f);
            }
        }
        selectFlightIdCB.getItems().clear();
        for(FlightSchedule f : FlightScheduleTableView.getItems()){
            selectFlightIdCB.getItems().add(f.getFlightId());
        }
    }

    @javafx.fxml.FXML
    public void actionApproveBTN(ActionEvent actionEvent) throws IOException {
        ArrayList <FlightSchedule> flights = readFlightSchedules("flightSchedules.bin");
        for(FlightSchedule f : flights){
            if(f.getFlightId()==selectFlightIdCB.getValue()){
                f.setApproved(true);
                f.setPending(false);
                break;
            }
        }
        rewriteFlightSchedules("flightSchedules.bin", flights);
        flights = readFlightSchedules("flightSchedules.bin");

        FlightScheduleTableView.getItems().clear();
        FlightScheduleTableView.getItems().addAll(flights);
    }
}