package core.entita.npc;

import core.entita.player.Eroe;
import core.nomi.NomiGuaritore;

public class Guaritore extends Npc {

    public Guaritore() {
        super(NomiGuaritore.getRandomNome().getNome());
    }

    public void curaEAumentoHp(Eroe eroe) {
        short vitaprecedente = eroe.getHpMax();
        eroe.setHpMax((short) (eroe.getHpMax() + 20));
        eroe.setHp(eroe.getHpMax());
        System.out.println(this.getNome() + " lancia un incantesimo che ti potenzia la vita di 20 e ti cura totalmente");
        System.out.println("Hp: " + vitaprecedente + " -> " + eroe.getHpMax());
    }
}
