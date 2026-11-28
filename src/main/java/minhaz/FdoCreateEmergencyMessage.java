package minhaz;

import NonUser.Message;
import User.User;
import com.example.airplane_carrier_project_cse213.AppendableObjectOutputStream;
import com.example.airplane_carrier_project_cse213.Helper;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class FdoCreateEmergencyMessage
{
    @javafx.fxml.FXML
    private Button backToDashboardButton;
    @javafx.fxml.FXML
    private ComboBox<String> urgencyLevelComboBox;
    @javafx.fxml.FXML
    private TextArea messageContentTextArea;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private Button sendButton;

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
        urgencyLevelComboBox.getItems().addAll("Emergency", "Non-Urgent");
    }

    @javafx.fxml.FXML
    public void sendButtonOnAction(ActionEvent actionEvent) throws IOException {

        String messageContent = messageContentTextArea.getText();
        String urgencyLevel = urgencyLevelComboBox.getValue();
        LocalDate sendingDate = LocalDate.now();

        Message m = new Message(
                "Flight Deck Officer", messageContent, urgencyLevel, "Received", sendingDate
        );
        writeToBin("messages.bin", m);
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("Message Sent");
        a.showAndWait();
        statusLabel.setText("Sent");
        messageContentTextArea.clear();

    }

    @javafx.fxml.FXML
    public void backToDashboardButtonOnAction(ActionEvent actionEvent) throws IOException {
        Helper.sceneSwitcher(actionEvent,"/com/example/airplane_carrier_project_cse213/minhaz/flight-deck-officer-dashboard.fxml");

    }
}