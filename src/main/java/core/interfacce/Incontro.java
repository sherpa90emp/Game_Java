package core.interfacce;

import controller.InputPort;
import core.entita.player.Eroe;

public interface Incontro<T> {
    void esegui(Eroe eroe, T tipo);

    boolean esegui(Eroe eroe, T tipo, InputPort<String> input);
}
