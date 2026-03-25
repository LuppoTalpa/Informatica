package Java.Sistema_di_sicurezza;

public class DroneEmergenza implements TrasmettitoreDati,RilevatorePericolo,DispositivoAllarme {

    private boolean stato;

    @Override
    public boolean isPericolo() {
        return RilevatorePericolo.super.isPericolo();
    }

    @Override
    public double leggiLivello() {
        return Math.random() * 100;
    }

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
        System.out.println("Invio dati");
    }
}
