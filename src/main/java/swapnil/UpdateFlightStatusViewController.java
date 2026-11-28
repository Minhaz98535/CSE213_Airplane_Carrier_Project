package swapnil;

import NonUser.FlightSchedule;
import com.example.airplane_carrier_project_cse213.Helper;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.*;
import java.util.ArrayList;

public class UpdateFlightStatusViewController
{
    @javafx.fxml.FXML
    private ComboBox <String> newFlightStatusCB;
    @javafx.fxml.FXML
    private Label showCurrentFlightStatusLabel;
    @javafx.fxml.FXML
    private ComboBox <Integer> selectFlightIdCB;
    @javafx.fxml.FXML
    private Label showAircraftIdLabel;
    @javafx.fxml.FXML
    private TextArea remarksUpdateTA;

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
        newFlightStatusCB.getItems().addAll("Scheduled", "Pending", "Ready", "Cancelled", "Complete");
        ArrayList <FlightSchedule> flights = readFlightSchedules("flightSchedules.bin");
        for(FlightSchedule f : flights){
            selectFlightIdCB.getItems().add(f.getFlightId());
        }
    }

    @javafx.fxml.FXML
    public void backToDashboardBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/airOperationsOfficerDashboard-view.fxml");
    }

    @javafx.fxml.FXML
    public void updateFLightStatusBTN(ActionEvent actionEvent) throws IOException {
        ArrayList <FlightSchedule> flights = readFlightSchedules("flightSchedules.bin");
        for(FlightSchedule f : flights){
            if(f.getFlightId()==selectFlightIdCB.getValue()){
                f.setFlightStatus(newFlightStatusCB.getValue());
                f.setPending(true);
                f.setApproved(false);
                break;
            }
        }
        rewriteFlightSchedules("flightSchedules.bin", flights);
        showAircraftIdLabel.setText("");
        showCurrentFlightStatusLabel.setText("");
    }

    @javafx.fxml.FXML
    public void showDetailsInfoOfSelectFlightIdBTN(ActionEvent actionEvent) throws IOException {
        ArrayList <FlightSchedule> flights = readFlightSchedules("flightSchedules.bin");
        for(FlightSchedule f : flights){
            if(f.getFlightId()==selectFlightIdCB.getValue()){
                showAircraftIdLabel.setText(""+ f.getFlightId());
                showCurrentFlightStatusLabel.setText(f.getFlightStatus());
                break;
            }
        }
    }
}