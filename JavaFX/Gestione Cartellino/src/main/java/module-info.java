module talpa.gestione_cartellino {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens talpa.gestione_cartellino to javafx.fxml;
    exports talpa.gestione_cartellino;
}