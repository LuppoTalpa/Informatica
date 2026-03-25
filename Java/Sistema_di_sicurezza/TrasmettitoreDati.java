package Java.Sistema_di_sicurezza;

public interface TrasmettitoreDati {

    String PROTOCOLLO = "MQTT";

    void inviaDati(String messaggio);
}
