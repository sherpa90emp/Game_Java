package Gestori;

import Entita.Player.Elfo;
import Entita.Player.Eroe;
import Entita.Player.Guerriero;
import Entita.Player.Mago;
import Oggetti.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class GestoreHomePage {

    private Eroe eroe = null;
    private GestoreCreazioneInventario gestoreInventario = new GestoreCreazioneInventario();

    public void avvioGioco(Scanner scanner) {
        System.out.println("*** Doungeon Crawler ***" + "\n" + "\n" + "Questo gioco è stato creato da Andrea C." + "\n" + "Buon divertimento!");
        System.out.println("\n" + "Premere 0 per uscire dal gioco..." + "\n" + "Premere un qualsiasi altro tasto per iniziare!" + "\n");
        String input = scanner.nextLine();
        if (input.equals("0")) {
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

    public Eroe sceltaMenu(Scanner scanner) {
        boolean sceltaValida = false;
        while (!sceltaValida) {
            try {
                byte input = scanner.nextByte();
                scanner.nextLine();
                switch (input) {
                    case 1: {
                        System.out.println("Ottimo, hai selezionato il Guerriero!");
                        sceltaValida = true;
                        eroe = creazioneEroe(scanner, input);
                        break;

                    }
                    case 2: {
                        System.out.println("Ottimo, hai selezionato l'Elfo!");
                        sceltaValida = true;
                        eroe = creazioneEroe(scanner, input);
                        break;
                    }
                    case 3: {
                        System.out.println("Ottimo, hai selezionato il Mago!");
                        sceltaValida = true;
                        eroe = creazioneEroe(scanner, input);
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
                scanner.next();
                System.out.println("Input non valido! Inserisci un numero!");
            }
        }
        return eroe;
    }

    public Eroe creazioneEroe(Scanner scanner, byte input) {
        System.out.println("Inserisci il nome del tuo eroe: ");
        String nome = scanner.nextLine();

        ArrayList<Oggetto> inventario = gestoreInventario.creazioneInventario();

        switch (input) {
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
