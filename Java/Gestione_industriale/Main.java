package Java.Gestione_industriale;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        // Inizializza i registri
        RegistroSpedizioni<String> registro = new RegistroSpedizioni<>();
        RegistroSpedizioni<Date> consegne = new RegistroSpedizioni<>();

        // 1. Crea parco mezzi (ArrayList) con DroneCargo e CamionAutonomo
        ArrayList<Veicolo> parcoMezzi = new ArrayList<>();

        DroneCargo drone1 = new DroneCargo();
        drone1.targa = "DR001";
        drone1.capienzaMax = 50;
        drone1.posizione = new ModuloGPS(45.4642, 9.1900, StatoSegnale.OTTIMO);

        DroneCargo drone2 = new DroneCargo();
        drone2.targa = "DR002";
        drone2.capienzaMax = 50;
        drone2.posizione = new ModuloGPS(41.9028, 12.4964, StatoSegnale.OTTIMO);

        CamionAutonomo camion1 = new CamionAutonomo();
        camion1.targa = "CA001";
        camion1.capienzaMax = 1000;
        camion1.posizione = new ModuloGPS(45.0703, 7.6869, StatoSegnale.OTTIMO);

        CamionAutonomo camion2 = new CamionAutonomo();
        camion2.targa = "CA002";
        camion2.capienzaMax = 1000;
        camion2.posizione = new ModuloGPS(40.8518, 14.2681, StatoSegnale.OTTIMO);

        parcoMezzi.add(drone1);
        parcoMezzi.add(drone2);
        parcoMezzi.add(camion1);
        parcoMezzi.add(camion2);

        // 2. Riempi la Coda con 5 pacchi
        Queue<String> codaPacchi = new LinkedList<>();
        codaPacchi.add("Pacco #1");
        codaPacchi.add("Pacco #2");
        codaPacchi.add("Pacco #3");
        codaPacchi.add("Pacco #4");
        codaPacchi.add("Pacco #5");

        System.out.println("=== ASSEGNAZIONE PACCHI AI VEICOLI ===");
        int indiceVeicolo = 0;
        while (!codaPacchi.isEmpty()) {
            String pacco = codaPacchi.poll();
            Veicolo veicolo = parcoMezzi.get(indiceVeicolo % parcoMezzi.size());

            System.out.println("\nAssegnazione " + pacco + " al veicolo " + veicolo.targa);
            veicolo.eseguiConsegna();

            registro.aggiungiEvento("Consegna " + pacco + " con veicolo " + veicolo.targa);
            consegne.aggiungiEvento(new Date());

            indiceVeicolo++;
        }

        // 3. Simula il rientro di 3 Resi nella Pila
        Stack<String> pilaResi = new Stack<>();
        pilaResi.push("Reso #1");
        pilaResi.push("Reso #2");
        pilaResi.push("Reso #3");

        System.out.println("\n\n=== LAVORAZIONE RESI (LIFO) ===");
        while (!pilaResi.isEmpty()) {
            String reso = pilaResi.pop();
            System.out.println("Elaborazione: " + reso);
            registro.aggiungiEvento("Elaborato " + reso);
        }

        // 4. Stampa storico operazioni
        System.out.println("\n\n=== STORICO OPERAZIONI ===");
        registro.stampaStorico();

        // 5. Dimostra composizione: cambia stato GPS in ASSENTE
        System.out.println("\n\n=== DIMOSTRAZIONE COMPOSIZIONE GPS ===");
        System.out.println("Cambio stato GPS del veicolo " + drone1.targa + " in ASSENTE");
        drone1.posizione.setStatoSegnale(StatoSegnale.ASSENTE);

        System.out.println("Tentativo di consegna con GPS assente:");
        drone1.eseguiConsegna();
    }
}
