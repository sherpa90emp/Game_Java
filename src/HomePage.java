import Entita.Player.Eroe;
import Gestori.GestoreGamePlay;
import Gestori.GestoreHomePage;

import java.util.Scanner;

public class HomePage {
    public static void main(String[] args) {
        GestoreHomePage gestoreHomePage = new GestoreHomePage();
        Scanner scanner = new Scanner(System.in);

        gestoreHomePage.avvioGioco(scanner);
        Eroe eroe = gestoreHomePage.sceltaMenu(scanner);
        if (eroe != null) {
            GestoreGamePlay gestoreGamePlay = new GestoreGamePlay(eroe, scanner);
            gestoreGamePlay.avviaGamePlay();
        }

    }
}
