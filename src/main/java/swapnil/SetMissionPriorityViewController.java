package swapnil;

import NonUser.Mission;
import com.example.airplane_carrier_project_cse213.Helper;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class SetMissionPriorityViewController
{
    @javafx.fxml.FXML
    private ComboBox <String> selectMissionPriorityCB;
    @javafx.fxml.FXML
    private TableColumn <Mission, String> missionNameCol;
    @javafx.fxml.FXML
    private TableColumn <Mission, LocalDate> missionDateCol;
    @javafx.fxml.FXML
    private ComboBox <Integer> selectMissionIdCB;
    @javafx.fxml.FXML
    private TableView <Mission> MissionTableView;
    @javafx.fxml.FXML
    private TableColumn <Mission, Integer> missionIdCol;
    @javafx.fxml.FXML
    private TableColumn <Mission, String> missionTypeCol;
    @javafx.fxml.FXML
    private TableColumn <Mission, String> missionPriorityCol;

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

    public void rewriteMissions(String binFile, ArrayList<Mission> missions) throws IOException {
        FileOutputStream fos = new FileOutputStream(binFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Mission m : missions) {
            oos.writeObject(m);
        }
        oos.close();
    }

    @javafx.fxml.FXML
    public void initialize() throws IOException {
        selectMissionPriorityCB.getItems().addAll("Low", "Medium", "High");

        missionIdCol.setCellValueFactory(new PropertyValueFactory<>("missionId"));
        missionNameCol.setCellValueFactory(new PropertyValueFactory<>("missionName"));
        missionTypeCol.setCellValueFactory(new PropertyValueFactory<>("missionType"));
        missionDateCol.setCellValueFactory(new PropertyValueFactory<>("missionDate"));
        missionPriorityCol.setCellValueFactory(new PropertyValueFactory<>("missionPriority"));

        ArrayList <Mission> missions = readMissions("missions.bin");
        MissionTableView.getItems().addAll(missions);
        for(Mission m : missions){
            selectMissionIdCB.getItems().add(m.getMissionId());
        }
    }

    @javafx.fxml.FXML
    public void backToDashboardBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/carrierCaptainDashboard-view.fxml");
    }

    @javafx.fxml.FXML
    public void updateMissionPriorityBTN(ActionEvent actionEvent) throws IOException {
        ArrayList <Mission> missions = readMissions("missions.bin");
        for(Mission m : missions){
            if(m.getMissionId()==selectMissionIdCB.getValue()){
                m.setMissionPriority(selectMissionPriorityCB.getValue());
                break;
            }
        }
        rewriteMissions("missions.bin", missions);
        missions = readMissions("missions.bin");

        MissionTableView.getItems().clear();
        MissionTableView.getItems().addAll(missions);
    }
}