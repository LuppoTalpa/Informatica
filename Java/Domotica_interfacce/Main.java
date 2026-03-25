package Java.Domotica_interfacce;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LampadinaSmart ls = new LampadinaSmart();
        Accendibile a = ls;
        Regolabile r = ls;

        ArrayList<Accendibile> accendibili = new ArrayList<>();

        accendibili.add(new LampadinaSemplice());
        accendibili.add(new Radio());
    }
}
