package sohan;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import NonUser.WeatherInfo;

public class WeatherController {

    @FXML
    private Label windSpeedfxid;

    @FXML
    private Label conditionFxid;

    @FXML
    private ComboBox<String> loactionfxid;

    @FXML
    private GridPane weatherinfoshowfxid;

    @FXML
    private DatePicker datepickerdate;

    @FXML
    private Label weatherinformationcurrentlyUnavailable;

    @FXML
    private Label weatherinfofxid;

    @FXML
    private Label Visibilityfxid;

    @FXML
    private Label WindDirectionfxid;

    @FXML
    private Label temparaturefxid;

    @FXML
    public void initialize() {

        loactionfxid.getItems().setAll(
                "Dhaka",
                "Chattogram",
                "Sylhet",
                "Rajshahi",
                "Khulna"
        );

        weatherinformationcurrentlyUnavailable.setVisible(false);
    }

    @FXML
    public void ShowWeatherButton(ActionEvent actionEvent) {

        String location = loactionfxid.getValue();

        if (location == null || datepickerdate.getValue() == null) {

            weatherinformationcurrentlyUnavailable.setText(
                    "Please select location and date."
            );

            weatherinformationcurrentlyUnavailable.setVisible(true);
            return;
        }

        weatherinformationcurrentlyUnavailable.setText(
                "Weather data is currently unavailable."
        );

        weatherinformationcurrentlyUnavailable.setVisible(true);

        System.out.println("Location: " + location);
        System.out.println("Date: " + datepickerdate.getValue());
    }

    @FXML
    public void refreshWeatherbButton(ActionEvent actionEvent) {

        loactionfxid.getSelectionModel().clearSelection();
        datepickerdate.setValue(null);

        windSpeedfxid.setText("-");
        conditionFxid.setText("-");
        Visibilityfxid.setText("-");
        WindDirectionfxid.setText("-");
        temparaturefxid.setText("-");

        weatherinformationcurrentlyUnavailable.setVisible(false);
    }
}