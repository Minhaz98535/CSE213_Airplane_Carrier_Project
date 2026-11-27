
package sohan;

import NonUser.preFlightChecklist;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class preflightCheaklistController {

    @FXML
    private CheckBox fuellevelcheakedBox;

    @FXML
    private CheckBox landingGearCheakBox;

    @FXML
    private CheckBox enginecheakedcheakbox;

    @FXML
    private CheckBox communicationsystemcheaked;

    @FXML
    private Label preflightCheakedlistfxid;

    @FXML
    public void initialize() {
        preflightCheakedlistfxid.setText("Pre-Flight Checklist");
    }

    @FXML
    public void cancelbutton(ActionEvent actionEvent) {

        fuellevelcheakedBox.setSelected(false);
        landingGearCheakBox.setSelected(false);
        enginecheakedcheakbox.setSelected(false);
        communicationsystemcheaked.setSelected(false);

        preflightCheakedlistfxid.setText("Checklist Reset");
    }

    @FXML
    public void submitbutton(ActionEvent actionEvent) {

        boolean fuelChecked =
                fuellevelcheakedBox.isSelected();

        boolean landingGearChecked =
                landingGearCheakBox.isSelected();

        boolean engineChecked =
                enginecheakedcheakbox.isSelected();

        boolean communicationChecked =
                communicationsystemcheaked.isSelected();

        if (!fuelChecked || !landingGearChecked ||
                !engineChecked || !communicationChecked) {

            preflightCheakedlistfxid.setText(
                    "Please complete all checklist items!"
            );
            return;
        }

        preFlightChecklist checklist = new preFlightChecklist(
                fuelChecked,
                landingGearChecked,
                engineChecked,
                communicationChecked
        );

        preflightCheakedlistfxid.setText(
                "Pre-flight checklist completed!"
        );

        System.out.println(checklist);
    }
}
