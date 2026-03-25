package Java.Gestione_industriale;

public class DroneCargo extends Veicolo {

    private int autonomiaBatteria;

    @Override
    protected void eseguiConsegna() {
        if (!posizione.getStatoSegnale().equals(StatoSegnale.ASSENTE)) {
            System.out.printf("Consegna eseguita da %s, alle coordinate (%s;%s)%n", this.getClass().getSimpleName(), posizione.getLatitudine(), posizione.getLongitudine());
        } else {
            System.out.println("Consegna non eseguita");
        }
    }
}
