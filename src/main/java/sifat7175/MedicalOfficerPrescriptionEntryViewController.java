package sifat7175;

import NonUser.Prescription;
import com.example.airplane_carrier_project_cse213.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class MedicalOfficerPrescriptionEntryViewController {

    @FXML
    private TextField departmentTF;
    @FXML
    private TextField idTF;
    @FXML
    private DatePicker dateDatePicker;
    @FXML
    private TextArea descriptionTA;

    @FXML
    public void initialize() {
    }

    @FXML
    public void submitbuttonOAC(ActionEvent actionEvent) throws IOException {
        String id = idTF.getText();
        String dept = departmentTF.getText();
        LocalDate date = dateDatePicker.getValue();
        String desc = descriptionTA.getText();

        if (id.isEmpty() || dept.isEmpty() || date == null || desc.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please fill all fields!");
            alert.show();
            return;
        }

        Prescription p = new Prescription(id, dept, date, desc);
        File f = new File("prescriptions.bin");
        FileOutputStream fos = new FileOutputStream(f, true);
        ObjectOutputStream oos;

        if (f.length() == 0) {
            oos = new ObjectOutputStream(fos);
        } else {
            oos = new ObjectOutputStream(fos) {
                @Override
                protected void writeStreamHeader() throws IOException {
                    reset();
                }
            };
        }

        oos.writeObject(p);
        oos.close();

        idTF.clear();
        departmentTF.clear();
        dateDatePicker.setValue(null);
        descriptionTA.clear();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Prescription Saved Successfully!");
        alert.show();
    }

    @FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/sifat7175/medicalofficerDashboard.fxml");
    }
}