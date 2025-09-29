package core.entita.npc;

import core.nomi.NomiMercante;
import core.nomi.NomiPozione;
import core.oggetti.Bomba;
import core.oggetti.Oggetto;
import core.oggetti.Pozione;
import core.tipi.TipoOggetti;

import java.util.ArrayList;
import java.util.Random;

public class Mercante extends Npc {

    Random random = new Random();

    private ArrayList<Oggetto> oggettiVendibili;

    public Mercante() {
        super(NomiMercante.getRandomNome().getNome());
        this.oggettiVendibili = creazioneInventarioOggettiVendibili();
    }

    public ArrayList<Oggetto> getOggettiVendibili() {
        return oggettiVendibili;
    }

    public void setOggettiVendibili(ArrayList<Oggetto> oggettiVendibili) {
        this.oggettiVendibili = oggettiVendibili;
    }

    public void aggiungiOggettoVendibile(Oggetto oggetto) {
        oggettiVendibili.add(oggetto);
    }

    public void rimuoviOggettoVendibile(Oggetto oggetto) {
        oggettiVendibili.remove(oggetto);
    }

    public ArrayList<Oggetto> creazioneInventarioOggettiVendibili() {
        ArrayList<Oggetto> oggettiVendibili = new ArrayList<>();
        oggettiVendibili.add(new Pozione(NomiPozione.CURAPICCOLA.getNome(), TipoOggetti.CONSUMABILE, random.nextInt(50) + 1, 15));
        oggettiVendibili.add(new Bomba("Bombetta", TipoOggetti.ESPLOSIVO, random.nextInt(20) + 1, 15, 5));
        return oggettiVendibili;
    }

    public String stampaOggettiVendibili() {
        StringBuilder sb = new StringBuilder("In vendita:\n");
        int indice = 1;
        for (Oggetto o : oggettiVendibili) {
            sb.append(indice++).append(" - ").append(o).append("\n");
        }
        return sb.toString();
    }
}
