package Java.Controllo_traffico_interfacce;

public class AereoDiLinea implements Volante, Guidabile {

    private boolean inFly;
    private Posizione state;

    public AereoDiLinea() {
        this.inFly = false;
        this.state = Posizione.PISTA;
    }

    @Override
    public void decolla() {
        this.inFly = true;
    }

    @Override
    public void atterra() {
        this.inFly = false;
    }

    @Override
    public void muoviSuPista() {
        if (state == Posizione.PISTA)
            this.state = Posizione.TOGATE;
        else if (state == Posizione.GATE) {
            this.state = Posizione.TOPISTA;
        }
    }

    @Override
    public void arresta() {
        if (state == Posizione.TOGATE)
            this.state = Posizione.GATE;
        else if (state == Posizione.TOPISTA) {
            this.state = Posizione.PISTA;
        }
    }
}
