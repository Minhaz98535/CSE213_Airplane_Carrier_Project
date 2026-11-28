package sifat7175;

import NonUser.gps;
import com.example.airplane_carrier_project_cse213.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;

public class CarrierNavigationNearByTrackingVesselViewController {

    @FXML
    private TableColumn<gps, String> riskLevelTC;
    @FXML
    private TableColumn<gps, String> aisTC;
    @FXML
    private Label norisklabel;
    @FXML
    private TableColumn<gps, Double> rangeTC;
    @FXML
    private Label nearbyvessellable;
    @FXML
    private TableColumn<gps, Double> speedTC;
    @FXML
    private TableColumn<gps, String> headingvectorTC;
    @FXML
    private TableView<gps> NearbyvewsselTableView;
    @FXML
    private TableColumn<gps, String> vesselnameTC;
    @FXML
    private Label emergencyNotificationLabel;

    @FXML
    public void initialize() {

        vesselnameTC.setCellValueFactory(new PropertyValueFactory<>("vesselName"));
        aisTC.setCellValueFactory(new PropertyValueFactory<>("aisId"));
        rangeTC.setCellValueFactory(new PropertyValueFactory<>("range"));
        speedTC.setCellValueFactory(new PropertyValueFactory<>("speed"));
        headingvectorTC.setCellValueFactory(new PropertyValueFactory<>("heading"));
        riskLevelTC.setCellValueFactory(new PropertyValueFactory<>("riskLevel"));

        loadVesselData();
    }

    private void loadVesselData() {
        ArrayList<gps> vessels = gps.getDummyNearbyVessels();

        NearbyvewsselTableView.getItems().clear();
        NearbyvewsselTableView.getItems().addAll(vessels);

        nearbyvessellable.setText(String.format("%02d", vessels.size()));

        boolean highRiskFound = false;
        String highRiskVesselName = "";

        for (gps v : vessels) {
            if ("High".equalsIgnoreCase(v.getRiskLevel())) {
                highRiskFound = true;
                highRiskVesselName = v.getVesselName();
                break;
            }
        }

        if (highRiskFound) {
            norisklabel.setText("High Risk");
            norisklabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            if (emergencyNotificationLabel != null) {
                emergencyNotificationLabel.setText("ALERT: High-risk vessel detected nearby (" + highRiskVesselName + ")!");
                emergencyNotificationLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            }
        } else {
            norisklabel.setText("No Risk");
            norisklabel.setStyle("-fx-text-fill: green;");
            if (emergencyNotificationLabel != null) {
                emergencyNotificationLabel.setText("All clear. No immediate threat.");
            }
        }
    }

    @FXML
    public void refreshOnActionButton(ActionEvent actionEvent) {

        loadVesselData();
    }

    @FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {

        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/sifat7175/carrierNavigationDashboard.fxml");
    }
}