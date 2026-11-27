package swapnil;

import NonUser.Aircraft;
import NonUser.Mission;
import com.example.airplane_carrier_project_cse213.Helper;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import java.io.*;
import java.util.ArrayList;

public class CarrierCaptainDashboardViewController
{
    @javafx.fxml.FXML
    private Label activeMissionCountLabel;
    @javafx.fxml.FXML
    private Label readyAircraftCountLabel;
    @javafx.fxml.FXML
    private Label unreadMessageCountLabel;
    @javafx.fxml.FXML
    private Label pendingFlightCountLabel;



    public ArrayList<Mission> readMissions(String binFile) throws IOException {
        ArrayList <Mission> missions = new ArrayList<Mission>();
        File f;
        FileInputStream fis;
        ObjectInputStream ois;
        f = new File(binFile);
        if (!f.exists() || f.length() == 0) {
            return missions;
        }
        fis = new FileInputStream(f);
        ois = new ObjectInputStream(fis);
        Mission m;
        try{
            while(true){
                m = (Mission) ois.readObject();
                missions.add(m);
            }
        }catch (EOFException | ClassNotFoundException e){
        }

        ois.close();
        return missions;
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

        ArrayList <Mission> missions = readMissions("missions.bin");
        ArrayList <Aircraft> aircrafts = readAircrafts("aircrafts.bin");
        int missionCnt = 0;
        for(Mission m : missions){
            if(m.getMissionStatus().equals("In Progress")){
                missionCnt++;
            }
        }

        int aircraftCnt = 0;
        for(Aircraft m : aircrafts){
            if(m.getAircraftStatus().equals("Ready")){
                aircraftCnt++;
            }
        }

        activeMissionCountLabel.setText("" + missionCnt);
        readyAircraftCountLabel.setText("" + aircraftCnt);
        pendingFlightCountLabel.setText("");
        unreadMessageCountLabel.setText("3 Unread Message");

    }

    @javafx.fxml.FXML
    public void dashboardPageBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/carrierCaptainDashboard-view.fxml");
    }

    @javafx.fxml.FXML
    public void incidentReportsPageBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/incidentReports-view.fxml");
    }

    @javafx.fxml.FXML
    public void setMissionPriorityPageBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/setMissionPriority-view.fxml");
    }

    @javafx.fxml.FXML
    public void authorizeEmergencyPageBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/emergencyAuthorization-view.fxml");
    }

    @javafx.fxml.FXML
    public void flightSchedulePageBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/flightScheduleApproval-view.fxml");
    }

    @javafx.fxml.FXML
    public void aircraftStatusPageBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/aircraftAvailabilityStatus-view.fxml");
    }

    @javafx.fxml.FXML
    public void inboxPageBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/messageInbox-view.fxml");
    }

    @javafx.fxml.FXML
    public void missionManagementPageBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/missionManagement-view.fxml");
    }

    @javafx.fxml.FXML
    public void userLogOutBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "login-view.fxml");
    }
}