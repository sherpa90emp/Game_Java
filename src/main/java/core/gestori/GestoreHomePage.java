package core.gestori;

import controller.InputPort;
import core.entita.player.Elfo;
import core.entita.player.Eroe;
import core.entita.player.Guerriero;
import core.entita.player.Mago;
import core.oggetti.*;

import  java.util.ArrayList;
import  java.util.InputMismatchException;


public class GestoreHomePage {

    private Eroe eroe = null;
    private GestoreCreazioneInventario gestoreInventario = new GestoreCreazioneInventario();

    public void avvioGioco(InputPort<String> input) {
        System.out.println("*** Doungeon Crawler ***" + "\n" + "\n" + "Questo gioco è stato creato da Andrea C." + "\n" + "Buon divertimento!");
        System.out.println("\n" + "Premere 0 per uscire dal gioco..." + "\n" + "Premere un qualsiasi altro tasto per iniziare!" + "\n");
        String scelta = input.getInput();
        if (scelta.equals("0")) {
            System.out.println("Uscita dal gioco...");
            System.exit(0);
        } else {
            System.out.println("Caricamento del gioco...");
            stampaMenu();
        }
    }

    public void stampaMenu() {
        System.out.println("*** Benvenuto in Doungeon Crawler ***" + "\n" + "Ti aspettano mille avventure!!");
        System.out.println("\n" + "Seleziona il tuo eroe: " + "\n" + "1 - Guerriero" + "\n" + "2 - Elfo" + "\n" + "3 - Mago" + "\n" + "0 - Esci");
    }

    public Eroe sceltaMenu(InputPort<String> input) {
        boolean sceltaValida = false;
        while (!sceltaValida) {
            try {
                byte scelta = Byte.parseByte(input.getInput());
                switch (scelta) {
                    case 1: {
                        System.out.println("Ottimo, hai selezionato il Guerriero!");
                        sceltaValida = true;
                        eroe = creazioneEroe(input, scelta);
                        break;

                    }
                    case 2: {
                        System.out.println("Ottimo, hai selezionato l'Elfo!");
                        sceltaValida = true;
                        eroe = creazioneEroe(input, scelta);
                        break;
                    }
                    case 3: {
                        System.out.println("Ottimo, hai selezionato il Mago!");
                        sceltaValida = true;
                        eroe = creazioneEroe(input, scelta);
                        break;
                    }
                    case 0: {
                        System.out.println("Hai scelto di tornare alla schermata iniziale, a presto!");
                        sceltaValida = true;
                        break;
                    }
                    default: {
                        System.out.println("Scelta non valia! Inserisci un numero compreso tra 0 e 3!");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Input non valido! Inserisci un numero!");
            }
        }
        return eroe;
    }

    public Eroe creazioneEroe(InputPort<String> input, byte scelta) {
        System.out.println("Inserisci il nome del tuo eroe: ");
        String nome = input.getInput();

        ArrayList<Oggetto> inventario = gestoreInventario.creazioneInventario();

        switch (scelta) {
            case 1:
                eroe = new Guerriero(nome, inventario);
                break;
            case 2:
                eroe = new Elfo(nome, inventario);
                break;
            case 3:
                eroe = new Mago(nome, inventario);
                break;
        }
        stampaEroe(eroe);
        System.out.println(eroe.stampaInventario());
        return eroe;
    }

    public void stampaEroe(Eroe eroe) {
        System.out.println("** Il tuo Eroe! **");
        System.out.println(eroe.toString());
    }
}
