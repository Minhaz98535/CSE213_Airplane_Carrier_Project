package sifat7175;

import NonUser.PatientCase;
import com.example.airplane_carrier_project_cse213.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class MedicalOfficerViewindividualCrewHistoryViewController {

    @FXML
    private TextField nameTF;
    @FXML
    private TableView<PatientCase> medicalhistoryTableView;
    @FXML
    private TableColumn<PatientCase, LocalDate> dateTC;
    @FXML
    private TextField departmentTF;
    @FXML
    private TableColumn<PatientCase, String> diseaseTC;
    @FXML
    private TableColumn<PatientCase, String> nameTC;
    @FXML
    private TableColumn<PatientCase, String> statusTC;
    @FXML
    private TableColumn<PatientCase, String> idTC;
    @FXML
    private TableColumn<PatientCase, String> departmentTC;
    @FXML
    private TextField idTF;
    @FXML
    private TableColumn<PatientCase, Boolean> isolationTC;

    private ArrayList<PatientCase> allCases = new ArrayList<>();

    @FXML
    public void initialize() {
        diseaseTC.setCellValueFactory(new PropertyValueFactory<>("disease"));
        isolationTC.setCellValueFactory(new PropertyValueFactory<>("isolation"));
        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));
        departmentTC.setCellValueFactory(new PropertyValueFactory<>("department"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));

        loadDataFromBinFile();
        medicalhistoryTableView.getItems().addAll(allCases);
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
    public void searchOAC(ActionEvent actionEvent) {
        String searchName = nameTF.getText();
        String searchId = idTF.getText();
        String searchDept = departmentTF.getText();

        medicalhistoryTableView.getItems().clear();

        for (PatientCase pc : allCases) {
            boolean matchName = (searchName.isEmpty() || pc.getName().toLowerCase().contains(searchName.toLowerCase()));
            boolean matchId = (searchId.isEmpty() || pc.getId().equalsIgnoreCase(searchId));
            boolean matchDept = (searchDept.isEmpty() || pc.getDepartment().toLowerCase().contains(searchDept.toLowerCase()));

            if (matchName && matchId && matchDept) {
                medicalhistoryTableView.getItems().add(pc);
            }
        }
    }

    @FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent, "/com/example/airplane_carrier_project_cse213/sifat7175/medicalofficerDashboard.fxml");
    }
}