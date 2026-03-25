package Java.Sistema_di_sicurezza;

public class SensoreGas implements RilevatorePericolo, TrasmettitoreDati {

    @Override
    public double leggiLivello() {
        return Math.random() * 100;
    }

    @Override
    public boolean isPericolo() {
        return RilevatorePericolo.super.isPericolo();
    }

    @Override
    public void inviaDati(String messaggio) {
        if (isPericolo()) {
            System.out.println("Pericolo: " + messaggio);
        }
    }
}
