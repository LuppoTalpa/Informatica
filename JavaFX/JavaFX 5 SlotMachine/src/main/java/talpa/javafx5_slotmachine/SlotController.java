package talpa.javafx5_slotmachine;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SlotController {

    private static final String BASE = "/talpa/javafx5_slotmachine/img/";

    // Nomi file immagini slot
    private final List<String> slotImages = List.of(
            "arancio.jpg", "banane.jpg", "ciliegie.jpg",
            "cocomero.jpg", "limone.jpg", "prugna.jpg", "sette.jpg"
    );

    private final ArrayList<String> storicoVincite = new ArrayList<>();
    private final Random random = new Random();

    @FXML
    private ImageView iv1;
    @FXML
    private ImageView iv2;
    @FXML
    private ImageView iv3;
    @FXML
    private ImageView ivEsito;
    @FXML
    private Label lblMessaggio;
    @FXML
    private ListView<String> lstVittorie;
    @FXML
    private Button btnGira; // Se vuoi disabilitare il bottone durante lo spin (opzionale)

    // Variabili per conservare il risultato finale mentre gira
    private int finalI1, finalI2, finalI3;

    @FXML
    public void onSpinClick() {
        // 1. Calcola GIA' ORA il risultato finale (ma non mostrarlo subito)
        finalI1 = random.nextInt(slotImages.size());
        finalI2 = random.nextInt(slotImages.size());
        finalI3 = random.nextInt(slotImages.size());

        // 2. Crea una Timeline per l'animazione dello "spin"
        // Cambierà le immagini ogni 50 millisecondi
        Timeline timeline = new Timeline();
        timeline.setCycleCount(20); // Quanti "scatti" fa l'animazione (20 * 50ms = 1 secondo di rotazione)

        // Disabilita il bottone durante lo spin per evitare doppi click
        // (Assicurati di aver aggiunto fx:id="btnGira" al bottone nel FXML se vuoi usarlo,
        // altrimenti commenta questa riga e quella alla fine)
        // btnGira.setDisable(true);

        // Definizione di cosa succede in ogni frame dell'animazione
        KeyFrame spinFrame = new KeyFrame(Duration.millis(50), event -> {
            // Mostra immagini puramente casuali durante il movimento
            iv1.setImage(caricaImmagine(slotImages.get(random.nextInt(slotImages.size()))));
            iv2.setImage(caricaImmagine(slotImages.get(random.nextInt(slotImages.size()))));
            iv3.setImage(caricaImmagine(slotImages.get(random.nextInt(slotImages.size()))));
        });

        timeline.getKeyFrames().add(spinFrame);

        // 3. Cosa fare quando l'animazione finisce
        timeline.setOnFinished(event -> {
            // Imposta le immagini FINALI vere
            iv1.setImage(caricaImmagine(slotImages.get(finalI1)));
            iv2.setImage(caricaImmagine(slotImages.get(finalI2)));
            iv3.setImage(caricaImmagine(slotImages.get(finalI3)));

            // Riabilita il bottone
            // btnGira.setDisable(false);

            // Controlla se hai vinto
            controllaVincita(finalI1, finalI2, finalI3);
        });

        // Avvia l'animazione
        lblMessaggio.setText("Spinning...");
        ivEsito.setImage(null); // Pulisci l'esito precedente
        timeline.play();
    }

    private void controllaVincita(int i1, int i2, int i3) {
        if (i1 == i2 && i2 == i3) {
            String nomeImmagine = slotImages.get(i1);
            String orario = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            storicoVincite.add("Vittoria alle " + orario);
            lstVittorie.getItems().setAll(storicoVincite);

            if (nomeImmagine.equals("sette.jpg")) {
                ivEsito.setImage(caricaImmagine("iconaSlotMachine.jpg"));
                lblMessaggio.setText("JACKPOT 777!");
            } else {
                ivEsito.setImage(caricaImmagine("vinto.jpg"));
                lblMessaggio.setText("VITTORIA!");
            }
        } else {
            ivEsito.setImage(caricaImmagine("perso.jpg"));
            lblMessaggio.setText("Ritenta!");
        }
    }

    @FXML
    public void onSalva() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Salva Statistiche");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("File di testo", "*.txt"));
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            try (PrintWriter writer = new PrintWriter(file)) {
                for (String record : storicoVincite) writer.println(record);
                mostraAlert("Info", "Salvataggio completato.");
            } catch (IOException e) {
                mostraAlert("Errore", "Impossibile salvare il file.");
            }
        }
    }

    @FXML
    public void onApri() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Apri Statistiche");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("File di testo", "*.txt"));
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            try {
                List<String> lines = Files.readAllLines(file.toPath());
                storicoVincite.clear();
                storicoVincite.addAll(lines);
                lstVittorie.getItems().setAll(storicoVincite);
                mostraAlert("Info", "Caricamento completato.");
            } catch (IOException e) {
                mostraAlert("Errore", "Impossibile leggere il file.");
            }
        }
    }

    @FXML
    public void onMostraStatistiche() {
        lstVittorie.getItems().setAll(storicoVincite);
    }

    @FXML
    public void onHelp() {
        mostraAlert("Info", "Esercizio Slot Machine JavaFX\nStudente: Alessandro Luppi");
    }

    private Image caricaImmagine(String nomeFile) {
        String path = BASE + nomeFile;
        var is = getClass().getResourceAsStream(path);
        if (is == null) return null;
        return new Image(is);
    }

    private void mostraAlert(String titolo, String contenuto) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titolo);
        alert.setHeaderText(null);
        alert.setContentText(contenuto);
        alert.showAndWait();
    }
}
