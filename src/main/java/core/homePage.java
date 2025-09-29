package core;

import controller.consoleInput;
import controller.inputPort;
import core.entita.Player.eroe;
import core.gestori.gestoreGamePlay;
import core.gestori.gestoreHomePage;


public class homePage {

    private final inputPort<String> inputPort;

    public homePage(inputPort<String> inputPort) {
        this.inputPort = inputPort;
    }

    public static void main(String[] args) {
        gestoreHomePage gestoreHomePage = new gestoreHomePage();
        inputPort<String> input = new consoleInput();

        gestoreHomePage.avvioGioco(input);
        eroe eroe = gestoreHomePage.sceltaMenu(input);
        if (eroe != null) {
            gestoreGamePlay gestoreGamePlay = new gestoreGamePlay(eroe, input);
            gestoreGamePlay.avviaGamePlay();
        }

    }
}
