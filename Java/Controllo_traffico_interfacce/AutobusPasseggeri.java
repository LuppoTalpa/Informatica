package Java.Controllo_traffico_interfacce;

public class AutobusPasseggeri implements Guidabile {

    private Posizione state;

    public AutobusPasseggeri() {
        this.state = Posizione.PISTA;
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
