package Java.Domotica_interfacce;

public class LampadinaSemplice implements Accendibile {

    private boolean stato;

    public LampadinaSemplice() {
        this.stato = false;
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
}
