package core.entita;

/**
 * Classe astratta che rappresentà ogni entità del gioco.
 */
public abstract class Entita {

    /**
     * Nome dell'entità
     */
    protected String nome;

    /**
     * Costruttore per creare una entità con un nome specifico.
     * @param nome il nome dell'entità
     */
    public Entita(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce il nome dell'entità.
     * @return il nome corrente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Modifica il nome del'entità.
     * @param nome il nuovo nome da assegnare
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
