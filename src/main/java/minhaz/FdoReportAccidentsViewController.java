package minhaz;

import NonUser.IncidentReport;
import com.example.airplane_carrier_project_cse213.AppendableObjectOutputStream;
import com.example.airplane_carrier_project_cse213.Helper;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class FdoReportAccidentsViewController
{
    @javafx.fxml.FXML
    private TextField reportIdTextField;
    @javafx.fxml.FXML
    private TextArea reportDetailsTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> reportTypeComboBox;
    @javafx.fxml.FXML
    private DatePicker reportDateDatePicker;
    @javafx.fxml.FXML
    private Button sumbitButton;
    @javafx.fxml.FXML
    private TextField locationTextField;
    @javafx.fxml.FXML
    private ComboBox<String> severityComboBox;
    @javafx.fxml.FXML
    private Button backToDashboardButton;

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
        reportTypeComboBox.getItems().addAll("Aircraft Accident", "Flight Deck Accident", "Equipment Damage", "Personnel Injury", "Collision", "Operational Incident", "Others");
        statusComboBox.getItems().addAll("Resolved", "Under Investigation", "Action Required", "Closed");
        severityComboBox.getItems().addAll("Minor", "Moderate", "Major", "Critical");
    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/minhaz/flight-deck-officer-dashboard.fxml");
    }
    @javafx.fxml.FXML
    public void submitButtonOnAction(ActionEvent actionEvent) throws IOException {
        int reportId = Integer.parseInt(reportIdTextField.getText());
        LocalDate reportDate = reportDateDatePicker.getValue();
        String reportType = reportTypeComboBox.getValue();
        String location = locationTextField.getText();
        String severity = severityComboBox.getValue();
        String status = statusComboBox.getValue();
        String details = reportDetailsTextArea.getText();

        IncidentReport i = new IncidentReport(
                reportId, reportDate, reportType, location, severity, details, status
        );
        writeToBin("incidentReports.bin", i);

    }
}