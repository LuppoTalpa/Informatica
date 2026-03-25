package Java.Controllo_traffico_interfacce;

public class TorreDiControllo {

    public void gestisciDecollo(Volante v) {
        v.decolla();
    }

    public void parcheggiaAlGate(Guidabile g) {
        g.muoviSuPista();
        g.arresta();
    }

    public void analizzaStato(Monitorabile m) {
        System.out.println(m.inviaCoordinate());
        if (m.getLivelloBatteria() < 20) {
            System.out.println("Batteria scarsa");
        }
    }
}
