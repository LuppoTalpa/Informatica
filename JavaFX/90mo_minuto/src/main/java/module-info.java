module talpa._0mo_minuto {
    requires javafx.controls;
    requires javafx.fxml;
    requires jsoup;


    opens talpa._0mo_minuto to javafx.fxml;
    exports talpa._0mo_minuto;
}