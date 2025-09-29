package core.oggetti;

import core.entita.mostri.Mostro;
import core.interfacce.Combattente;
import core.tipi.TipoOggetti;

public class Bomba extends Oggetto {
    private int danno;

    public Bomba(String nome, TipoOggetti tipoOggetto, int quantita, int valore, int danno) {
        super(nome, tipoOggetto, quantita, valore);
        this.danno = danno;
    }

    public boolean usa(Combattente bersaglio) {
        if (this.getQuantita() <= 0) {
            System.out.println("Non hai più " + this.getNome() + "!");
            return false;
        }
        int bombePrima = this.getQuantita();
        int hpBersaglioPrima = bersaglio.getHp();
        bersaglio.subisciDanno(danno);
        System.out.println(bersaglio.getNome() + " subisce " + danno + " di danno!");
        System.out.println("HP: " + hpBersaglioPrima + " -> " + bersaglio.getHp());
        if (bersaglio instanceof Mostro) {
            this.setQuantita(this.getQuantita() - 1);
            System.out.println("Bombe: " + bombePrima + " -> " + this.getQuantita());
        }
        return true;
    }
}
