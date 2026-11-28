package swapnil;

import NonUser.Aircraft;
import NonUser.EmergencyAlert;
import NonUser.Mission;
import com.example.airplane_carrier_project_cse213.Helper;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class emergencyAuthorizationViewController
{
    @javafx.fxml.FXML
    private TableView <EmergencyAlert> EmergencyAlertTableView;
    @javafx.fxml.FXML
    private ComboBox <Integer> selectAlertIdCB;
    @javafx.fxml.FXML
    private TableColumn <EmergencyAlert, LocalDate> alertDateCol;
    @javafx.fxml.FXML
    private TextArea showAlertDescriptionTA;
    @javafx.fxml.FXML
    private TableColumn <EmergencyAlert, Boolean> actionApprovedCol;
    @javafx.fxml.FXML
    private TableColumn <EmergencyAlert, String> alertSeverityCol;
    @javafx.fxml.FXML
    private TextField showRequestActionTF;
    @javafx.fxml.FXML
    private TableColumn <EmergencyAlert, Integer> alertIdCol;
    @javafx.fxml.FXML
    private TableColumn <EmergencyAlert, String> alertTypeCol;

    public ArrayList<EmergencyAlert> readEmergencyAlerts(String binFile) throws IOException {
        ArrayList <EmergencyAlert> alerts = new ArrayList<EmergencyAlert>();
        File f;
        FileInputStream fis;
        ObjectInputStream ois;
        f = new File(binFile);
        if (!f.exists() || f.length() == 0) {
            return alerts;
        }
        fis = new FileInputStream(f);
        ois = new ObjectInputStream(fis);
        EmergencyAlert m;
        try{
            while(true){
                m = (EmergencyAlert) ois.readObject();
                alerts.add(m);
            }
        }catch (EOFException | ClassNotFoundException e){
        }

        ois.close();
        return alerts;
    }

    public void rewriteEmergencyAlerts(String binFile, ArrayList<EmergencyAlert> alerts) throws IOException {
        FileOutputStream fos = new FileOutputStream(binFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (EmergencyAlert m : alerts) {
            oos.writeObject(m);
        }
        oos.close();
    }

    @javafx.fxml.FXML
    public void initialize() throws IOException {
        alertIdCol.setCellValueFactory(new PropertyValueFactory<>("alertId"));
        alertTypeCol.setCellValueFactory(new PropertyValueFactory<>("alertType"));
        alertSeverityCol.setCellValueFactory(new PropertyValueFactory<>("alertSeverity"));
        alertDateCol.setCellValueFactory(new PropertyValueFactory<>("alertDate"));
        actionApprovedCol.setCellValueFactory(new PropertyValueFactory<>("actionApproved"));

        ArrayList <EmergencyAlert> alerts = readEmergencyAlerts("emergencyAlerts.bin");
        EmergencyAlertTableView.getItems().addAll(alerts);
        for(EmergencyAlert a : alerts){
            selectAlertIdCB.getItems().add(a.getAlertId());
        }

    }

    @javafx.fxml.FXML
    public void actionRejectBTN(ActionEvent actionEvent) throws IOException {
        ArrayList <EmergencyAlert> alerts = readEmergencyAlerts("emergencyAlerts.bin");
        for(EmergencyAlert a : alerts){
            if(a.getAlertId()==selectAlertIdCB.getValue()){
                a.setActionApproved(false);
                break;
            }
        }
        rewriteEmergencyAlerts("emergencyAlerts.bin", alerts);
        alerts = readEmergencyAlerts("emergencyAlerts.bin");

        EmergencyAlertTableView.getItems().clear();
        EmergencyAlertTableView.getItems().addAll(alerts);
    }

    @javafx.fxml.FXML
    public void backToDashboardBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/carrierCaptainDashboard-view.fxml");
    }

    @javafx.fxml.FXML
    public void getDetailsByAlertIdBTN(ActionEvent actionEvent) throws IOException {
        ArrayList <EmergencyAlert> alerts = readEmergencyAlerts("emergencyAlerts.bin");
        for(EmergencyAlert a : alerts){
            if(a.getAlertId()==selectAlertIdCB.getValue()){
                showAlertDescriptionTA.setText(a.getAlertDescription());
                showRequestActionTF.setText(a.getActionTakenRequest());
                break;
            }
        }
    }

    @javafx.fxml.FXML
    public void actionApprovedBTN(ActionEvent actionEvent) throws IOException {
        ArrayList <EmergencyAlert> alerts = readEmergencyAlerts("emergencyAlerts.bin");
        for(EmergencyAlert a : alerts){
            if(a.getAlertId()==selectAlertIdCB.getValue()){
                a.setActionApproved(true);
                break;
            }
        }
        rewriteEmergencyAlerts("emergencyAlerts.bin", alerts);
        alerts = readEmergencyAlerts("emergencyAlerts.bin");

        EmergencyAlertTableView.getItems().clear();
        EmergencyAlertTableView.getItems().addAll(alerts);
    }
}