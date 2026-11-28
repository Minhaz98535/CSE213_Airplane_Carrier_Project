package sifat7175;

import NonUser.PatientCase;
import com.example.airplane_carrier_project_cse213.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class MedicalOfficerNewCaseEntryforaPatientViewController {

    @FXML
    private TextField nameTF;
    @FXML
    private TextField idTF;
    @FXML
    private TextField diseaseTF;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private TextField statusTF;
    @FXML
    private TextField departmentTF;
    @FXML
    private CheckBox isolationcheckbox;
    @FXML
    private DatePicker dateDatepicker;

    @FXML
    public void initialize() {
    }

    @FXML
    public void registerbuttonOAC(ActionEvent actionEvent) throws IOException {
        String name = nameTF.getText();
        String id = idTF.getText();
        String dept = departmentTF.getText();
        String disease = diseaseTF.getText();
        String status = statusTF.getText();
        boolean isolation = isolationcheckbox.isSelected();
        LocalDate date = dateDatepicker.getValue();
        String desc = descriptionTextArea.getText();

        if (name.isEmpty() || id.isEmpty() || dept.isEmpty() || disease.isEmpty() || status.isEmpty() || date == null || desc.isEmpty()) {
            return;
        }

        PatientCase pc = new PatientCase(name, id, dept, disease, status, isolation, date, desc);
        File f = new File("patient_cases.bin");
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

        oos.writeObject(pc);
        oos.close();

        nameTF.clear();
        idTF.clear();
        departmentTF.clear();
        diseaseTF.clear();
        statusTF.clear();
        isolationcheckbox.setSelected(false);
        dateDatepicker.setValue(null);
        descriptionTextArea.clear();
    }

    @FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/sifat7175/medicalofficerDashboard.fxml");
    }
}