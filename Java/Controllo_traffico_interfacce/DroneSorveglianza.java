package Java.Controllo_traffico_interfacce;

public class DroneSorveglianza implements Volante, Monitorabile {

    private int batteria;
    private boolean inFly;

    public DroneSorveglianza() {
        this.batteria = 100;
        this.inFly = false;
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
    public String inviaCoordinate() {
        return "Coordinatene";
    }

    @Override
    public int getLivelloBatteria() {
        return batteria;
    }
}
