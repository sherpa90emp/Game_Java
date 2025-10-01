package controller;

import java.util.Scanner;

/**
 * Implementazione di {@link InputPort} che legge l'input da console utilizzando un {@link Scanner}.
 */
public class ConsoleInput implements InputPort {

    private final Scanner scanner = new Scanner(System.in);

    /**
     * Legge una riga di testo della console.
     * @return la riga inserita dall'utente, senza il carattere newline finale.
     */
    @Override
    public String getInput() {
        return scanner.nextLine();
    }
}
