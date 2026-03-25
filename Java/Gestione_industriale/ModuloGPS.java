package Java.Gestione_industriale;

public class ModuloGPS {

    private double latitudine;
    private double longitudine;
    private StatoSegnale statoSegnale;

    public ModuloGPS(double latitudine, double longitudine, StatoSegnale statoSegnale) {
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        this.statoSegnale = statoSegnale;
    }

    public StatoSegnale getStatoSegnale() {
        return statoSegnale;
    }

    public double getLatitudine() {
        return latitudine;
    }

    public double getLongitudine() {
        return longitudine;
    }

    public void setStatoSegnale(StatoSegnale statoSegnale) {
        this.statoSegnale = statoSegnale;
    }
}
