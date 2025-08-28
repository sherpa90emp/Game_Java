package Interface;

import Entita.Player.Eroe;

import java.util.Scanner;

public interface Incontro<T> {
    void esegui(Eroe eroe, T tipo);

    boolean esegui(Eroe eroe, T tipo, Scanner scanner);
}
