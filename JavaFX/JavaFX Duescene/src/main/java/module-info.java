module com.example.javafxduescene {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxduescene to javafx.fxml;
    exports com.example.javafxduescene;
}