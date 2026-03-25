package Java.Sistema_di_sicurezza;

public class SirenaIntelligente implements DispositivoAllarme, TrasmettitoreDati {

    private boolean stato;

    @Override
    public void attiva() {
        this.stato = true;
    }

    @Override
    public void disattiva() {
        this.stato = false;
    }

    @Override
    public void inviaDati(String messaggio) {
        System.out.println("Manomissione in corso");
    }
}
