package swapnil;

import NonUser.Mission;
import com.example.airplane_carrier_project_cse213.AppendableObjectOutputStream;
import com.example.airplane_carrier_project_cse213.Helper;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MissionManagementControllerView
{
    @javafx.fxml.FXML
    private DatePicker filterMissionDateBEforeDP;
    @javafx.fxml.FXML
    private TableColumn <Mission,String> missionTargetCol;
    @javafx.fxml.FXML
    private TableColumn <Mission, LocalDate> missionDateCol;
    @javafx.fxml.FXML
    private ComboBox <String> filterMissionTypeCB;
    @javafx.fxml.FXML
    private ComboBox <String> filterMissionStatusCB;
    @javafx.fxml.FXML
    private TextArea inputMissionDescriptionTA;
    @javafx.fxml.FXML
    private TextField inputMissionNameTF;
    @javafx.fxml.FXML
    private TextField inputMissionTargetTF;
    @javafx.fxml.FXML
    private TableColumn <Mission, String > missionNameCol;
    @javafx.fxml.FXML
    private ComboBox <String> inputMissionTypeCB;
    @javafx.fxml.FXML
    private TableColumn <Mission, Integer> missionIdCol;
    @javafx.fxml.FXML
    private TableView <Mission> MissionTableVIew;
    @javafx.fxml.FXML
    private TableColumn <Mission, String> missionTypeCol;
    @javafx.fxml.FXML
    private TableColumn <Mission, String> missionStatusCol;
    @javafx.fxml.FXML
    private DatePicker inputMissionDateDP;

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

    @javafx.fxml.FXML
    public void initialize() throws IOException {
        inputMissionTypeCB.getItems().addAll("Patrol","Surveillance", "Rescue", "Transport", "Training");
        filterMissionTypeCB.getItems().addAll("Patrol","Surveillance", "Rescue", "Transport", "Training");
        filterMissionStatusCB.getItems().addAll("In Progress", "Completed", "Cancelled");

        missionIdCol.setCellValueFactory(new PropertyValueFactory<>("missionId"));
        missionNameCol.setCellValueFactory(new PropertyValueFactory<>("missionName"));
        missionTypeCol.setCellValueFactory(new PropertyValueFactory<>("missionType"));
        missionTargetCol.setCellValueFactory(new PropertyValueFactory<>("missionTarget"));
        missionDateCol.setCellValueFactory(new PropertyValueFactory<>("missionDate"));
        missionStatusCol.setCellValueFactory(new PropertyValueFactory<>("missionStatus"));

        ArrayList <Mission> missions = readMissions("missions.bin");
        MissionTableVIew.getItems().addAll(missions);
    }

    @javafx.fxml.FXML
    public void backToDashboardBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/carrierCaptainDashboard-view.fxml");
    }

    @javafx.fxml.FXML
    public void filterMIssionTableBTN(ActionEvent actionEvent) throws IOException {
        ArrayList <Mission> missions = readMissions("missions.bin");
        String type = filterMissionTypeCB.getValue();
        String status = filterMissionStatusCB.getValue();
        LocalDate date = filterMissionDateBEforeDP.getValue();

//        ----------- Validation --------------

        MissionTableVIew.getItems().clear();

        for(Mission m : missions){
            if(m.getMissionType().equals(type) && m.getMissionStatus().equals(status) && m.getMissionDate().isBefore(date)){
                MissionTableVIew.getItems().add(m);
            }
        }
    }

    @javafx.fxml.FXML
    public void assignMissionBTN(ActionEvent actionEvent) throws IOException {
        String name = inputMissionNameTF.getText();
        String target = inputMissionTargetTF.getText();
        String description = inputMissionDescriptionTA.getText();
        LocalDate date = inputMissionDateDP.getValue();
        String type = inputMissionTypeCB.getValue();
        int id = 100;
        ArrayList <Mission> missions = readMissions("missions.bin");
        for(Mission m : missions){
            id++;
        }

//      ------------------------------  Validatation ----------------------

        Mission m = new Mission(
            id, name, type, target, description, "In Progress", "Low", date
        );
        writeToBin("missions.bin", m);
        MissionTableVIew.getItems().add(m);
    }
}