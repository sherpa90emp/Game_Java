package Entita.Player;


import Interface.Combattente;
import Oggetti.Oggetto;
import Tipi.TipoDanno;

import java.util.*;

public class Elfo extends Eroe {
    private short attFisico;
    private short attMagico;

    public Elfo(String nome, ArrayList<Oggetto> inventario) {
        super(nome, (short) 1, (short) 125, (short) 10, (short) 10, inventario);
        this.attFisico = 40;
        this.attMagico = 40;
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
                "Dif.F: " + difFisicaBase + "\nDif.M: " + difMagicaBase + "\n";
    }

    private Map<String, Integer> ottieniStatistiche() {
        Map<String, Integer> statistiche = new LinkedHashMap<>();
        statistiche.put("HPMax", (int)hpMax);
        statistiche.put("Dif.F", (int)difFisicaBase);
        statistiche.put("Dif.M", (int)difMagicaBase);
        statistiche.put("Atk.F", (int)attFisico);
        statistiche.put("Atk.M", (int)attMagico);
        return statistiche;
    }

    @Override
    public boolean attacco(Combattente bersaglio, Scanner scanner) {
        System.out.println("\nDevi decidere se utilizzare un attacco magico o un attacco fisico.");
        System.out.println("1 - Evochi un arco di tenebra\n2 - Estrai un lucente pugnale");
        System.out.println("Cosa scegli? ");
        boolean sceltaValida = false;
        boolean mostroMorto = false;
        int hpMostroPrima = bersaglio.getHp();
        while (!sceltaValida) {
            try {
                byte input = scanner.nextByte();
                scanner.nextLine();
                switch (input) {
                    case 1 -> {
                        System.out.println("\nDecidi di scagliare un Freccia incantata sul mostro!");
                        int danno = this.attMagico;
                        int dannoFinale = bersaglio.difesaPassiva(danno, TipoDanno.MAGICO);
                        bersaglio.subisciDanno(dannoFinale);
                        if (bersaglio.isDead()) {
                            System.out.println("\nIncredibile! Hai sconfitto il mostro!");
                            mostroMorto = true;
                        } else {
                            System.out.println("Che precisione! Colpisci in pieno il mostro e gli infliggi " + dannoFinale + " di danno!");
                            System.out.println("Hp mostro: " + hpMostroPrima + " -> " + bersaglio.getHp());
                        }
                        sceltaValida = true;
                    }
                    case 2 -> {
                        System.out.println("\nDecidi di colpire il mostro con il tuo scintillante pugnale!");
                        int danno = this.attFisico;
                        int dannoFinale = bersaglio.difesaPassiva(danno, TipoDanno.FISICO);
                        bersaglio.subisciDanno(dannoFinale);
                        if (bersaglio.isDead()) {
                            System.out.println("\nIncredibile! Hai sconfitto il mostro!");
                            mostroMorto = true;
                        } else {
                            System.out.println("Che maestria! Colpisci il mostro e gli infliggi " + dannoFinale + " di danno!");
                            System.out.println("Hp mostro: " + hpMostroPrima + " -> " + bersaglio.getHp());
                        }
                        sceltaValida = true;
                    }
                    default -> {
                        System.out.println("Scelta non valida, inserisci 1 o 2!");
                    }
                }
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("Input non valido! Inserisci un numero!");
            }
        }
        return mostroMorto;
    }

    @Override
    public void potenziamentoStatistiche() {
        Map<String, Integer> statistichePrima = ottieniStatistiche();
        this.hpMax += 20;
        this.difMagicaBase += 5;
        this.difFisicaBase += 5;
        this.attFisico += 10;
        this.attMagico += 10;
        Map<String, Integer> statisticheDopo = ottieniStatistiche();
        for (String chiave : statistichePrima.keySet()) {
            System.out.println(chiave + ": " + statistichePrima.get(chiave) + " -> " + statisticheDopo.get(chiave));
        }
    }
}
