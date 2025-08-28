package Gestori;

import Nomi.NomiPozione;
import Tipi.TipoOggetti;
import Oggetti.*;

import java.util.ArrayList;
import java.util.Random;

public class GestoreCreazioneInventario {


    Random random = new Random();

    public ArrayList<Oggetto> creazioneInventario() {
        ArrayList<Oggetto> inventario = new ArrayList<>();
        inventario.add(new Pozione( NomiPozione.CURAPICCOLA.getNome(), TipoOggetti.CONSUMABILE, random.nextInt(10) + 1, 10));
        inventario.add(new Moneta(TipoOggetti.VALUTA, random.nextInt(100) + 1, 1));
        inventario.add(new Bomba("Bombetta", TipoOggetti.ESPLOSIVO, random.nextInt(11), 10, 35));
        return inventario;
    }
}
