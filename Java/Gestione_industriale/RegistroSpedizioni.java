package Java.Gestione_industriale;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class RegistroSpedizioni<T> {

    private ArrayList<T> eventi;

    public RegistroSpedizioni() {
        this.eventi = new ArrayList<>();
    }

    public void aggiungiEvento(T e) {
        eventi.add(e);
    }

    public T ottieniUltimo() {
        if (eventi.isEmpty()) {
            throw new NoSuchElementException("Il registro è vuoto.");
        }
        return eventi.getLast();
    }

    public void stampaStorico() {
        for (T e : eventi) {
            System.out.println(e);
        }
    }
}
