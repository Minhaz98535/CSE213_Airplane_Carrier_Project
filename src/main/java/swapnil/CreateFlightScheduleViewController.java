package swapnil;

import NonUser.Flight;
import NonUser.FlightSchedule;
import NonUser.Mission;
import NonUser.WeatherInfo;
import com.example.airplane_carrier_project_cse213.AppendableObjectOutputStream;
import com.example.airplane_carrier_project_cse213.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class CreateFlightScheduleViewController
{
    @FXML
    private TextArea showOperationalRemarksTA;
    @FXML
    private ComboBox <Integer> selectMissionIdCB;
    @FXML
    private DatePicker flightDateDP;
    @FXML
    private Label showWeatherConditionLabel;
    @FXML
    private TextField launchTImeTF;

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

    public ArrayList<WeatherInfo> readWeatherInfo(String binFile) throws IOException {
        ArrayList <WeatherInfo> weathers = new ArrayList<WeatherInfo>();
        File f;
        FileInputStream fis;
        ObjectInputStream ois;
        f = new File(binFile);
        if (!f.exists() || f.length() == 0) {
            return weathers;
        }
        fis = new FileInputStream(f);
        ois = new ObjectInputStream(fis);
        WeatherInfo m;
        try{
            while(true){
                m = (WeatherInfo) ois.readObject();
                weathers.add(m);
            }
        }catch (EOFException | ClassNotFoundException e){
        }

        ois.close();
        return weathers;
    }

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

    public void writeToBin(String binFile, Object u) throws IOException {
        File f;
        FileOutputStream fos;
        ObjectOutputStream oos;
        f = new File(binFile);
        if(f.exists()){
            fos = new FileOutputStream(f, true);
            oos = new AppendableObjectOutputStream(fos);
        }
        else{
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
        }
        oos.writeObject(u);
        oos.close();
    }

    @FXML
    public void initialize() throws IOException {
        ArrayList <Mission> missions = readMissions("missions.bin");
        for(Mission m : missions){
            selectMissionIdCB.getItems().add(m.getMissionId());
        }

    }

    @FXML
    public void backToDashboardBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/airOperationsOfficerDashboard-view.fxml");
    }

    @FXML
    public void checkWeatherBTN(ActionEvent actionEvent) throws IOException {
        LocalDate date = flightDateDP.getValue();
        String condition = "Opps! No Data Found";
        String remarks = "";
        ArrayList<WeatherInfo> weathers = readWeatherInfo("weatherInfo.bin");
        for(WeatherInfo w : weathers){
            if(w.getDate().equals(date)){
                condition = w.getCondition();
                remarks = "Temperature : " + w.getTemperature() + "C" + "\n  Wind Direction : " + w.getWindDirection();
                break;
            }
        }
        showWeatherConditionLabel.setText(condition);
        showOperationalRemarksTA.setText(remarks);
    }

    @FXML
    public void createFlightScheduleBTN(ActionEvent actionEvent) throws IOException {
        ArrayList <FlightSchedule> flights = readFlightSchedules("flightSchedules.bin");
        int id = 1001;
        for(FlightSchedule f : flights){
            id++;
        }
        LocalDate date = flightDateDP.getValue();
        String time = launchTImeTF.getText();
        String status = "Scheduled";
        boolean isApproved = false;
        boolean isPending = true;
        Mission mission = null;
        ArrayList <Mission> missions = readMissions("missions.bin");
        for(Mission m : missions){
            if(selectMissionIdCB.getValue().equals(m.getMissionId())){
                mission = m;
            }
        }

        assert mission != null;
        FlightSchedule f = new FlightSchedule(
                mission, id, time, status, date, isApproved, isPending
        );
        writeToBin("flightSchedules.bin", f);

    }

    @FXML
    public void clearWeatherAndRemarksFieldBTN(ActionEvent actionEvent) {
        showOperationalRemarksTA.setText("");
        showWeatherConditionLabel.setText("Opps! No Data Found!!!");
    }
}