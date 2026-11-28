package swapnil;

import NonUser.EmergencyAlert;
import NonUser.IncidentReport;
import NonUser.Mission;
import com.example.airplane_carrier_project_cse213.AppendableObjectOutputStream;
import com.example.airplane_carrier_project_cse213.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmergencyAlertViewController
{
    @FXML
    private TableColumn <IncidentReport,String> reportStatusCol;
    @FXML
    private ComboBox <Integer> selectReportIdCB;
    @FXML
    private TextField actionTOTakenRequestTF;
    @FXML
    private TableColumn <IncidentReport,String> damageSeverityCol;
    @FXML
    private TextArea alertDescriptionTA;
    @FXML
    private TableColumn <IncidentReport,String> emergencyTypeCol;
    @FXML
    private TableColumn <IncidentReport,Integer> reportIdCol;
    @FXML
    private TableView <IncidentReport> IncidentReportTableView;

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

    public ArrayList<IncidentReport> readIncidentReports(String binFile) throws IOException {
        ArrayList <IncidentReport> reports = new ArrayList<IncidentReport>();
        File f;
        FileInputStream fis;
        ObjectInputStream ois;
        f = new File(binFile);
        if (!f.exists() || f.length() == 0) {
            return reports;
        }
        fis = new FileInputStream(f);
        ois = new ObjectInputStream(fis);
        IncidentReport m;
        try{
            while(true){
                m = (IncidentReport) ois.readObject();
                reports.add(m);
            }
        }catch (EOFException | ClassNotFoundException e){
        }

        ois.close();
        return reports;
    }

    @FXML
    public void initialize() throws IOException {
        reportIdCol.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        emergencyTypeCol.setCellValueFactory(new PropertyValueFactory<>("reportType"));
        reportStatusCol.setCellValueFactory(new PropertyValueFactory<>("reportStatus"));
        damageSeverityCol.setCellValueFactory(new PropertyValueFactory<>("damageSeverity"));

        ArrayList <IncidentReport> reports = readIncidentReports("incidentReports.bin");
        IncidentReportTableView.getItems().addAll(reports);
        for(IncidentReport r : reports){
            selectReportIdCB.getItems().add(r.getReportId());
        }
    }

    @FXML
    public void backToDashboardBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/airOperationsOfficerDashboard-view.fxml");
    }

    @FXML
    public void requestForPermissionBTN(ActionEvent actionEvent) throws IOException {
        ArrayList <IncidentReport> reports = readIncidentReports("incidentReports.bin");
        String alertType = "";
        String alertSeverity = "";
        String alertDescription = alertDescriptionTA.getText();
        String actionTakenRequest = actionTOTakenRequestTF.getText();
        LocalDate alertDate = LocalDate.now();
        boolean actionApproved = false;
        for(IncidentReport r : reports){
            if(r.getReportId()==selectReportIdCB.getValue()){
                alertType = r.getReportType();
                alertSeverity = r.getDamageSeverity();
                break;
            }
        }
        int id = 4001;
        ArrayList <EmergencyAlert> alerts = readEmergencyAlerts("emergencyAlerts.bin");
        for(EmergencyAlert a : alerts){
            id++;
        }

        EmergencyAlert a = new EmergencyAlert(
          id, alertType, alertSeverity, alertDescription, actionTakenRequest, alertDate, actionApproved
        );
        writeToBin("emergencyAlerts.bin", a);

    }
}