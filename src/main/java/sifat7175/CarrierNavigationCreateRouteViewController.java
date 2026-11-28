package sifat7175;

import NonUser.gps;
import com.example.airplane_carrier_project_cse213.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CarrierNavigationCreateRouteViewController {

    @FXML
    private Label windlabel;
    @FXML
    private Label speedlabel;
    @FXML
    private Label avoidinglandslabel;
    @FXML
    private Label restrictedarealabel;
    @FXML
    private Label waypointlabel;
    @FXML
    private Label statuslabel;
    @FXML
    private Label distancelabel;
    @FXML
    private TextField enterdestinationTF;
    @FXML
    private Label currentpositionlabel;

    private gps myGps = new gps();

    @FXML
    public void initialize() {
        currentpositionlabel.setText(myGps.getFormattedPosition());
        speedlabel.setText(myGps.getSpeed() + " Knots");
        statuslabel.setText("Ready");
    }

    @FXML
    public void refreshonaction(ActionEvent actionEvent) {
        myGps.updateLivePosition();
        currentpositionlabel.setText(myGps.getFormattedPosition());
        speedlabel.setText(myGps.getSpeed() + " Knots");
        statuslabel.setText("Updated");
    }

    @FXML
    public void createrouteOnaction(ActionEvent actionEvent) {
        String destination = enterdestinationTF.getText();
        if (destination.isEmpty()) {
            statuslabel.setText("Enter Destination!");
            return;
        }

        String[] parts = gps.calculateDummyRoute(destination).split("\\|");
        distancelabel.setText(parts[0]);
        waypointlabel.setText(parts[1]);
        windlabel.setText(parts[2]);

        statuslabel.setText("Route Set to " + destination);
        restrictedarealabel.setText("Restricted Area: Clear");
        avoidinglandslabel.setText("Avoiding Lands: Safe");
    }

    @FXML
    public void confirmonactionbutton(ActionEvent actionEvent) {
        if (distancelabel.getText().equals("0 km")) {
            statuslabel.setText("Create Route First!");
            return;
        }
        statuslabel.setText("Route Confirmed!");
    }

    @FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/sifat7175/carrierNavigationDashboard.fxml");
    }
}