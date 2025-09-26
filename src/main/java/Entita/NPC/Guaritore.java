package Entita.NPC;

import  Entita.Player.Eroe;
import Nomi.NomiGuaritore;

public class Guaritore extends NPC {

    public Guaritore() {
        super(NomiGuaritore.getRandomNome().getNome());
    }

    public void curaEAumentoHp(Eroe eroe) {
        short vitaprecedente = eroe.getHpMax();
        eroe.setHpMax((short) (eroe.getHpMax() + 20));
        eroe.setHp(eroe.getHpMax());
        System.out.println(this.getNome() + " lancia un incantesimo che ti potenzia la vita di 20 e ti cura totalmente");
        System.out.println("Hp: "+ vitaprecedente + " -> " + eroe.getHpMax());
    }
}
