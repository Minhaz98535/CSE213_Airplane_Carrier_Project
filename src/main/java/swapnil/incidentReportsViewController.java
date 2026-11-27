package swapnil;

import NonUser.Aircraft;
import NonUser.IncidentReport;
import com.example.airplane_carrier_project_cse213.Helper;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class incidentReportsViewController
{
    @javafx.fxml.FXML
    private TableColumn <Aircraft, Integer> aircraftIdCol;
    @javafx.fxml.FXML
    private ComboBox <Integer> selectReportIdCB;
    @javafx.fxml.FXML
    private ComboBox <String> filterDamageCB;
    @javafx.fxml.FXML
    private TableColumn <IncidentReport,String> incidentLocationCol;
    @javafx.fxml.FXML
    private TableColumn <IncidentReport,String> damageSeverityCol;
    @javafx.fxml.FXML
    private TableColumn <IncidentReport, LocalDate> reportDateCol;
    @javafx.fxml.FXML
    private TextArea showDescriptionTA;
    @javafx.fxml.FXML
    private TableColumn <IncidentReport,Integer> reportIdCol;
    @javafx.fxml.FXML
    private TableView <IncidentReport> IncidentReportTableView;

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

    @javafx.fxml.FXML
    public void initialize() throws IOException {
        filterDamageCB.getItems().addAll("Minor", "Moderate", "Major", "Critical");

        reportIdCol.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        reportDateCol.setCellValueFactory(new PropertyValueFactory<>("reportDate"));
        aircraftIdCol.setCellValueFactory(new PropertyValueFactory<>("aircraftId"));
        incidentLocationCol.setCellValueFactory(new PropertyValueFactory<>("incidentLocation"));
        damageSeverityCol.setCellValueFactory(new PropertyValueFactory<>("damageSeverity"));

        ArrayList <IncidentReport> reports = readIncidentReports("incidentReports.bin");
        IncidentReportTableView.getItems().addAll(reports);
        for(IncidentReport r : reports){
            selectReportIdCB.getItems().add(r.getReportId());
        }
    }

    @javafx.fxml.FXML
    public void backToDashboardBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/swapnil/carrierCaptainDashboard-view.fxml");
    }

    @javafx.fxml.FXML
    public void filterReportByDamageBTN(ActionEvent actionEvent) throws IOException {
        ArrayList <IncidentReport> reports = readIncidentReports("incidentReports.bin");
        IncidentReportTableView.getItems().clear();
        for(IncidentReport r : reports){
            if(filterDamageCB.getValue().equals(r.getDamageSeverity())){
                IncidentReportTableView.getItems().add(r);
            }
        }
        selectReportIdCB.getItems().clear();
        for(IncidentReport r : IncidentReportTableView.getItems()){
            selectReportIdCB.getItems().add(r.getReportId());
        }
    }

    @javafx.fxml.FXML
    public void getDescriptionByReportIdBTN(ActionEvent actionEvent) throws IOException {
        ArrayList <IncidentReport> reports = readIncidentReports("incidentReports.bin");
        for(IncidentReport r : reports){
            if(r.getReportId()==selectReportIdCB.getValue()){
                showDescriptionTA.setText(r.getDetailsReport());
                break;
            }
        }
    }
}