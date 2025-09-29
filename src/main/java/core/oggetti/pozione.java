package core.oggetti;

import core.entita.Player.eroe;
import core.tipi.TipoOggetti;

public class pozione extends oggetto {
    public pozione(String nome, TipoOggetti tipoOggetto, int quantita, int valore) {
        super(nome, tipoOggetto, quantita, valore);
    }

    public boolean usa(eroe eroe) {
        if (this.getQuantita() <= 0) {
            System.out.println("Non hai più " + this.getNome() + "!");
            return false;
        }
        int hpPrima = eroe.getHp();
        int pozioniPrima = this.getQuantita();
        if (hpPrima == eroe.getHpMax()) {
            System.out.println(eroe.getNome() + " sei a piena vita!");
            return false;
        }
        eroe.setHp((short) (eroe.getHp() + 25));
        System.out.println(eroe.getNome() + " si cura di 20 HP!");
        System.out.println("HP: " + hpPrima + " -> " + eroe.getHp());
        this.setQuantita(this.getQuantita() - 1);
        System.out.println("Pozioni: " + pozioniPrima + " -> " + this.getQuantita());
        return true;
    }

}
