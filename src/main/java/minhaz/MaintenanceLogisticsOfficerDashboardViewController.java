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
    private Button viewToolsInventoryButton;
    @javafx.fxml.FXML
    private Button updateToolsInventoryButton;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void logOutButtonOnAction(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "login-view.fxml");
    }

    @javafx.fxml.FXML
    public void sparePartsReportSceneOnAction(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent,"/com/example/airplane_carrier_project_cse213/minhaz/mlo-create-aircraft-parts-report-view.fxml");

    }

    @javafx.fxml.FXML
    public void addInventorySceneButtonOnAction(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent,"/com/example/airplane_carrier_project_cse213/minhaz/mlo-add-items-inventory-view.fxml");

    }

    @javafx.fxml.FXML
    public void updateInventorySceneButtonOnAction(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent,"/com/example/airplane_carrier_project_cse213/minhaz/mlo-update-existing-items-view.fxml");

    }

    @javafx.fxml.FXML
    public void reportInventorySceneButtonOnAction(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent,"/com/example/airplane_carrier_project_cse213/minhaz/mlo-report-inventory-shortage-view.fxml");

    }

    @javafx.fxml.FXML
    public void sparePartsSceneButtonOnAction(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent,"/com/example/airplane_carrier_project_cse213/minhaz/mlo-check-aircraft-parts-view.fxml");

    }

    @javafx.fxml.FXML
    public void logAircraftSceneButtonOnAction(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent,"/com/example/airplane_carrier_project_cse213/minhaz/mlo-log-aircraft-into-system-view.fxml");
    }

    @javafx.fxml.FXML
    public void viewToolsInventoryButtonOnAction(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent,"/com/example/airplane_carrier_project_cse213/minhaz/mlo-view-maintenance-tools-inventory-view.fxml");

    }


    @javafx.fxml.FXML
    public void updateToolsInventoryButtonOnAction(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent,"/com/example/airplane_carrier_project_cse213/minhaz/mlo-update-tools-inventory-view.fxml");

    }
}