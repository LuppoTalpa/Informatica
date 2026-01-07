package Java.Gestione_sicurezza;

import java.util.HashMap;

public class NightCityControl {

    public static void main(String[] args) {
        HashMap<String, SecurityUnit> map = new HashMap<>();

        map.put("DR-001", new PatrolDrone("DR-001", "Hawk-X", 3, 45));
        map.put("TR-002", new DefenseTurret("TR-002", "Sentinel-Pro", 5, "Alpha"));
        map.put("DR-003", new PatrolDrone("DR-003", "Eagle-V2", 2, 60));

        // Ricerca Rapida: Chiamata di emergenza
        System.out.println("=== RICERCA RAPIDA - CHIAMATA DI EMERGENZA ===");
        SecurityUnit emergencyUnit = map.get("DR-001");
        if (emergencyUnit != null) {
            System.out.println(emergencyUnit);
        } else {
            System.out.println("ERROR: Unit ID not found. Breach detected!");
        }

        // Protocollo Omega: Attivazione di tutte le unità
        System.out.println("\n=== PROTOCOLLO OMEGA - ATTIVAZIONE UNITÀ ===");
        for (SecurityUnit unit : map.values()) {
            unit.attivaProtocollo();
        }
    }

}
