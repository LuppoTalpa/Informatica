package Java.Gestione_industriale;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class CentraleOperativa {

    private ArrayList<Veicolo> veicoli;
    private LinkedList<String> pacchi;
    private Stack<String> resi;

    public CentraleOperativa() {
        veicoli = new ArrayList<>();
        pacchi = new LinkedList<>();
        resi = new Stack<>();
    }

    public void aggiungiVeicolo(Veicolo v) {
        veicoli.add(v);
    }

    public void aggiungiPacco(String pacco) {
        pacchi.add(pacco);
    }

    public void aggiungiReso(String reso) {
        resi.push(reso);
    }

    public void consegnaPacco(String pacco) {
        pacchi.remove(pacco);
    }

    public void consegnaReso(String reso) {
        resi.pop();
    }

    public void stampaReport() {
        System.out.println("REPORT CENTRALE OPERATIVA");
        System.out.println("Veicoli: " + veicoli.size());
        System.out.println("Pacchi: " + pacchi.size());
        System.out.println("Resi: " + resi.size());
    }
}
