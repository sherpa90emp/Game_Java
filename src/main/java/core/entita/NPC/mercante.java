package core.entita.NPC;

import core.nomi.nomiMercante;
import core.nomi.nomiPozione;
import core.oggetti.bomba;
import core.oggetti.oggetto;
import core.oggetti.pozione;
import core.tipi.TipoOggetti;

import java.util.ArrayList;
import java.util.Random;

public class mercante extends npc {

    Random random = new Random();

    private ArrayList<oggetto> oggettiVendibili;

    public mercante() {
        super(nomiMercante.getRandomNome().getNome());
        this.oggettiVendibili = creazioneInventarioOggettiVendibili();
    }

    public ArrayList<oggetto> getOggettiVendibili() {
        return oggettiVendibili;
    }

    public void setOggettiVendibili(ArrayList<oggetto> oggettiVendibili) {
        this.oggettiVendibili = oggettiVendibili;
    }

    public void aggiungiOggettoVendibile(oggetto oggetto) {
        oggettiVendibili.add(oggetto);
    }

    public void rimuoviOggettoVendibile(oggetto oggetto) {
        oggettiVendibili.remove(oggetto);
    }

    public ArrayList<oggetto> creazioneInventarioOggettiVendibili() {
        ArrayList<oggetto> oggettiVendibili = new ArrayList<>();
        oggettiVendibili.add(new pozione(nomiPozione.CURAPICCOLA.getNome(), TipoOggetti.CONSUMABILE, random.nextInt(50) + 1, 15));
        oggettiVendibili.add(new bomba("Bombetta", TipoOggetti.ESPLOSIVO, random.nextInt(20) + 1, 15, 5));
        return oggettiVendibili;
    }

    public String stampaOggettiVendibili() {
        StringBuilder sb = new StringBuilder("In vendita:\n");
        int indice = 1;
        for (oggetto o : oggettiVendibili) {
            sb.append(indice++).append(" - ").append(o).append("\n");
        }
        return sb.toString();
    }
}
