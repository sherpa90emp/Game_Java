package core.entita.NPC;

import core.entita.Player.elfo;
import core.entita.Player.eroe;
import core.entita.Player.guerriero;
import core.entita.Player.mago;
import core.nomi.nomiFabbro;

public class fabbro extends npc {

    public fabbro() {
        super(nomiFabbro.getRandomNome().getNome());
    }

    public void potenziamentoDifAtt(eroe eroe) {
        short difMagicaPrecedente = eroe.getDifMagicaBase();
        short difFisicaPrecedente = eroe.getDifFisicaBase();
        System.out.println("Il mastro fabbro " + this.getNome() + ", migliorando il tuo vestiario e le tue armi, ti potenzia attacco e difesa!\n");
        eroe.setDifMagicaBase((short) (eroe.getDifMagicaBase() + 10));
        eroe.setDifFisicaBase((short) (eroe.getDifFisicaBase() + 10));
        if (eroe instanceof guerriero guerriero) {
            short attFisicoPrecedente = guerriero.getAttFisico();
            guerriero.setAttFisico((short) (guerriero.getAttFisico() + 10));
            System.out.println("Dif.F: " + difFisicaPrecedente + " -> " + guerriero.getDifFisicaBase());
            System.out.println("Dif.M: " + difMagicaPrecedente + " -> " + guerriero.getDifMagicaBase());
            System.out.println("Att.F: " + attFisicoPrecedente + " -> " + guerriero.getAttFisico());
        }
        if (eroe instanceof elfo elfo) {
            short attFisicoPrecedente = elfo.getAttFisico();
            short attMagicoPrecedente = elfo.getAttMagico();
            elfo.setAttFisico((short) (elfo.getAttFisico() + 5));
            elfo.setAttMagico((short) (elfo.getAttMagico() + 5));
            System.out.println("Dif.F: " + difFisicaPrecedente + " -> " + elfo.getDifFisicaBase());
            System.out.println("Dif.M: " + difMagicaPrecedente + " -> " + elfo.getDifMagicaBase());
            System.out.println("Att.F: " + attFisicoPrecedente + " -> " + elfo.getAttFisico());
            System.out.println("Att.M: " + attMagicoPrecedente + " -> " + elfo.getAttMagico());
        }
        if (eroe instanceof mago mago) {
            short attMagicoPrecedente = mago.getAttMagico();
            mago.setAttMagico((short) (mago.getAttMagico() + 10));
            System.out.println("Dif.F: " + difFisicaPrecedente + " -> " + mago.getDifFisicaBase());
            System.out.println("Dif.M: " + difMagicaPrecedente + " -> " + mago.getDifMagicaBase());
            System.out.println("Att.M: " + attMagicoPrecedente + " -> " + mago.getAttMagico());
        }
        System.out.println("\n" + eroe);
    }
}
