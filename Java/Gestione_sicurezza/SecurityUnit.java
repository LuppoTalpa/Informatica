package Java.Gestione_sicurezza;

public abstract class SecurityUnit {

    protected String codiceSeriale;
    protected String modello;
    protected int livelloAllerta;

    public SecurityUnit(String codiceSeriale, String modello, int livelloAllerta) {
        this.codiceSeriale = codiceSeriale;
        this.modello = modello;
        this.livelloAllerta = livelloAllerta;
    }

    abstract void attivaProtocollo();

    @Override
    public String toString() {
        return String.format("Codice seriale: %s, Modello: %s, Livello allerta: %d", codiceSeriale, modello, livelloAllerta);
    }

}
