package core.entita.NPC;

import core.entita.Player.eroe;
import core.nomi.nomiGuaritore;

public class guaritore extends npc {

    public guaritore() {
        super(nomiGuaritore.getRandomNome().getNome());
    }

    public void curaEAumentoHp(eroe eroe) {
        short vitaprecedente = eroe.getHpMax();
        eroe.setHpMax((short) (eroe.getHpMax() + 20));
        eroe.setHp(eroe.getHpMax());
        System.out.println(this.getNome() + " lancia un incantesimo che ti potenzia la vita di 20 e ti cura totalmente");
        System.out.println("Hp: " + vitaprecedente + " -> " + eroe.getHpMax());
    }
}
