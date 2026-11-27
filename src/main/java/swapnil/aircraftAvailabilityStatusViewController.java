package swapnil;

import NonUser.Aircraft;
import com.example.airplane_carrier_project_cse213.Helper;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;

public class aircraftAvailabilityStatusViewController
{
    @javafx.fxml.FXML
    private TableColumn <Aircraft,Integer> aircraftIdCol;
    @javafx.fxml.FXML
    private TableView <Aircraft> AircraftTableView;
    @javafx.fxml.FXML
    private ComboBox <String> filterAircraftStatusCB;
    @javafx.fxml.FXML
    private TableColumn <Aircraft,String> aircraftTypeCol;
    @javafx.fxml.FXML
    private TableColumn <Aircraft,String> aircraftStatusCol;

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
        filterAircraftStatusCB.getItems().addAll("Ready", "In Use", "Under Maintenance", "Damaged");
        aircraftIdCol.setCellValueFactory(new PropertyValueFactory<>("aircraftId"));
        aircraftTypeCol.setCellValueFactory(new PropertyValueFactory<>("aircraftType"));
        aircraftStatusCol.setCellValueFactory(new PropertyValueFactory<>("aircraftStatus"));

        ArrayList <Aircraft> aircrafts = readAircrafts("aircrafts.bin");
        AircraftTableView.getItems().addAll(aircrafts);
    }

    @javafx.fxml.FXML
    public void backToDashboardBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/carrierCaptainDashboard-view.fxml");
    }

    @javafx.fxml.FXML
    public void filterAircraftByStatusBTN(ActionEvent actionEvent) throws IOException {
        ArrayList <Aircraft> aircrafts = readAircrafts("aircrafts.bin");
        AircraftTableView.getItems().clear();
        for(Aircraft a: aircrafts){
            if(a.getAircraftStatus().equals(filterAircraftStatusCB.getValue())){
                AircraftTableView.getItems().add(a);
            }
        }
    }
}