package Java.Gestione_sicurezza;

public class PatrolDrone extends SecurityUnit {

    private int autonomiaVolo;

    public PatrolDrone(String codiceSeriale, String modello, int livelloAllerta, int autonomiaVolo) {
        super(codiceSeriale, modello, livelloAllerta);
        this.autonomiaVolo = autonomiaVolo;
    }

    @Override
    void attivaProtocollo() {
        System.out.printf("Drone %s in volo. Scansione biometrica in corso. Autonomia residua %d min\n", modello, autonomiaVolo);
    }

}
