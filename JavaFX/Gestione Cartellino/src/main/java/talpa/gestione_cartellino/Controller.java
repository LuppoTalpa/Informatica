package talpa.gestione_cartellino;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import Gestione_cartellino.AccessControll;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Controller {

    private AccessControll accessControll = new AccessControll();

    @FXML
    private TextField nome;
    @FXML
    private ListView<String> presenti;
    @FXML
    private ListView<String> log;

    @FXML
    protected void onClickIngresso() {
        refreshLog(accessControll.registraIngresso(nome.getText()));
        refreshPresenti();
    }

    @FXML
    protected void onClickUscita() {
        refreshLog(accessControll.registraUscita(nome.getText()));
        refreshPresenti();
    }

    private void refreshPresenti() {
        ArrayList<String> p = accessControll.stampaPresenti();
        presenti.getItems().clear();
        p.forEach(s -> presenti.getItems().add(s));
    }

    private void refreshLog(String s) {
        log.getItems().add(s);
    }
}
