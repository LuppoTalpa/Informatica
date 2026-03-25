package Java.Gestione_industriale;

public abstract class Veicolo {

    protected String targa;
    protected int capienzaMax;
    protected ModuloGPS posizione;

    protected abstract void eseguiConsegna();

}
