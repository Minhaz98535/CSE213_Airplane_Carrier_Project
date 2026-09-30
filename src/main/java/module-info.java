module com.example.cse213_airplane_carrier_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.airplane_carrier_project_cse213 to javafx.fxml;
    exports com.example.airplane_carrier_project_cse213;
}