package minhaz;

import NonUser.Aircraft;
import com.example.airplane_carrier_project_cse213.AppendableObjectOutputStream;
import com.example.airplane_carrier_project_cse213.Helper;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class FdoApproveAircraftReadinessViewController
{
    @javafx.fxml.FXML
    private TableColumn<Aircraft, Integer> aircraftIdCol;
    @javafx.fxml.FXML
    private Button backToDashboardButton;
    @javafx.fxml.FXML
    private TableColumn<Aircraft, String> aircraftTypeCol;
    @javafx.fxml.FXML
    private Button confirmButton;
    @javafx.fxml.FXML
    private TableColumn<Aircraft, String> aircraftStatusCol;
    @javafx.fxml.FXML
    private ComboBox<Integer> idSelectionComboBox;
    @javafx.fxml.FXML
    private TableView<Aircraft> aircraftTableView;

    public ArrayList<Aircraft> readAircraft(String binFile) throws IOException {
        ArrayList <Aircraft> aircraftArrayList = new ArrayList<>();
        File f;
        FileInputStream fis;
        ObjectInputStream ois;
        f = new File(binFile);
        if (!f.exists() || f.length() == 0) {
            return aircraftArrayList;
        }
        fis = new FileInputStream(f);
        ois = new ObjectInputStream(fis);
        Aircraft m;
        try{
            while(true){
                m = (Aircraft) ois.readObject();
                aircraftArrayList.add(m);
            }
        }catch (EOFException | ClassNotFoundException e){
        }

        ois.close();
        return aircraftArrayList;
    }

    public void rewriteAircraft(String binFile, ArrayList<Aircraft> aircraftArrayList) throws IOException {
        FileOutputStream fos = new FileOutputStream(binFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Aircraft aCraft : aircraftArrayList) {
            oos.writeObject(aCraft);
        }
        oos.close();
    }

    @javafx.fxml.FXML
    public void initialize() throws IOException {
        aircraftIdCol.setCellValueFactory(new PropertyValueFactory<>("aircraftId"));
        aircraftTypeCol.setCellValueFactory(new PropertyValueFactory<>("aircraftType"));
        aircraftStatusCol.setCellValueFactory(new PropertyValueFactory<>("aircraftStatus"));

        ArrayList<Aircraft> aircraftArrayList = readAircraft("aircraft.bin");
        for(Aircraft aCraft : aircraftArrayList){
            if(Objects.equals(aCraft.getAircraftStatus(), "Undecided")){
                aircraftTableView.getItems().add(aCraft);
                idSelectionComboBox.getItems().add(aCraft.getAircraftId());
            }
        }
    }

    @javafx.fxml.FXML
    public void confirmButtonOnAction(ActionEvent actionEvent) throws IOException {
        int selectedId = idSelectionComboBox.getValue();

        ArrayList<Aircraft> aircraftArrayList = readAircraft("aircraft.bin");
        for(Aircraft aCraft : aircraftArrayList){
            if(Objects.equals(aCraft.getAircraftId(), selectedId)){
                aCraft.setAircraftStatus("Ready");
            }
        }
        rewriteAircraft("aircraft.bin", aircraftArrayList);
        aircraftTableView.getItems().clear();
        aircraftTableView.getItems().addAll(aircraftArrayList);

    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent,"/com/example/airplane_carrier_project_cse213/minhaz/flight-deck-officer-dashboard.fxml");

    }
}