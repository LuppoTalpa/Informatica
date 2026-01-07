/**
 * Aggiungi qui una descrizione della classe Studente
 * 
 * @author Luppi
 * @version 1.0
 */
public class Studente {
    // variabili d'istanza - sostituisci l'esempio che segue con il tuo
    private String name;
    private float vote;
    private String sex;

    /**
     * Costruttore dell'oggetto Studete
     */
    public Studente(String name, float vote, String sex) {
        this.name = name;
        if (vote >= 0 && vote <= 10 && (vote * 2) % 1 == 0) {
            this.vote = vote;
        } else if (vote > 10) {
            this.vote = 10;
        } else if (vote < 0) {
            this.vote = 0;
        }
        this.sex = sex;
    }

    /**
     * Metodi getter
     */
    public String getName() {
        return name;
    }

    public float getVote() {
        return vote;
    }

    public String getSex() {
        return sex;
    }

    /**
     * Metodi setter
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setVote(float vote) {
        this.vote = vote;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}