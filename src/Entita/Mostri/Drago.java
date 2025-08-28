package Entita.Mostri;

import Entita.Player.Eroe;
import Interface.Combattente;
import Nomi.NomiDrago;
import Oggetti.Oggetto;
import Tipi.TipoDanno;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Drago extends Mostro {

    private short attFisico;
    private short attMagico;

    public Drago(short livello, ArrayList<Oggetto> drop) {
        super(NomiDrago.getRandomNome().getNome(), livello, (short) 200, (short) 50, (short) 50, drop);
        this.attFisico = 50;
        this.attMagico = 70;
    }

    public short getAttFisico() {
        return attFisico;
    }

    public void setAttFisico(short attFisico) {
        this.attFisico = attFisico;
    }

    public short getAttMagico() {
        return attMagico;
    }

    public void setAttMagico(short attMagico) {
        this.attMagico = attMagico;
    }

    @Override
    public String toString() {
        return nome + " [Lv. " + livello + "]\n" +
                "HP: " + hp + "\n" +
                "Atk.F: " + attFisico + "\n" + "Atk.M: " + attMagico + "\n" +
                "Dif.F: " + difFisica + "\n" + "Dif.M: " + difMagica + "\n";
    }

    @Override
    public boolean attacco(Combattente bersaglio, Scanner scanner) {
        Random random = new Random();
        int hpEroePrima = bersaglio.getHp();

        int attaccoRandom = random.nextInt(2) + 1;
        switch (attaccoRandom) {
            case 1 -> {
                System.out.println("\n" + this.getNome() + " emette un potente soffio elementale!");
                int danno = this.attMagico;
                int dannoFinale = bersaglio.difesaPassiva(danno, TipoDanno.MAGICO);
                bersaglio.subisciDanno(dannoFinale);
                if (bersaglio.isDead()) {
                    System.out.println("Incredibile! " + this.getNome() + " ti ha sconfitto!");
                    return true;
                } else {
                    System.out.println(this.getNome() + " ti infligge " + dannoFinale + " di danno!");
                    System.out.println("Hp " + bersaglio.getNome() + ": " + hpEroePrima + " -> " + bersaglio.getHp());
                }
            }
            case 2 -> {
                System.out.println("\n" + this.getNome() + " scaglia una zampata contro di te!");
                int danno = this.attFisico;
                int dannoFinale = bersaglio.difesaPassiva(danno, TipoDanno.FISICO);
                bersaglio.subisciDanno(dannoFinale);
                if (bersaglio.isDead()) {
                    System.out.println("Incredibile! " + this.getNome() + " ti ha sconfitto!");
                    return true;
                } else {
                    System.out.println(this.getNome() + " ti infligge " + dannoFinale + " di danno!");
                    System.out.println("Hp " + bersaglio.getNome() + ": " + hpEroePrima + " -> " + bersaglio.getHp());
                }
            }
        }
        return false;
    }
}
