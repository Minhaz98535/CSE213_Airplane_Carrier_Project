package minhaz;

import com.example.airplane_carrier_project_cse213.Helper;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class FlightDeckOfficerDashboardViewController
{
    @javafx.fxml.FXML
    private Button viewFitnessReportButton;
    @javafx.fxml.FXML
    private Button logOutButton;
    @javafx.fxml.FXML
    private Button emergencyMsgSceneButton;
    @javafx.fxml.FXML
    private Label aircraftReadyLabel;
    @javafx.fxml.FXML
    private Button aircraftReadinessSceneButton;
    @javafx.fxml.FXML
    private Label crewNumberLabel;
    @javafx.fxml.FXML
    private Button IncidentReportSceneButton;
    @javafx.fxml.FXML
    private Button inventoryReportsSceneButton;
    @javafx.fxml.FXML
    private Button navigationSceneButton1;
    @javafx.fxml.FXML
    private Button authoriseResupplyViewButton;
    @javafx.fxml.FXML
    private Button appointmentViewButton;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void aircraftReadinessSceneButtonOnAction(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/minhaz/fdo-approve-aircraft-readiness-view.fxml");
    }

    @javafx.fxml.FXML
    public void viewFitnessReportButtonOnAction(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/minhaz/fdo-view-fitness-report-view.fxml");
    }

    @javafx.fxml.FXML
    public void emergencyMsgSceneButtonOnAction(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/minhaz/fdo-create-emergency-brief-view.fxml");
    }

    @javafx.fxml.FXML
    public void navigationSceneButtonOnAction(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/minhaz/fdo-view-navigation-report-view.fxml");
    }

    @javafx.fxml.FXML
    public void logOutButtonOnAction(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "login-view.fxml");
    }

    @javafx.fxml.FXML
    public void inventoryReportsSceneButtonOnAction(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/minhaz/fdo-view-spare-parts-report-view.fxml");
    }

    @javafx.fxml.FXML
    public void IncidentReportSceneButton(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/minhaz/fdo-report-accidents-view.fxml");
    }

    @javafx.fxml.FXML
    public void appointmentViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/minhaz/fdo-create-appointments-view.fxml");
    }

    @javafx.fxml.FXML
    public void authoriseResupplyViewButtonOnAction(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/minhaz/fdo-authorise-resupply-view.fxml");
    }
}