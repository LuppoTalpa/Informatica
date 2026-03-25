package Java.Sistema_di_sicurezza;

public interface RilevatorePericolo {

    double SOGLIA_CRITICA = 75.0;

    double leggiLivello();

    default boolean isPericolo() {
        return leggiLivello() > SOGLIA_CRITICA;
    }
}
