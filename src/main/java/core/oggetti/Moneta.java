package core.oggetti;

import core.tipi.TipoOggetti;

import  java.util.Random;

public class Moneta extends Oggetto {
    public Moneta(TipoOggetti tipoOggetto, int quantita, int valore) {
        super("Corona di Valdor", tipoOggetto, quantita, valore);
    }

    Random random = new Random();

    public boolean usaCombattimento() {
        if (this.getQuantita() <= 0) {
            System.out.println("Non hai più " + this.getNome() + "!");
            return false;
        }
        int moneteLanciate = Math.min(random.nextInt(5) + 1, this.getQuantita());
        int monetePrima = this.getQuantita();
        this.setQuantita(this.getQuantita() - moneteLanciate);
        System.out.println("Lanciare " + moneteLanciate + (moneteLanciate == 1 ? " moneta" : " monete") + " al mostro non ha avuto alcun effetto!");
        System.out.println("Monete: " + monetePrima + " -> " + this.getQuantita());
        if (this.getQuantita() == 0) {
            System.out.println("Sappi che hai appena gettato tutte le tue monete!");
        }
        return true;
    }
}
