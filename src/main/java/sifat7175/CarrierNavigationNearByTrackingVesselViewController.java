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

        norisklabel.setText("No Risk");
        emergencyNotificationLabel.setText("All clear.");

        for (gps v : vessels) {
            if ("High".equalsIgnoreCase(v.getRiskLevel())) {
                norisklabel.setText("High Risk");
                emergencyNotificationLabel.setText("ALERT: High-risk vessel (" + v.getVesselName() + ")");
                break;
            }
        }
    }

    @FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/sifat7175/carrierNavigationDashboard.fxml");
    }

    @FXML
    public void refreshOnActionButton(ActionEvent actionEvent) {
        loadVesselData();
    }
}