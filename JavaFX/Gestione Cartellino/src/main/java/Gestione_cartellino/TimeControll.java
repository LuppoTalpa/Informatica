package Gestione_cartellino;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeControll {

    public static LocalDateTime ingresso() {
        return LocalDateTime.now();
    }

    public static String uscita(String name, LocalDateTime ingresso) {
        Duration d = Duration.between(ingresso, LocalDateTime.of(2026, 1, 20, 18, 30));
        return name + " è uscito. Tempo totale: " + d.toHoursPart() + "h " + d.toMinutesPart() + "m";
    }

    public static String info(LocalDateTime ingresso) {
        return ingresso.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    public static boolean ingressoAnticipato(LocalDateTime ingresso, LocalDateTime apertura) {
        return ingresso.isBefore(apertura);
    }

}
