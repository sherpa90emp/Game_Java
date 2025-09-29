package core.entita.Mostri;

import controller.inputPort;
import core.interfacce.combattente;
import core.nomi.nomiGoblin;
import core.oggetti.oggetto;
import core.tipi.TipoDanno;

import java.util.ArrayList;

public class goblin extends mostro {
    private short attFisico;

    public goblin(short livello, ArrayList<oggetto> drop) {
        super(nomiGoblin.getRandomNome().getNome(), livello, (short) 60, (short) 7, (short) 0, drop);
        this.attFisico = 15;
    }

    public short getAttFisico() {
        return attFisico;
    }

    public void setAttFisico(short attFisico) {
        this.attFisico = attFisico;
    }

    @Override
    public String toString() {
        return nome + " [Lv. " + livello + "]\n" +
                "HP: " + hp + "\n" +
                "Atk.F: " + attFisico + "\n" +
                "Dif.F: " + difFisica + "\n" + "Dif.M: " + difMagica + "\n";
    }

    @Override
    public boolean attacco(combattente bersaglio, inputPort<String> input) {
        System.out.println("\n" + this.getNome() + " ti colpisce con il suo falcetto insanguinato!");
        int danno = this.attFisico;
        int hpEroePrima = bersaglio.getHp();
        int dannoFinale = bersaglio.difesaPassiva(danno, TipoDanno.FISICO);

        bersaglio.subisciDanno(dannoFinale);
        if (bersaglio.isDead()) {
            System.out.println("Incredibile! " + this.getNome() + " ti ha sconfitto!");
            return true;
        } else {
            System.out.println(this.getNome() + " ti infligge " + dannoFinale + " di danno!");
            System.out.println("Hp " + bersaglio.getNome() + ": " + hpEroePrima + " -> " + bersaglio.getHp());
        }
        return false;
    }
}

