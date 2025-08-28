package Gestori;

import Entita.Mostri.Drago;
import Entita.Mostri.Mostro;
import Entita.Player.Eroe;
import Gestori.Incontri.IncontroMostro;
import Gestori.Incontri.IncontroNPC;
import Gestori.Incontri.IncontroTesoro;
import Gestori.Spawn.GestoreSpawnMostri;
import Gestori.Spawn.GestoreSpawnNPC;
import Gestori.Spawn.GestoreSpawnTesoro;
import Tipi.*;

import java.util.ArrayList;
import java.util.Scanner;

public class GestoreIncontri {
    private double percMostro;
    private double percTrappola;
    private double percNpc;
    private double percNiente;
    private double percTesoro;
    private double percDrago;

    public GestoreIncontri(double percMostro, double percTrappola, double percNpc, double percNiente, double percTesoro, double percDrago) {
        this.percMostro = percMostro;
        this.percTrappola = percTrappola;
        this.percNpc = percNpc;
        this.percNiente = percNiente;
        this.percTesoro = percTesoro;
        this.percDrago = percDrago;
    }

    public TipoIncontro incontroCasuale(int counterIncontroDrago) {

        if (counterIncontroDrago == 10) {
            return TipoIncontro.DRAGO;
        }

        Double random = Math.random();
        Double sommaPercentuali = 0.0;

        sommaPercentuali += percMostro;
        if (random < sommaPercentuali) return TipoIncontro.MOSTRO;

        sommaPercentuali += percTrappola;
        if (random < sommaPercentuali) return TipoIncontro.TRAPPOLA;

        sommaPercentuali += percNpc;
        if (random < sommaPercentuali) return TipoIncontro.NPC;

        sommaPercentuali += percNiente;
        if (random < sommaPercentuali) return TipoIncontro.NIENTE;

        sommaPercentuali += percTesoro;
        if (random < sommaPercentuali) return TipoIncontro.TESORO;

        return  TipoIncontro.DRAGO;
    }

    public void gestioneIncontro(TipoIncontro tipoI, TipoDirezione tipoD, Eroe eroe, Scanner scanner) {
        switch (tipoI) {
            case MOSTRO -> {
                switch (tipoD) {
                    case CAVERNA -> {
                        GestoreSpawnMostri gestoreSpawnMostri = new GestoreSpawnMostri(0.4, 0.2, 0.4);
                        TipoMostriSpawn tipo = gestoreSpawnMostri.spawnMostro();
                        IncontroMostro incontroMostro = new IncontroMostro();
                        incontroMostro.esegui(eroe, tipo);
                        Mostro mostro = incontroMostro.getMostroGenerato();
                        GestoreCombattimento gestoreCombattimento = new GestoreCombattimento(eroe, mostro, scanner);
                        gestoreCombattimento.avviaCombattimento(tipo);
                    }
                    case FORESTA -> {
                        GestoreSpawnMostri gestoreSpawnMostri = new GestoreSpawnMostri(0.4, 0.4, 0.2);
                        TipoMostriSpawn tipo = gestoreSpawnMostri.spawnMostro();
                        IncontroMostro incontroMostro = new IncontroMostro();
                        incontroMostro.esegui(eroe, tipo);
                        Mostro mostro = incontroMostro.getMostroGenerato();
                        GestoreCombattimento gestoreCombattimento = new GestoreCombattimento(eroe, mostro, scanner);
                        gestoreCombattimento.avviaCombattimento(tipo);
                    }
                    case VILLAGGIO-> {
                        GestoreSpawnMostri gestoreSpawnMostri = new GestoreSpawnMostri(0.2, 0.4, 0.4);
                        TipoMostriSpawn tipo = gestoreSpawnMostri.spawnMostro();
                        IncontroMostro incontroMostro = new IncontroMostro();
                        incontroMostro.esegui(eroe, tipo);
                        Mostro mostro = incontroMostro.getMostroGenerato();
                        GestoreCombattimento gestoreCombattimento = new GestoreCombattimento(eroe, mostro, scanner);
                        gestoreCombattimento.avviaCombattimento(tipo);
                    }
                }
            }
            case TRAPPOLA-> {
                GestoreTrappola gestoreTrappola = new GestoreTrappola();
                gestoreTrappola.attivaTrappola(eroe);
                GestoreFineGioco.morteEroe(eroe);
            }
            case NPC-> {
                switch (tipoD) {
                    case CAVERNA -> {
                        GestoreSpawnNPC gestoreNPC = new GestoreSpawnNPC(0.1, 0.7, 0.2);
                        TipoNPC tipo = gestoreNPC.spawnNPC();
                        IncontroNPC incontroNPC = new IncontroNPC();
                        incontroNPC.esegui(eroe, tipo, scanner);
                    }
                    case FORESTA -> {
                        GestoreSpawnNPC gestoreNPC = new GestoreSpawnNPC(0.1, 0.6, 0.3);
                        TipoNPC tipo = gestoreNPC.spawnNPC();
                        IncontroNPC incontroNPC = new IncontroNPC();
                        incontroNPC.esegui(eroe, tipo, scanner);
                    }
                    case VILLAGGIO -> {
                        GestoreSpawnNPC gestoreNPC = new GestoreSpawnNPC(0.6, 0.1, 0.3);
                        TipoNPC tipo = gestoreNPC.spawnNPC();
                        IncontroNPC incontroNPC = new IncontroNPC();
                        incontroNPC.esegui(eroe, tipo, scanner);
                    }
                }
            }
            case NIENTE-> {
                switch (tipoD) {
                    case CAVERNA -> System.out.println("Dopo aver cercato sotto ogni singola pietra e non aver trovato nulla, decidi di uscire da quel posto buio e umido!");
                    case FORESTA -> System.out.println("Dopo ore di ricerca l'unica cosa che sei riuscito a trovare è solo un vecchio fungo! Ripercorri il sentiero ed esci dalla foresta.");
                    case VILLAGGIO -> System.out.println("Sei arrivato troppo tardi, la festa è già finita!\nLe locande sono chiuse e vedi solo alcuni ubriaconi per strada.\nDecidi di andartene sconsolato...");
                }
            }
            case TESORO-> {
                switch (tipoD) {
                    case CAVERNA -> {
                        GestoreSpawnTesoro gestoreSpawnTesoro = new GestoreSpawnTesoro(0.3, 0.5, 0.2);
                        TipoOggetti tipo = gestoreSpawnTesoro.spawnOggetti();
                        IncontroTesoro incontroTesoro = new IncontroTesoro();
                        incontroTesoro.esegui(eroe, tipo);
                    }
                    case FORESTA -> {
                        GestoreSpawnTesoro gestoreSpawnTesoro = new GestoreSpawnTesoro(0.2, 0.3, 0.5);
                        TipoOggetti tipo = gestoreSpawnTesoro.spawnOggetti();
                        IncontroTesoro incontroTesoro = new IncontroTesoro();
                        incontroTesoro.esegui(eroe, tipo);
                    }
                    case VILLAGGIO -> {
                        GestoreSpawnTesoro gestoreSpawnTesoro = new GestoreSpawnTesoro(0.5, 0.2, 0.3);
                        TipoOggetti tipo = gestoreSpawnTesoro.spawnOggetti();
                        IncontroTesoro incontroTesoro = new IncontroTesoro();
                        incontroTesoro.esegui(eroe, tipo);
                    }
                }
            }
            case DRAGO-> {
                Drago drago = new Drago((short) 1, new ArrayList<>());
                TipoMostriSpawn tipo = TipoMostriSpawn.DRAGO;
                System.out.println("Improvvisamente il cielo si oscura, appare un...  \n" + drago);
                GestoreCombattimento gestoreCombattimento = new GestoreCombattimento(eroe, drago, scanner);
                gestoreCombattimento.avviaCombattimento(tipo);
            }
        }
    }
}
