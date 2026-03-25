package Java.Sistema_di_sicurezza;

public class Main {
    public static void main(String[] args) {
        System.out.println(RilevatorePericolo.SOGLIA_CRITICA);
        System.out.println(TrasmettitoreDati.PROTOCOLLO);

        SirenaIntelligente si = new SirenaIntelligente();
        si.testSistema();
    }

    public static boolean gestisciEmergenza(RilevatorePericolo r) {
        if (r.isPericolo()) {
            System.out.println("Allarme rilevato!");
            if (r instanceof DispositivoAllarme) {
                ((DispositivoAllarme) r).attiva();
            }
            return true;
        } else {
            return false;
        }
    }
}
