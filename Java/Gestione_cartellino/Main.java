package Java.Gestione_cartellino;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Inizializza il sistema di controllo accessi
        AccessControll sistema = new AccessControll();

        System.out.println("=== SISTEMA DI GESTIONE CARTELLINO ===\n");

        // 1. Registrare l'ingresso di 3 dipendenti
        System.out.println("--- Registrazione Ingressi ---");
        System.out.println(sistema.registraIngresso("Anna"));

        // Attendere qualche secondo tra un ingresso e l'altro
        try {
            Thread.sleep(2000); // Attende 2 secondi
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(sistema.registraIngresso("Luca"));

        try {
            Thread.sleep(3000); // Attende 3 secondi
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(sistema.registraIngresso("Giovanni"));

        // 2. Attendere qualche secondo prima di stampare
        try {
            Thread.sleep(2000); // Attende 2 secondi
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 3. Stampare l'elenco dei presenti
        System.out.println("\n--- Elenco Dipendenti Presenti ---");
        ArrayList<String> presenti = sistema.stampaPresenti();
        if (presenti.isEmpty()) {
            System.out.println("Nessun dipendente presente");
        } else {
            for (String dipendente : presenti) {
                System.out.println(dipendente);
            }
        }

        // 4. Registrare l'uscita di un dipendente e verificare il calcolo della durata
        System.out.println("\n--- Registrazione Uscita ---");
        String risultatoUscita = sistema.registraUscita("Luca");
        System.out.println(risultatoUscita);

        // 5. Provare a registrare un ingresso duplicato
        System.out.println("\n--- Test Ingresso Duplicato ---");
        String risultatoDuplicato = sistema.registraIngresso("Anna");
        System.out.println(risultatoDuplicato);

        // Stampa finale dei presenti
        System.out.println("\n--- Elenco Finale Presenti ---");
        presenti = sistema.stampaPresenti();
        for (String dipendente : presenti) {
            System.out.println(dipendente);
        }

        System.out.println("\n=== TEST COMPLETATO ===");
    }
}
