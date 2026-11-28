package minhaz;

import NonUser.Aircraft;
import com.example.airplane_carrier_project_cse213.AppendableObjectOutputStream;
import com.example.airplane_carrier_project_cse213.Helper;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MloLogAircraftIntoSystemViewController
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private Button logAircraftButton;
    @javafx.fxml.FXML
    private ComboBox<String> typeComboBox;
    @javafx.fxml.FXML
    private Button backToDashboardButton;
    @javafx.fxml.FXML
    private TextField nameTextField;

    public void writeToBin(String binFile, Object u) throws IOException {
        File f;
        FileOutputStream fos;
        ObjectOutputStream oos;
        f = new File(binFile);
        if(f.exists()){
            fos = new FileOutputStream(f, true);
            oos = new AppendableObjectOutputStream(fos);
        }
        else{
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
        }
        oos.writeObject(u);
        oos.close();
    }

    @javafx.fxml.FXML
    public void initialize() {
        typeComboBox.getItems().addAll("Fighter", "Transport", "Helicopter", "Anti-Submarine", "Multirole");
    }

    @javafx.fxml.FXML
    public void logAircraftButtonOnAction(ActionEvent actionEvent) throws IOException {
        int id = Integer.parseInt(idTextField.getText());
        String name = nameTextField.getText();
        String type = typeComboBox.getValue();

        Aircraft a = new Aircraft(
                id, name, type, "Undecided"
        );
        writeToBin("aircraft.bin", a);
        Alert s = new Alert(Alert.AlertType.CONFIRMATION);
        s.setContentText("Aircraft Logged into System!");
        s.showAndWait();

    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent,"/com/example/airplane_carrier_project_cse213/minhaz/maintenance-logistics-officer-dashboard-view.fxml");
    }
}