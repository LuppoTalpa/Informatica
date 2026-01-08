package talpa.javafx5_slotmachine;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

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

    // Lista per memorizzare le vincite in memoria
    private final ArrayList<String> storicoVincite = new ArrayList<>();
    private final Random random = new Random();

    @FXML
    private ImageView iv1;
    @FXML
    private ImageView iv2;
    @FXML
    private ImageView iv3;
    @FXML
    private ImageView ivEsito; // Immagine sotto al bottone
    @FXML
    private Label lblMessaggio;
    @FXML
    private ListView<String> lstVittorie;

    @FXML
    public void onSpinClick() {
        // Genera 3 indici casuali
        int i1 = random.nextInt(slotImages.size());
        int i2 = random.nextInt(slotImages.size());
        int i3 = random.nextInt(slotImages.size());

        // Imposta le immagini nei rulli
        iv1.setImage(caricaImmagine(slotImages.get(i1)));
        iv2.setImage(caricaImmagine(slotImages.get(i2)));
        iv3.setImage(caricaImmagine(slotImages.get(i3)));

        controllaVincita(i1, i2, i3);
    }

    private void controllaVincita(int i1, int i2, int i3) {
        // Logica PDF: Se le immagini sono tutte e tre uguali
        if (i1 == i2 && i2 == i3) {
            String nomeImmagine = slotImages.get(i1);

            // Registra l'ora della vincita
            String orario = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            storicoVincite.add("Vittoria alle " + orario);

            // Aggiorna subito la lista se visibile (opzionale, ma utile)
            lstVittorie.getItems().setAll(storicoVincite);

            if (nomeImmagine.equals("sette.jpg")) {
                // Caso: tre 7 -> Immagine della slot machine
                ivEsito.setImage(caricaImmagine("iconaSlotMachine.jpg"));
                lblMessaggio.setText("JACKPOT 777!");
            } else {
                // Caso: tre uguali (non 7) -> Faccina sorridente
                ivEsito.setImage(caricaImmagine("vinto.jpg"));
                lblMessaggio.setText("VITTORIA!");
            }
        } else {
            // Caso: non si vince -> Faccina triste
            ivEsito.setImage(caricaImmagine("perso.jpg"));
            lblMessaggio.setText("Ritenta!");
        }
    }

    // --- Gestione Menu ---

    @FXML
    public void onSalva() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Salva Statistiche Vincite");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("File di testo", "*.txt"));
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            try (PrintWriter writer = new PrintWriter(file)) {
                for (String record : storicoVincite) {
                    writer.println(record);
                }
                mostraAlert("Salvataggio completato", "Vittorie salvate correttamente.");
            } catch (IOException e) {
                mostraAlert("Errore", "Impossibile salvare il file.");
            }
        }
    }

    @FXML
    public void onApri() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Apri Statistiche Vincite");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("File di testo", "*.txt"));
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            try {
                List<String> lines = Files.readAllLines(file.toPath());
                storicoVincite.clear();
                storicoVincite.addAll(lines);
                // Aggiorna la lista a video se necessario
                lstVittorie.getItems().setAll(storicoVincite);
                mostraAlert("Caricamento completato", "Vittorie caricate: " + lines.size());
            } catch (IOException e) {
                mostraAlert("Errore", "Impossibile leggere il file.");
            }
        }
    }

    @FXML
    public void onMostraStatistiche() {
        // Il PDF dice "Statistiche -> Mostra: visualizza nella ListBox le vittorie"
        // Qui aggiorniamo semplicemente la view con i dati attuali
        lstVittorie.getItems().setAll(storicoVincite);
    }

    @FXML
    public void onHelp() {
        mostraAlert("Info Studente", "Nome: Alessandro Luppi\nClasse: 4B IA\nEsercizio Slot Machine JavaFX");
    }

    // --- Metodi di utilità ---

    private Image caricaImmagine(String nomeFile) {
        // Nota: Assicurati di avere anche smile.jpg, sad.jpg, slot_machine.jpg nella cartella img
        // Se non le hai, il codice lancerà eccezione.
        // Per testare senza file, puoi commentare il throw e restituire null (ma non vedrai nulla).
        String path = BASE + nomeFile;
        var is = getClass().getResourceAsStream(path);
        if (is == null) {
            // Fallback per evitare crash se mancano le immagini extra
            System.err.println("Immagine mancante: " + path);
            return null;
        }
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
