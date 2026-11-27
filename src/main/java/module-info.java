module com.example.cse213_airplane_carrier_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens NonUser to javafx.base;
    opens User to javafx.base;
    opens swapnil to javafx.fxml;
    opens minhaz to javafx.fxml;

    opens com.example.airplane_carrier_project_cse213 to javafx.fxml;
    exports com.example.airplane_carrier_project_cse213;
}