package core.entita.player;

import controller.InputPort;
import core.interfacce.Combattente;
import core.oggetti.Oggetto;
import core.tipi.TipoDanno;

import java.util.*;

public class Guerriero extends Eroe {
    private short attFisico;

    public Guerriero(String nome, ArrayList<Oggetto> inventario) {
        super(nome, (short) 1, (short) 150, (short) 20, (short) 0, inventario);
        this.attFisico = 60;
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
                "Dif.F: " + difFisicaBase + "\nDif.M: " + difMagicaBase + "\n";
    }

    private Map<String, Integer> ottieniStatistiche() {
        Map<String, Integer> statistiche = new LinkedHashMap<>();
        statistiche.put("HPMax", (int) hpMax);
        statistiche.put("Dif.F", (int) difFisicaBase);
        statistiche.put("Dif.M", (int) difMagicaBase);
        statistiche.put("Atk.F", (int) attFisico);
        return statistiche;
    }

    @Override
    public boolean attacco(Combattente bersaglio, InputPort<String> input) {
        System.out.println("\nDecidi di sferrare un fendente contro il mostro con la tua ascia!");
        int danno = this.attFisico;
        int hpMostroPrima = bersaglio.getHp();
        int dannoFinale = bersaglio.difesaPassiva(danno, TipoDanno.FISICO);

        bersaglio.subisciDanno(dannoFinale);
        if (bersaglio.isDead()) {
            System.out.println("\nIncredibile! Hai sconfitto il mostro!");
            return true;
        } else {
            System.out.println("\nChe potenza! Colpisci il mostro e gli infliggi " + dannoFinale + " di danno!");
            System.out.println("Hp mostro: " + hpMostroPrima + " -> " + bersaglio.getHp());
        }
        return false;
    }

    @Override
    public void potenziamentoStatistiche() {
        Map<String, Integer> statistichePrima = ottieniStatistiche();
        this.hpMax += 30;
        this.difMagicaBase += 5;
        this.difFisicaBase += 10;
        this.attFisico += 20;
        Map<String, Integer> statisticheDopo = ottieniStatistiche();
        for (String chiave : statistichePrima.keySet()) {
            System.out.println(chiave + ": " + statistichePrima.get(chiave) + " -> " + statisticheDopo.get(chiave));
        }
    }
}
