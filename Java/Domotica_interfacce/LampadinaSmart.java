package Java.Domotica_interfacce;

public class LampadinaSmart implements Accendibile, Regolabile {

    private boolean stato;
    private int livello;

    public LampadinaSmart() {
        this.stato = false;
        this.livello = 100;
    }

    @Override
    public void accendi() {
        this.stato = true;
        System.out.println("lampadina accesa");
    }

    @Override
    public void spegni() {
        this.stato = false;
        System.out.println("lampadina spenta");
    }

    @Override
    public void impostaLivello(int livello) {
        this.livello = livello;
        System.out.printf("Luminosità impostata al %d%%", livello);
    }
}
