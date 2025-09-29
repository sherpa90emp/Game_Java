package core.interfacce;

import controller.inputPort;
import core.entita.Player.eroe;

public interface incontro<T> {
    void esegui(eroe eroe, T tipo);

    boolean esegui(eroe eroe, T tipo, inputPort<String> input);
}
