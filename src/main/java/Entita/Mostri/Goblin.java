package Entita.Mostri;

import Interface.Combattente;
import Nomi.NomiGoblin;
import Oggetti.Oggetto;
import Tipi.TipoDanno;

import  java.util.ArrayList;
import  java.util.Scanner;

public class Goblin extends Mostro {
    private short attFisico;

    public Goblin(short livello, ArrayList<Oggetto> drop) {
        super(NomiGoblin.getRandomNome().getNome(), livello, (short) 60, (short) 7, (short) 0, drop);
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
    public boolean attacco(Combattente bersaglio, Scanner scanner) {
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

