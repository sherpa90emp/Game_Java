package core.oggetti;

import core.tipi.TipoOggetti;

public class Oggetto {
    private String nome;
    private TipoOggetti tipoOggetto;
    private int quantita;
    private int valore;

    public Oggetto(String nome, TipoOggetti tipoOggetto, int quantita, int valore) {
        this.nome = nome;
        this.tipoOggetto = tipoOggetto;
        this.quantita = quantita;
        this.valore = valore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoOggetti getTipoOggetto() {
        return tipoOggetto;
    }

    public void setTipoOggetto(TipoOggetti tipoOggetto) {
        this.tipoOggetto = tipoOggetto;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    @Override
    public String toString() {
        String base = tipoOggetto + ": " + nome + " " + quantita;
        if (tipoOggetto != TipoOggetti.VALUTA) {
            base += ", valore: " + valore + " Corone di Valdor";
        }
        return base;
    }
}
