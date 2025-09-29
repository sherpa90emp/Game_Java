package core;

import controller.ConsoleInput;
import controller.InputPort;
import core.entita.player.Eroe;
import core.gestori.GestoreGamePlay;
import core.gestori.GestoreHomePage;


public class HomePage {

    private final InputPort<String> inputPort;

    public HomePage(InputPort<String> inputPort) {
        this.inputPort = inputPort;
    }

    public static void main(String[] args) {
        GestoreHomePage gestoreHomePage = new GestoreHomePage();
        InputPort<String> input = new ConsoleInput();

        gestoreHomePage.avvioGioco(input);
        Eroe eroe = gestoreHomePage.sceltaMenu(input);
        if (eroe != null) {
            GestoreGamePlay gestoreGamePlay = new GestoreGamePlay(eroe, input);
            gestoreGamePlay.avviaGamePlay();
        }

    }
}
