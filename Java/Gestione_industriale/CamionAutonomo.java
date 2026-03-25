package Java.Gestione_industriale;

public class CamionAutonomo extends Veicolo {

    private int numeroAssi;

    @Override
    protected void eseguiConsegna() {
        if (!posizione.getStatoSegnale().equals(StatoSegnale.ASSENTE)) {
            System.out.printf("Consegna eseguita da %s%n", this.getClass().getSimpleName());;
        } else {
            System.out.println("Consegna non eseguita");
        }
    }
}
