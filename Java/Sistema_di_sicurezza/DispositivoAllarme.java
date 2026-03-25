package Java.Sistema_di_sicurezza;

public interface DispositivoAllarme {

    void attiva();
    void disattiva();

    default void testSistema() {
        System.out.println("Esecuzione test sonoro/visivo in corso...");
    }
}
