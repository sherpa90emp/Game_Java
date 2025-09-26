package Entita.Mostri;

import Interface.Combattente;
import Nomi.NomiOrco;
import Oggetti.Oggetto;
import Tipi.TipoDanno;

import  java.util.ArrayList;
import  java.util.Scanner;

public class Orco extends Mostro {
    private short attFisico;

    public Orco(short livello, ArrayList<Oggetto> drop) {
        super(NomiOrco.getRandomNome().getNome(), livello, (short) 90, (short) 12, (short) 0, drop);
        this.attFisico = 30;
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
        System.out.println("\n" + this.getNome() + " ti colpisce con la sua mazza chiodata!");
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
