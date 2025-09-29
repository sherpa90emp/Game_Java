package core.gestori;

import controller.inputPort;
import core.entita.Mostri.drago;
import core.entita.Mostri.mostro;
import core.entita.Player.eroe;
import core.gestori.Incontri.incontroMostro;
import core.gestori.Incontri.incontroNPC;
import core.gestori.Incontri.incontroTesoro;
import core.gestori.Spawn.gestoreSpawnMostri;
import core.gestori.Spawn.gestoreSpawnNPC;
import core.gestori.Spawn.gestoreSpawnTesoro;
import core.tipi.*;

import java.util.ArrayList;

public class gestoreIncontri {
    private double percMostro;
    private double percTrappola;
    private double percNpc;
    private double percNiente;
    private double percTesoro;
    private double percDrago;
    private final inputPort<String> input;

    public gestoreIncontri(double percMostro, double percTrappola, double percNpc, double percNiente, double percTesoro, double percDrago, inputPort<String> input) {
        this.percMostro = percMostro;
        this.percTrappola = percTrappola;
        this.percNpc = percNpc;
        this.percNiente = percNiente;
        this.percTesoro = percTesoro;
        this.percDrago = percDrago;
        this.input = input;
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

        return TipoIncontro.DRAGO;
    }

    public void gestioneIncontro(TipoIncontro tipoI, TipoDirezione tipoD, eroe eroe, inputPort<String> input) {
        switch (tipoI) {
            case MOSTRO -> {
                switch (tipoD) {
                    case CAVERNA -> {
                        gestoreSpawnMostri gestoreSpawnMostri = new gestoreSpawnMostri(0.4, 0.2, 0.4);
                        TipoMostriSpawn tipo = gestoreSpawnMostri.spawnMostro();
                        incontroMostro incontroMostro = new incontroMostro();
                        incontroMostro.esegui(eroe, tipo);
                        mostro mostro = incontroMostro.getMostroGenerato();
                        gestoreCombattimento gestoreCombattimento = new gestoreCombattimento(eroe, mostro, input);
                        gestoreCombattimento.avviaCombattimento(tipo);
                    }
                    case FORESTA -> {
                        gestoreSpawnMostri gestoreSpawnMostri = new gestoreSpawnMostri(0.4, 0.4, 0.2);
                        TipoMostriSpawn tipo = gestoreSpawnMostri.spawnMostro();
                        incontroMostro incontroMostro = new incontroMostro();
                        incontroMostro.esegui(eroe, tipo);
                        mostro mostro = incontroMostro.getMostroGenerato();
                        gestoreCombattimento gestoreCombattimento = new gestoreCombattimento(eroe, mostro, input);
                        gestoreCombattimento.avviaCombattimento(tipo);
                    }
                    case VILLAGGIO -> {
                        gestoreSpawnMostri gestoreSpawnMostri = new gestoreSpawnMostri(0.2, 0.4, 0.4);
                        TipoMostriSpawn tipo = gestoreSpawnMostri.spawnMostro();
                        incontroMostro incontroMostro = new incontroMostro();
                        incontroMostro.esegui(eroe, tipo);
                        mostro mostro = incontroMostro.getMostroGenerato();
                        gestoreCombattimento gestoreCombattimento = new gestoreCombattimento(eroe, mostro, input);
                        gestoreCombattimento.avviaCombattimento(tipo);
                    }
                }
            }
            case TRAPPOLA -> {
                gestoreTrappola gestoreTrappola = new gestoreTrappola();
                gestoreTrappola.attivaTrappola(eroe);
                gestoreFineGioco.morteEroe(eroe);
            }
            case NPC -> {
                switch (tipoD) {
                    case CAVERNA -> {
                        gestoreSpawnNPC gestoreNPC = new gestoreSpawnNPC(0.1, 0.7, 0.2);
                        TipoNPC tipo = gestoreNPC.spawnNPC();
                        incontroNPC incontroNPC = new incontroNPC();
                        incontroNPC.esegui(eroe, tipo, input);
                    }
                    case FORESTA -> {
                        gestoreSpawnNPC gestoreNPC = new gestoreSpawnNPC(0.1, 0.6, 0.3);
                        TipoNPC tipo = gestoreNPC.spawnNPC();
                        incontroNPC incontroNPC = new incontroNPC();
                        incontroNPC.esegui(eroe, tipo, input);
                    }
                    case VILLAGGIO -> {
                        gestoreSpawnNPC gestoreNPC = new gestoreSpawnNPC(0.6, 0.1, 0.3);
                        TipoNPC tipo = gestoreNPC.spawnNPC();
                        incontroNPC incontroNPC = new incontroNPC();
                        incontroNPC.esegui(eroe, tipo, input);
                    }
                }
            }
            case NIENTE -> {
                switch (tipoD) {
                    case CAVERNA ->
                            System.out.println("Dopo aver cercato sotto ogni singola pietra e non aver trovato nulla, decidi di uscire da quel posto buio e umido!");
                    case FORESTA ->
                            System.out.println("Dopo ore di ricerca l'unica cosa che sei riuscito a trovare è solo un vecchio fungo! Ripercorri il sentiero ed esci dalla foresta.");
                    case VILLAGGIO ->
                            System.out.println("Sei arrivato troppo tardi, la festa è già finita!\nLe locande sono chiuse e vedi solo alcuni ubriaconi per strada.\nDecidi di andartene sconsolato...");
                }
            }
            case TESORO -> {
                switch (tipoD) {
                    case CAVERNA -> {
                        gestoreSpawnTesoro gestoreSpawnTesoro = new gestoreSpawnTesoro(0.3, 0.5, 0.2);
                        TipoOggetti tipo = gestoreSpawnTesoro.spawnOggetti();
                        incontroTesoro incontroTesoro = new incontroTesoro();
                        incontroTesoro.esegui(eroe, tipo);
                    }
                    case FORESTA -> {
                        gestoreSpawnTesoro gestoreSpawnTesoro = new gestoreSpawnTesoro(0.2, 0.3, 0.5);
                        TipoOggetti tipo = gestoreSpawnTesoro.spawnOggetti();
                        incontroTesoro incontroTesoro = new incontroTesoro();
                        incontroTesoro.esegui(eroe, tipo);
                    }
                    case VILLAGGIO -> {
                        gestoreSpawnTesoro gestoreSpawnTesoro = new gestoreSpawnTesoro(0.5, 0.2, 0.3);
                        TipoOggetti tipo = gestoreSpawnTesoro.spawnOggetti();
                        incontroTesoro incontroTesoro = new incontroTesoro();
                        incontroTesoro.esegui(eroe, tipo);
                    }
                }
            }
            case DRAGO -> {
                drago drago = new drago((short) 1, new ArrayList<>());
                TipoMostriSpawn tipo = TipoMostriSpawn.DRAGO;
                System.out.println("Improvvisamente il cielo si oscura, appare un...  \n" + drago);
                gestoreCombattimento gestoreCombattimento = new gestoreCombattimento(eroe, drago, input);
                gestoreCombattimento.avviaCombattimento(tipo);
            }
        }
    }
}

