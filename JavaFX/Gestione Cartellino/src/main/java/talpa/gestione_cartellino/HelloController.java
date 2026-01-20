package talpa.gestione_cartellino;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import Gestione_cartellino.AccessControll;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class HelloController {

    private AccessControll accessControll = new AccessControll();

    @FXML
    private TextField nome;
    @FXML
    private Button ingresso;
    @FXML
    private Button uscita;
    @FXML
    private ListView<String> presenti;

    @FXML
    protected void onClickIngresso() {
        accessControll.registraIngresso(nome.getText());
        refreshPresenti();
    }

    @FXML
    protected void onClickUscita() {
        accessControll.registraUscita(nome.getText());
        refreshPresenti();
    }

    private void refreshPresenti() {
        ArrayList<String> p = accessControll.stampaPresenti();
        presenti.getItems().clear();
        p.forEach(s -> presenti.getItems().add(s));
    }
}
