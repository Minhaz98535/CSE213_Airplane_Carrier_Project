package minhaz;

import com.example.airplane_carrier_project_cse213.Helper;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class MaintenanceLogisticsOfficerDashboardViewController
{
    @javafx.fxml.FXML
    private Button logOutButton;
    @javafx.fxml.FXML
    private Label aircraftReadyLabel;
    @javafx.fxml.FXML
    private Label crewNumberLabel;
    @javafx.fxml.FXML
    private Button updateInventorySceneButton;
    @javafx.fxml.FXML
    private Button sparePartsReportScene;
    @javafx.fxml.FXML
    private Button sparePartsSceneButton;
    @javafx.fxml.FXML
    private Button addInventorySceneButton;
    @javafx.fxml.FXML
    private Button reportInventorySceneButton;
    @javafx.fxml.FXML
    private Button logAircraftSceneButton;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @Deprecated
    public void aircraftReadinessSceneButtonOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void viewFitnessReportButtonOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void emergencyMsgSceneButtonOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void navigationSceneButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void logOutButtonOnAction(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "login-view.fxml");
    }

    @Deprecated
    public void inventoryReportsSceneButtonOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void IncidentReportSceneButton(ActionEvent actionEvent) {
    }

    @Deprecated
    public void arsenalViewButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sparePartsReportSceneOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void addInventorySceneButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updateInventorySceneButtonOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void aircraftStatusSceneButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void reportInventorySceneButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sparePartsSceneButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void logAircraftSceneButtonOnAction(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent,"/com/example/airplane_carrier_project_cse213/minhaz/mlo-log-aircraft-into-system-view.fxml");
    }
}