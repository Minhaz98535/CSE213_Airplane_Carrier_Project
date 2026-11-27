package sohan;
import NonUser.IssueReport;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


public class ReportAircraftIssueController {

    @FXML
    private TextArea describetheproblemtextarea;

    @FXML
    private Label massagethereportnotathorised;

    @FXML
    private Label modelmassage;

    @FXML
    private Label reportaircraftissue;

    @FXML
    private ComboBox<String> aircraftComboBox;

    @FXML
    private Label statusmassage;

    @FXML
    private ComboBox<String> SeverityComboBox;

    @FXML
    private ComboBox<String> catagoryComboBox;

    @FXML
    private TextArea addtionalObservationtextarea;

    @FXML
    public void initialize() {

        aircraftComboBox.getItems().setAll(
                "252622",
                "252628"
        );

        SeverityComboBox.getItems().setAll(
                "Low",
                "Medium",
                "High",
                "Critical"
        );

        catagoryComboBox.getItems().setAll(
                "Engine",
                "Fuel System",
                "Electrical",
                "Landing Gear",
                "Wings",
                "Other"
        );

        massagethereportnotathorised.setVisible(false);
        modelmassage.setVisible(false);
        statusmassage.setVisible(false);
    }

    @FXML
    public void submitIssuereportButton(ActionEvent actionEvent) {

        String aircraftId = aircraftComboBox.getValue();
        String severity = SeverityComboBox.getValue();
        String category = catagoryComboBox.getValue();

        String problem = describetheproblemtextarea
                .getText().trim();

        String observation = addtionalObservationtextarea
                .getText().trim();

        if (aircraftId == null || severity == null
                || category == null || problem.isBlank()) {

            statusmassage.setText(
                    "Please complete all required fields."
            );

            statusmassage.setVisible(true);
            return;
        }
        IssueReport report = new IssueReport(
                aircraftId,
                severity,
                category,
                problem,
                observation
        );

        System.out.println(report);
        statusmassage.setText("Issue report submitted successfully.");
        statusmassage.setVisible(true);

        System.out.println("Aircraft ID: " + aircraftId);
        System.out.println("Severity: " + severity);
        System.out.println("Category: " + category);
        System.out.println("Problem: " + problem);
        System.out.println("Observation: " + observation);
    }
}