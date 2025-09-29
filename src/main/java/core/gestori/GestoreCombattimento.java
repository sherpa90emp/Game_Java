package core.gestori;

import controller.InputPort;
import core.entita.mostri.Drago;
import core.entita.mostri.Mostro;
import core.entita.player.Eroe;
import core.gestori.spawn.GestoreSpawnDropMostri;
import core.oggetti.Bomba;
import core.oggetti.Moneta;
import core.oggetti.Oggetto;
import core.oggetti.Pozione;
import core.tipi.TipoMostriSpawn;
import core.tipi.TipoOggetti;

import  java.util.*;

public class GestoreCombattimento {
    private Eroe eroe;
    private Mostro mostroGenerato;
    private final InputPort<String> input;

    Random random = new Random();

    public GestoreCombattimento(Eroe eroe, Mostro mostroGenerato, InputPort<String> input) {
        this.eroe = eroe;
        this.mostroGenerato = mostroGenerato;
        this.input = input;
    }

    public boolean avviaCombattimento(TipoMostriSpawn tipoM) {

        boolean combattimentoAttivo = true;

        while (combattimentoAttivo && !eroe.isDead() && !mostroGenerato.isDead()) {
            boolean azioneValida = false;
            System.out.println("\nIl mostro ti è innanzi! Puoi: ");
            System.out.println("1 - Attaccarlo\n2 - Difenderti\n3 - Usare un oggetto\n4 - Scappare");
            System.out.println("Che cosa vuoi fare?");
            try {
                byte scelta = Byte.parseByte(input.getInput());
                switch (scelta){
                    case 1: {
                        eroe.attacco(mostroGenerato, input);
                        azioneValida = true;
                        break;
                    }
                    case 2: {
                        eroe.difesaAttiva();
                        azioneValida = true;
                        break;
                    }
                    case 3: {
                        boolean continua = utilizzoOggettiInventario(eroe, mostroGenerato, input);
                        if (!continua) {
                            if (mostroGenerato.isDead()) {
                                combattimentoAttivo = false;
                            }
                        }
                        azioneValida = true;
                        break;
                    }
                    case 4: {
                        System.out.println("\nRiesci a fuggire ma...");
                        boolean vivo = dannoDaFuga(tipoM);
                        combattimentoAttivo = false;
                        azioneValida = true;
                        if (!vivo) {
                            System.out.println("\nSei morto mentri stavi tentando la fuga!");
                        }
                        break;
                    }
                    default: {
                        System.out.println("Scelta non valida, inserisci un numero tra 1 e 4!");
                    }
                }
                if (azioneValida && combattimentoAttivo && !mostroGenerato.isDead()) {
                    mostroGenerato.attacco(eroe, input);
                }
                if (eroe.isDead()) {
                    GestoreFineGioco.morteEroe(eroe);
                    return false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input non valido, inserisci un numero!");
            }
            eroe.aggiornaTurno();
        }
        if (mostroGenerato instanceof Drago && mostroGenerato.isDead() && !eroe.isDead()){
            GestoreFineGioco.vittoriaEroe(eroe);
        }
        if (mostroGenerato.isDead() && !eroe.isDead()) {
            eroe.aumentoLivello();
            eroe.aggiungiMostriUccisi(mostroGenerato.getNome());
            GestoreSpawnDropMostri spawnDropMostri = new GestoreSpawnDropMostri(tipoM);
            TipoOggetti tipoDrop = spawnDropMostri.dropCasuale();
            GestoreDropMostri gestoreDropMostri = new GestoreDropMostri();
            gestoreDropMostri.gestioneDrop(tipoDrop, eroe, tipoM);
        }
        return !eroe.isDead();
    }

    public boolean dannoDaFuga(TipoMostriSpawn tipo) {
        short danno = (short) (random.nextInt(10) + 1);
        int hpPrima = eroe.getHp();
        switch (tipo) {
            case GOBLIN -> {
                System.out.println(mostroGenerato.getNome() + " ti lancia un pugnale!");
                eroe.setHp((short) (eroe.getHp() - danno));
                System.out.println(eroe.getNome() + " subisce " + danno + " di danno!");
                System.out.println("HP: " + hpPrima + " -> " + eroe.getHp());
            }
            case ORCO -> {
                System.out.println(mostroGenerato.getNome() + " ti scaglia contro una pietra!");
                eroe.setHp((short) (eroe.getHp() - danno));
                System.out.println(eroe.getNome() + " subisce " + danno + " di danno!");
                System.out.println("HP: " + hpPrima + " -> " + eroe.getHp());
            }
            case SCHELETRO -> {
                System.out.println(mostroGenerato.getNome() + " scocca una freccia dal suo arco!");
                eroe.setHp((short) (eroe.getHp() - danno));
                System.out.println(eroe.getNome() + " subisce " + danno + " di danno!");
                System.out.println("HP: " + hpPrima + " -> " + eroe.getHp());
            }
        }
        return !eroe.isDead();
    }

    public static boolean utilizzoOggettiInventario(Eroe eroe, Mostro mostroGenerato, InputPort<String> input) {
        ArrayList<Oggetto> inventario = eroe.getInventario();

        if (inventario.isEmpty()) {
            System.out.println("Non hai core.oggetti da usare!");
            return false;
        }
        System.out.println("\nScegli l'oggetto che vuoi usare: ");
        eroe.stampaInventario();
        System.out.println("1 - Pozione di cura\n2 - Monete\n3 - Bombetta\n4 - Torna indietro");
        try {
            byte scelta = Byte.parseByte(input.getInput());
            switch (scelta) {
                case 1 -> inventario.stream()
                        .filter(o -> o instanceof Pozione)
                        .findFirst()
                        .ifPresent(o -> {
                            System.out.println("\nBevi una pozione curativa");
                            ((Pozione) o).usa(eroe);
                        });
                case 2 -> {
                    if (mostroGenerato != null) {
                        inventario.stream()
                                .filter(o -> o instanceof Moneta)
                                .findFirst()
                                .ifPresent(o -> {
                                    System.out.println("\nNon so perchè tu l'abbia fatto ma lanci delle monete contro il mostro!");
                                    ((Moneta) o).usaCombattimento();
                                });
                    } else {
                        System.out.println("Non c'è nessun mostro, non puoi fare questa azione!");
                        return false;
                    }
                }
                case 3 -> {
                    if (mostroGenerato != null) {
                        inventario.stream()
                                .filter(o -> o instanceof Bomba)
                                .findFirst()
                                .ifPresent(o -> {
                                    System.out.println("\nLanci una bomba contro il mostro!");
                                    ((Bomba) o).usa(mostroGenerato);
                                    if (mostroGenerato.isDead()) {
                                        System.out.println("Ottimo lancio, hai sconfitto " + mostroGenerato.getNome());
                                    }
                                });
                    } else {
                        System.out.println("Non c'è nessun mostro, non puoi fare questa azione!");
                        return false;
                    }
                }
                case 4 -> {
                    System.out.println("...");
                    return false;
                }
                default -> System.out.println("Numero non valido, inserisci un numero da 1 a 4!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input non valido!");
        }
        if (mostroGenerato != null && mostroGenerato.isDead()) {
            return false;
        }
        return true;
    }
}

