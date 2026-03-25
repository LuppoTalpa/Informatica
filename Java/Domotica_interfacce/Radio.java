package Java.Domotica_interfacce;

public class Radio implements Accendibile,Regolabile {

    private boolean stato;
    private int volume;

    public Radio() {
        this.stato = false;
        this.volume = 50;
    }

    @Override
    public void accendi() {
        stato = true;
        System.out.println("Radio accesa");
    }

    @Override
    public void spegni() {
        stato = false;
        System.out.println("Radio spenta");
    }

    @Override
    public void impostaLivello(int livello) {
        volume = livello;
        System.out.printf("Volume impostato al %d%%", volume);
    }
}
