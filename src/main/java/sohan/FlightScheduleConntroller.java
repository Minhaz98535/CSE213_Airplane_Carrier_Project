package sohan;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import NonUser.FlightSchedule;
public class FlightScheduleConntroller {

    @FXML
    private TableColumn<?, ?> date;

    @FXML
    private TableColumn<?, ?> launchtime;

    @FXML
    private TableColumn<?, ?> flightno;

    @FXML
    private Label flightschedule;

    @FXML
    private Label noflightmassage;

    @FXML
    private TableColumn<?, ?> destination;

    @FXML
    private DatePicker flightscheduledate;

    @FXML
    private TableColumn<?, ?> status;

    @FXML
    public void initialize() {
        noflightmassage.setVisible(false);
    }

    @FXML
    public void showflightscheduleOnaction(ActionEvent actionEvent) {

        if (flightscheduledate.getValue() == null) {
            noflightmassage.setText("Please select a flight date.");
            noflightmassage.setVisible(true);
            return;
        }

        String selectedDate = flightscheduledate.getValue().toString();

        System.out.println("Selected Flight Date: " + selectedDate);

        // Ekhane selected date onujayi TableView update korbe.
    }
}