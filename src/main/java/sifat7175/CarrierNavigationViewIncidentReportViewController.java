package sifat7175;

import NonUser.Aircraft;
import NonUser.IncidentReport;
import com.example.airplane_carrier_project_cse213.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class CarrierNavigationViewIncidentReportViewController {

    @FXML
    private TableColumn<Aircraft, Integer> aircraftIdCol;
    @FXML
    private ComboBox<Integer> selectReportIdCB;
    @FXML
    private ComboBox<String> filterDamageCB;
    @FXML
    private TableColumn<IncidentReport, String> incidentLocationCol;
    @FXML
    private TableColumn<IncidentReport, String> damageSeverityCol;
    @FXML
    private TableColumn<IncidentReport, LocalDate> reportDateCol;
    @FXML
    private TextArea showDescriptionTA;
    @FXML
    private TableColumn<IncidentReport, Integer> reportIdCol;
    @FXML
    private TableView<IncidentReport> IncidentReportTableView;

    public ArrayList<IncidentReport> readIncidentReports(String binFile) throws IOException {
        ArrayList<IncidentReport> reports = new ArrayList<>();
        File f = new File(binFile);
        if (!f.exists() || f.length() == 0) {
            return reports;
        }
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        IncidentReport m;
        try {
            while (true) {
                m = (IncidentReport) ois.readObject();
                reports.add(m);
            }
        } catch (EOFException | ClassNotFoundException e) {
            // End of file reached
        }
        ois.close();
        return reports;
    }

    @FXML
    public void initialize() throws IOException {
        filterDamageCB.getItems().addAll("Minor", "Moderate", "Major", "Critical");

        reportIdCol.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        reportDateCol.setCellValueFactory(new PropertyValueFactory<>("reportDate"));
        aircraftIdCol.setCellValueFactory(new PropertyValueFactory<>("aircraftId"));
        incidentLocationCol.setCellValueFactory(new PropertyValueFactory<>("incidentLocation"));
        damageSeverityCol.setCellValueFactory(new PropertyValueFactory<>("damageSeverity"));

        ArrayList<IncidentReport> reports = readIncidentReports("incidentReports.bin");
        IncidentReportTableView.getItems().addAll(reports);
        for (IncidentReport r : reports) {
            selectReportIdCB.getItems().add(r.getReportId());
        }
    }

    @FXML
    public void backToDashboardBTN(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/sifat7175/carrierNavigationDashboard.fxml");
    }

    @FXML
    public void filterReportByDamageBTN(ActionEvent actionEvent) throws IOException {
        if (filterDamageCB.getValue() == null) return;

        ArrayList<IncidentReport> reports = readIncidentReports("incidentReports.bin");
        IncidentReportTableView.getItems().clear();
        for (IncidentReport r : reports) {
            if (filterDamageCB.getValue().equals(r.getDamageSeverity())) {
                IncidentReportTableView.getItems().add(r);
            }
        }
        selectReportIdCB.getItems().clear();
        for (IncidentReport r : IncidentReportTableView.getItems()) {
            selectReportIdCB.getItems().add(r.getReportId());
        }
    }

    @FXML
    public void getDescriptionByReportIdBTN(ActionEvent actionEvent) throws IOException {
        if (selectReportIdCB.getValue() == null) return;

        ArrayList<IncidentReport> reports = readIncidentReports("incidentReports.bin");
        for (IncidentReport r : reports) {
            if (r.getReportId() == selectReportIdCB.getValue()) {
                showDescriptionTA.setText(r.getDetailsReport());
                break;
            }
        }
    }
}