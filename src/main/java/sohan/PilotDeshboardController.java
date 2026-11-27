
package sohan;

import User.pilot;
import User.pilot;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class PilotDeshboardController {

    @FXML
    private Label pilotnamefxid;

    @FXML
    private StackPane Fxmlgoalload;

    @FXML
    private Label pilotdeshboardlebel;

    @FXML
    public void initialize() {
        pilotdeshboardlebel.setText("Pilot Dashboard");
    }

    // Connect Pilot Model
    public void setPilot(pilot pilot) {
        if (pilot != null) {
            pilotnamefxid.setText(pilot.getName());
        }
    }

    @FXML
    public void weatherinfobutton(ActionEvent actionEvent) {
        System.out.println("Weather Information clicked");
    }

    @FXML
    public void myaircraftbutton(ActionEvent actionEvent) {
        System.out.println("My Aircraft clicked");
    }

    @FXML
    public void preFlightChecklistButton(ActionEvent actionEvent) {
        System.out.println("Pre-Flight Checklist clicked");
    }

    @FXML
    public void reportissuebutton(ActionEvent actionEvent) {
        System.out.println("Report Issue clicked");
    }

    @FXML
    public void logoutButton(ActionEvent actionEvent) {
        System.out.println("Logout clicked");
    }

    @FXML
    public void submitreportbutton(ActionEvent actionEvent) {
        System.out.println("Submit Report clicked");
    }

    @FXML
    public void flightScheduleButton(ActionEvent actionEvent) {
        System.out.println("Flight Schedule clicked");
    }
}
