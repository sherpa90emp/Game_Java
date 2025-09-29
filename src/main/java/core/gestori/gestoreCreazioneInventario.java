package core.gestori;

import core.nomi.nomiPozione;
import core.tipi.TipoOggetti;
import core.oggetti.*;

import  java.util.ArrayList;
import  java.util.Random;

public class gestoreCreazioneInventario {


    Random random = new Random();

    public ArrayList<oggetto> creazioneInventario() {
        ArrayList<oggetto> inventario = new ArrayList<>();
        inventario.add(new pozione( nomiPozione.CURAPICCOLA.getNome(), TipoOggetti.CONSUMABILE, random.nextInt(10) + 1, 10));
        inventario.add(new moneta(TipoOggetti.VALUTA, random.nextInt(100) + 1, 1));
        inventario.add(new bomba("Bombetta", TipoOggetti.ESPLOSIVO, random.nextInt(11), 10, 35));
        return inventario;
    }
}
