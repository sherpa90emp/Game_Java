package core.gestori;

import core.interfacce.combattente;
import core.oggetti.bomba;
import core.tipi.TipoOggetti;

public class gestoreTrappola {
    public void attivaTrappola(combattente bersaglio) {
        bomba bomba = new bomba("Bombetta", TipoOggetti.TRAPPOLA, 1, 1, 5);
        System.out.println("Vedi qualcosa a terra e ti avvicini... \nBOOOM!!! \nUna bombetta ti esplode davanti!");
        bomba.usa(bersaglio);
    }
}
