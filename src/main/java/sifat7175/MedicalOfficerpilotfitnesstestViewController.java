package sifat7175;

import NonUser.PilotFitness;
import com.example.airplane_carrier_project_cse213.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class MedicalOfficerpilotfitnesstestViewController {

    @FXML
    private TextField heartrateTF;
    @FXML
    private TextField bloodpressureTF;
    @FXML
    private DatePicker examdateDatepicker;
    @FXML
    private ComboBox<String> examstatusCMB;
    @FXML
    private TextField idTF;
    @FXML
    private TextArea descriptionTA;

    @FXML
    public void initialize() {
        examstatusCMB.getItems().addAll("Fit", "Unfit", "Pending");
    }

    @FXML
    public void submitOAC(ActionEvent actionEvent) throws IOException {
        String id = idTF.getText();
        String hr = heartrateTF.getText();
        String bp = bloodpressureTF.getText();
        String status = examstatusCMB.getValue();
        LocalDate date = examdateDatepicker.getValue();
        String desc = descriptionTA.getText();

        if (id.isEmpty() || hr.isEmpty() || bp.isEmpty() || status == null || date == null || desc.isEmpty()) {
            return;
        }

        PilotFitness pf = new PilotFitness(id, hr, bp, status, date, desc);
        File f = new File("pilot_fitness.bin");
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

        oos.writeObject(pf);
        oos.close();

        idTF.clear();
        heartrateTF.clear();
        bloodpressureTF.clear();
        examstatusCMB.setValue(null);
        examdateDatepicker.setValue(null);
        descriptionTA.clear();
    }

    @FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/sifat7175/medicalofficerDashboard.fxml");
    }
}