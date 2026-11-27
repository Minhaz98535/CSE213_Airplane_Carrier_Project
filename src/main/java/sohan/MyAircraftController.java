package sohan;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.GridPane;

public class MyAircraftController {

    @FXML
    private TableColumn<?, ?> statuscol;

    @FXML
    private GridPane grid;

    @FXML
    private TableView<?> myaircrafttabileview;

    @FXML
    private TableColumn<?, ?> assignedflightcol;

    @FXML
    private TableColumn<?, ?> modelcol;

    @FXML
    private TableColumn<?, ?> aircraftidcol;

    @FXML
    public void initialize() {

    }
}