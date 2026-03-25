package Java.Controllo_traffico_interfacce;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        AereoDiLinea boeing747 = new AereoDiLinea();
        DroneSorveglianza dji = new DroneSorveglianza();
        AutobusPasseggeri bus = new AutobusPasseggeri();

        TorreDiControllo tdc = new TorreDiControllo();

        ArrayList<Volante> volanti = new ArrayList<>();

        volanti.add(boeing747);
        volanti.add(dji);

        for (Volante v : volanti) {
            tdc.gestisciDecollo(v);
        }
    }
}
