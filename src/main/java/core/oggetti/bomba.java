package core.oggetti;

import core.entita.Mostri.mostro;
import core.interfacce.combattente;
import core.tipi.TipoOggetti;

public class bomba extends oggetto {
    private int danno;

    public bomba(String nome, TipoOggetti tipoOggetto, int quantita, int valore, int danno) {
        super(nome, tipoOggetto, quantita, valore);
        this.danno = danno;
    }

    public boolean usa(combattente bersaglio) {
        if (this.getQuantita() <= 0) {
            System.out.println("Non hai più " + this.getNome() + "!");
            return false;
        }
        int bombePrima = this.getQuantita();
        int hpBersaglioPrima = bersaglio.getHp();
        bersaglio.subisciDanno(danno);
        System.out.println(bersaglio.getNome() + " subisce " + danno + " di danno!");
        System.out.println("HP: " + hpBersaglioPrima + " -> " + bersaglio.getHp());
        if (bersaglio instanceof mostro) {
            this.setQuantita(this.getQuantita() - 1);
            System.out.println("Bombe: " + bombePrima + " -> " + this.getQuantita());
        }
        return true;
    }
}
