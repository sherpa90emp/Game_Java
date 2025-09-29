package core.gestori.incontri;

import controller.InputPort;
import core.entita.player.Eroe;
import core.interfacce.Incontro;
import core.oggetti.Oggetto;
import core.tipi.TipoOggetti;

import  java.util.Random;

public class IncontroTesoro implements Incontro<TipoOggetti> {

    @Override
    public void esegui(Eroe eroe, TipoOggetti tipoO) {

        Random random = new Random();

        switch (tipoO) {
            case ESPLOSIVO -> {
                System.out.println("Ti accorgi che li davanti a te c'è una bombetta forse cascata dalla tasca di qualche altro viandante.\nLa raccogli e la metti nel tuo inventario!");
                for (Oggetto o : eroe.getInventario()) {
                    if (o.getTipoOggetto() == TipoOggetti.ESPLOSIVO) {
                        int bombePrima = o.getQuantita();
                        o.setQuantita(o.getQuantita() + 1);
                        System.out.println("Bombe: " + bombePrima + " -> " + o.getQuantita());
                    }
                }
            }
            case VALUTA -> {
                System.out.println("Con tua immensa sorpresa ti accorgi che li davanti a te, in parte coperto, vi è uno scrigno!\nTi guardi attorno e poi lo apri con una certa frenesia.\nAl suo interno trovi...");
                for (Oggetto o : eroe.getInventario()) {
                    if (o.getTipoOggetto() == TipoOggetti.VALUTA) {
                        int monetePrima = o.getQuantita();
                        int moneteRandom = random.nextInt(50) + 1;
                        o.setQuantita(o.getQuantita() + moneteRandom);
                        System.out.println(moneteRandom + " monete!");
                        System.out.println("Monete: " + monetePrima + " -> " + o.getQuantita());
                    }
                }
            }
            case CONSUMABILE -> {
                System.out.println("Camminando vedi davanti a te un boccetta.\nLa raccogli e capisci subito che si tratta di una pozione curativa.\nLa metti nel tuo inventario!");
                for (Oggetto o : eroe.getInventario()) {
                    if (o.getTipoOggetto() == TipoOggetti.CONSUMABILE) {
                        int pozionePrima = o.getQuantita();
                        o.setQuantita(o.getQuantita() + 1);
                        System.out.println("Pozioni di cura: " + pozionePrima + " -> " + o.getQuantita());
                    }
                }
            }
        }
    }

    @Override
    public boolean esegui(Eroe eroe, TipoOggetti tipo, InputPort<String> input) {

        return false;
    }
}
