package Gestori;

import Entita.Mostri.Mostro;
import Entita.Player.Eroe;
import Tipi.TipoDirezione;
import Tipi.TipoIncontro;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestoreGamePlay {
    private Eroe eroe;
    private Scanner scanner;
    private int counterIncontroDrago = 0;

    public GestoreGamePlay(Eroe eroe, Scanner scanner) {
        this.eroe = eroe;
        this.scanner = scanner;
    }

    public void avviaGamePlay() {
        boolean continua = true;

        while (continua) {
            System.out.println("\nStai vagando in questo mondo alla ricerca di qualcosa..." + "\n" + "Ti chiedi se sia meglio: \n");
            System.out.println("1 - Addentrarsi in quella caverna buia... magari potresti trovare tesori nascosti... o qualcos'altro!");
            System.out.println("2 - Entrare dentro quella fitta foresta alla ricerca di cibo! Strani romuri si odono provenire da la...");
            System.out.println("3 - Dirigersi verso quel villaggio dove potresti fare incontri con persone socievoli oppure molto sgarbate!");
            System.out.println("4 - Aprire l'inventario");
            System.out.println("0 - Esci dal gioco");

            byte inputSceltaDirezione = sceltaDirezione(scanner);

            switch (inputSceltaDirezione) {
                case 1 -> direzioneCaverna();
                case 2 -> direzioneForesta();
                case 3 -> direzioneVillaggio();
                case 4 -> {
                    Mostro mostroGenerato = null;
                    GestoreCombattimento.utilizzoOggettiInventario(eroe, mostroGenerato, scanner);
                }
                case 0 -> {
                    System.out.println("Hai deciso di terminare l'avventura, a presto!");
                    continua = false;
                }
                default -> System.out.println("Scelta non valida!");
            }
        }
    }

    public byte sceltaDirezione(Scanner scanner) {
        while (true) {
            try {
                System.out.println("\nChe cosa scegli di fare?");
                byte input = scanner.nextByte();
                scanner.nextLine();
                switch (input) {
                    case 1: {
                        System.out.println("Ti dirigi bramoso di ricchezza verso la caverna quando...\n");
                        return 1;
                    }
                    case 2: {
                        System.out.println("Affamato corri verso la foresta quando...\n");
                        return 2;
                    }
                    case 3: {
                        System.out.println("Speranzoso di trovare persone con cui fare bisboccia, ti avvii verso il villagio quando...\n");
                        return 3;
                    }
                    case 4: {
                        System.out.println("Controlli che non ci sia nessuno vicino a te e apri l'inventario...");
                        return 4;
                    }
                    case 0: {
                        System.out.println("Uscita dal gioco...");
                        return 0;
                    }
                    default: {
                        System.out.println("Scelta non valida, inserisci un numero tra 0 e 3!");
                    }
                }
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("Input non valido, inserisci un numero!");
            }
        }
    }

    public void direzioneCaverna() {
        GestoreIncontri gestoreIncontri = new GestoreIncontri(
                0.35,
                0.15,
                0.1,
                0.15,
                0.25,
                0.1
        );
        TipoIncontro tipo = gestoreIncontri.incontroCasuale(counterIncontroDrago);
        if (tipo == TipoIncontro.MOSTRO) {
            counterIncontroDrago++;
        }
        gestoreIncontri.gestioneIncontro(tipo, TipoDirezione.CAVERNA, eroe, scanner);
    }

    public void direzioneForesta() {
        GestoreIncontri gestoreIncontri = new GestoreIncontri(
                0.35,
                0.25,
                0.1,
                0.15,
                0.15,
                0.1
        );
        TipoIncontro tipo = gestoreIncontri.incontroCasuale(counterIncontroDrago);
        if (tipo == TipoIncontro.MOSTRO) {
            counterIncontroDrago++;
        }
        gestoreIncontri.gestioneIncontro(tipo, TipoDirezione.FORESTA, eroe, scanner);
    }

    public void direzioneVillaggio() {
        GestoreIncontri gestoreIncontri = new GestoreIncontri(
                0.35,
                0.15,
                0.20,
                0.15,
                0.15,
                0.1
        );
        TipoIncontro tipo = gestoreIncontri.incontroCasuale(counterIncontroDrago);
        if (tipo == TipoIncontro.MOSTRO) {
            counterIncontroDrago++;
        }
        gestoreIncontri.gestioneIncontro(tipo, TipoDirezione.VILLAGGIO, eroe, scanner);
    }
}
