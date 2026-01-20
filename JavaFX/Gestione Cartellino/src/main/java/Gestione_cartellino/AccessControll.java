package Gestione_cartellino;

import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDateTime;

public class AccessControll {

    private HashMap<String, LocalDateTime> presenti;

    public AccessControll() {
        presenti = new HashMap<>();
    }

    /**
     * Registra ingresso
     * @param nome Nome dipendente
     * @return <code>String</code> con lo stato dell operazione di registrazione
     */
    public String registraIngresso(String nome) {
        if (presenti.containsKey(nome)) {
            return "Dipendente gia al lavoro";
        }
        presenti.put(nome, TimeControll.ingresso());
        return "Ingresso registrato per " + nome;
    }

    /**
     * Registra uscita
     * @param nome Nome dipendente
     * @return <code>String</code> con lo stato dell operazione di uscita
     */
    public String registraUscita(String nome) {
        if (!presenti.containsKey(nome)) {
            return "Dipendente non al lavoro";
        }
        String out = TimeControll.uscita(nome, presenti.get(nome));
        presenti.remove(nome);
        return out;
    }

    /**
     * Stampa presenti
     * @return <code>ArrayList</code> di stringhe con i dipendenti e l'orario di ingresso
     */
    public ArrayList<String> stampaPresenti() {
        ArrayList<String> out = new ArrayList<>();
        for (String nome : presenti.keySet()) {
            out.add(nome + ": " + TimeControll.info(presenti.get(nome)));
        }
        return out;
    }

    /**
     * Stampa i presenti prima dell'orario
     * @param orario Orario di filtro
     * @return <code>ArrayList</code> di stringhe con i dipendenti che hanno effettuato l'ingresso prima dell'orario di ingresso specificato
     */
    public ArrayList<String> filtraPerOrario(LocalDateTime orario) {
        ArrayList<String> out = new ArrayList<>();
        for (String nome : presenti.keySet()) {
            if (TimeControll.ingressoAnticipato(presenti.get(nome), orario)) {
                out.add(nome);
            }
        }
        return out;
    }

}
