package talpa._0mo_minuto;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.text.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.*;
import java.util.*;

public class HelloController {
    Messaggio m = new Messaggio();
    @FXML
    private Label welcomeText;
    @FXML
    private TextField testo;
    @FXML
    private Button tasto;


    //setto il tasto disabilitato
    //il metodo è usato per settare gli attributi all'avvio della applicazione
    public void initialize() {

    }
    //---------------------------------------------
    //Vai a fondo pagina per commenti ulteriori
    //--------------------------------------------

    @FXML
    protected void onHelloButtonClick(ActionEvent onHelloButtonClick) {

        welcomeText.setTextAlignment(TextAlignment.CENTER);
        try {
            // URL della pagina HTML online
            String url = "http://zmatteo.altervista.org/jsoup.html";

            // Recupera la pagina web online
            //scarica la pagina HTML e la converte in un oggetto Document.
            Document doc = Jsoup.connect(url).get();

            // Estrae tutti i paragrafi <p> dalla pagina
            //doc.select("p") cerca tutti gli elementi con il tag <p> e li memorizza in una lista di oggetti Elements.
            Elements paragraphs = doc.select("p");

            System.out.println("Tutti i paragrafi nella pagina:");
            //scorre tutti gli elementi p trovati e ne estre il contenuto
            for (Element p : paragraphs) {
                System.out.println(p.text());

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
//-----------------------------------------------------
/* nel file pom.xml se non viene aggiunto automaticamente,
occorre aggiornare la sezione dependency

         <dependency>
            <groupId>org.jsoup</groupId>
            <artifactId>jsoup</artifactId>
            <version>1.10.2</version>
        </dependency>

 */
//-----------------------------------------------------