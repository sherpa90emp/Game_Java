package core.gestori;

import core.interfacce.Combattente;
import core.oggetti.Bomba;
import core.tipi.TipoOggetti;

public class GestoreTrappola {
    public void attivaTrappola(Combattente bersaglio) {
        Bomba bomba = new Bomba("Bombetta", TipoOggetti.TRAPPOLA, 1, 1, 5);
        System.out.println("Vedi qualcosa a terra e ti avvicini... \nBOOOM!!! \nUna bombetta ti esplode davanti!");
        bomba.usa(bersaglio);
    }
}
