package core.entita.Player;

import controller.inputPort;
import core.interfacce.combattente;
import core.oggetti.oggetto;
import core.tipi.TipoDanno;

import java.util.*;

public class mago extends eroe {
    private short attMagico;

    public mago(String nome, ArrayList<oggetto> inventario) {
        super(nome, (short) 1, (short) 100, (short) 0, (short) 20, inventario);
        this.attMagico = 60;
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
                "Atk.M: " + attMagico + "\n" +
                "Dif.F: " + difFisicaBase + "\nDif.M: " + difMagicaBase + "\n";
    }

    private Map<String, Integer> ottieniStatistiche() {
        Map<String, Integer> statistiche = new LinkedHashMap<>();
        statistiche.put("HPMax", (int) hpMax);
        statistiche.put("Dif.F", (int) difFisicaBase);
        statistiche.put("Dif.M", (int) difMagicaBase);
        statistiche.put("Atk.M", (int) attMagico);
        return statistiche;
    }

    @Override
    public boolean attacco(combattente bersaglio, inputPort<String> input) {
        System.out.println("\nDecidi di castare una palla di fuoco contro il mostro!");
        int hpMostroPrima = bersaglio.getHp();
        int danno = this.attMagico;
        int dannoFinale = bersaglio.difesaPassiva(danno, TipoDanno.MAGICO);

        bersaglio.subisciDanno(dannoFinale);
        if (bersaglio.isDead()) {
            System.out.println("\nIncredibile! Hai sconfitto il mostro!");
            return true;
        } else {
            System.out.println("\nChe maestria! Colpisci in pieno il mostro e gli infliggi " + dannoFinale + " di danno!");
            System.out.println("Hp mostro: " + hpMostroPrima + " -> " + bersaglio.getHp());
        }
        return false;
    }

    @Override
    public void potenziamentoStatistiche() {
        Map<String, Integer> statistichePrima = ottieniStatistiche();
        this.hpMax += 10;
        this.difMagicaBase += 10;
        this.difFisicaBase += 5;
        this.attMagico += 20;
        Map<String, Integer> statisticheDopo = ottieniStatistiche();
        for (String chiave : statistichePrima.keySet()) {
            System.out.println(chiave + ": " + statistichePrima.get(chiave) + " -> " + statisticheDopo.get(chiave));
        }
    }
}
