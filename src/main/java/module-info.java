module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.fasterxml.jackson.databind;
    requires mysql.connector.java;
    exports com.example.demo.controller to javafx.fxml;

    opens com.example.demo.controller to javafx.fxml;
    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}