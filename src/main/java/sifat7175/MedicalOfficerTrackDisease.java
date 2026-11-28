package sifat7175;

import NonUser.PatientCase;
import com.example.airplane_carrier_project_cse213.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class MedicalOfficerTrackDisease {

    @FXML
    private TableColumn<PatientCase, String> diseaseTC;
    @FXML
    private ComboBox<String> statusCCMB;
    @FXML
    private TableColumn<PatientCase, String> departmentTC;
    @FXML
    private ComboBox<String> departmentCMB;
    @FXML
    private TableView<PatientCase> diseasetracking;
    @FXML
    private TableColumn<PatientCase, String> patientTC;
    @FXML
    private TableColumn<PatientCase, LocalDate> onsetdateTC;
    @FXML
    private TableColumn<PatientCase, String> caseidTC;
    @FXML
    private TableColumn<PatientCase, String> statusTC;
    @FXML
    private ComboBox<String> diseaseCMB;
    @FXML
    private TableColumn<PatientCase, Boolean> isolationTC;
    @FXML
    private DatePicker dateDatePicker;

    private ArrayList<PatientCase> allCases = new ArrayList<>();

    @FXML
    public void initialize() {
        caseidTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        patientTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        departmentTC.setCellValueFactory(new PropertyValueFactory<>("department"));
        diseaseTC.setCellValueFactory(new PropertyValueFactory<>("disease"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));
        isolationTC.setCellValueFactory(new PropertyValueFactory<>("isolation"));
        onsetdateTC.setCellValueFactory(new PropertyValueFactory<>("date"));

        loadDataFromBinFile();

        diseaseCMB.getItems().add("All");
        statusCCMB.getItems().add("All");
        departmentCMB.getItems().add("All");

        for (PatientCase pc : allCases) {
            if (!diseaseCMB.getItems().contains(pc.getDisease())) {
                diseaseCMB.getItems().add(pc.getDisease());
            }
            if (!statusCCMB.getItems().contains(pc.getStatus())) {
                statusCCMB.getItems().add(pc.getStatus());
            }
            if (!departmentCMB.getItems().contains(pc.getDepartment())) {
                departmentCMB.getItems().add(pc.getDepartment());
            }
        }

        diseasetracking.getItems().addAll(allCases);
    }

    private void loadDataFromBinFile() {
        File f = new File("patient_cases.bin");
        if (!f.exists()) {
            return;
        }

        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
                try {
                    PatientCase pc = (PatientCase) ois.readObject();
                    allCases.add(pc);
                } catch (EOFException e) {
                    break;
                }
            }
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void enterbuttonOAC(ActionEvent actionEvent) {
        String selectedDisease = diseaseCMB.getValue();
        String selectedStatus = statusCCMB.getValue();
        String selectedDept = departmentCMB.getValue();
        LocalDate selectedDate = dateDatePicker.getValue();

        diseasetracking.getItems().clear();

        for (PatientCase pc : allCases) {
            boolean matchDisease = (selectedDisease == null || selectedDisease.equals("All") || pc.getDisease().equalsIgnoreCase(selectedDisease));
            boolean matchStatus = (selectedStatus == null || selectedStatus.equals("All") || pc.getStatus().equalsIgnoreCase(selectedStatus));
            boolean matchDept = (selectedDept == null || selectedDept.equals("All") || pc.getDepartment().equalsIgnoreCase(selectedDept));
            boolean matchDate = (selectedDate == null || pc.getDate().equals(selectedDate));

            if (matchDisease && matchStatus && matchDept && matchDate) {
                diseasetracking.getItems().add(pc);
            }
        }
    }

    @FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/sifat7175/medicalofficerDashboard.fxml");
    }
}