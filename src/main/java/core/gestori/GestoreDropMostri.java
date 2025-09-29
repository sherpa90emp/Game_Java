package core.gestori;

import core.entita.player.Eroe;
import core.oggetti.Oggetto;
import core.tipi.TipoMostriSpawn;
import core.tipi.TipoOggetti;

import  java.util.Random;

public class GestoreDropMostri {
    Random random = new Random();

    public void gestioneDrop(TipoOggetti tipoO, Eroe eroe, TipoMostriSpawn tipoM) {
        switch (tipoO) {
            case ESPLOSIVO -> {
                int quantita = switch (tipoM) {
                    case ORCO -> random.nextInt(2);
                    case SCHELETRO, GOBLIN -> random.nextInt(1);
                    case DRAGO -> 0;
                };
                if (quantita > 0) {
                    for (Oggetto o : eroe.getInventario()) {
                        if (o.getTipoOggetto() == TipoOggetti.ESPLOSIVO) {
                            int quantitaPrima = o.getQuantita();
                            o.setQuantita((o.getQuantita() + quantita));
                            System.out.println("\nDal corpo senza vita del mostro trovi...\n" + quantita + " " + (quantita > 1 ? "Bombe" : o.getNome()));
                            System.out.println(o.getNome() + ": " + quantitaPrima + " -> " + o.getQuantita());
                        }
                    }
                } else {
                    System.out.println("\nDal corpo senza vita del mostro non trovi niente che possa tornarti utile...");
                }
            }
            case VALUTA -> {
                int quantita = switch (tipoM) {
                    case ORCO -> random.nextInt(15);
                    case GOBLIN -> random.nextInt(50);
                    case SCHELETRO -> random.nextInt(10);
                    case DRAGO -> random.nextInt(200);
                };
                if (quantita > 0) {
                    for (Oggetto o : eroe.getInventario()) {
                        if (o.getTipoOggetto() == TipoOggetti.VALUTA) {
                            int quantitaPrima = o.getQuantita();
                            o.setQuantita((o.getQuantita() + quantita));
                            System.out.println("\nDal corpo senza vita del mostro trovi...\n" + quantita + " " + (quantita > 1 ? "Monete" : o.getNome()));
                            System.out.println(o.getNome() + ": " + quantitaPrima + " -> " + o.getQuantita());
                        }
                    }
                } else {
                    System.out.println("\nDal corpo senza vita del mostro non trovi niente che possa tornarti utile...");
                }
            }
            case CONSUMABILE -> {
                int quantita = switch (tipoM) {
                    case ORCO, GOBLIN -> random.nextInt(1);
                    case SCHELETRO -> random.nextInt(2);
                    case DRAGO -> 0;
                };
                if (quantita > 0) {
                    for (Oggetto o : eroe.getInventario()) {
                        if (o.getTipoOggetto() == TipoOggetti.CONSUMABILE) {
                            int quantitaPrima = o.getQuantita();
                            o.setQuantita((o.getQuantita() + quantita));
                            System.out.println("\nDal corpo senza vita del mostro trovi...\n" + quantita + " " + (quantita > 1 ? "Pozioni" : o.getNome()));
                            System.out.println(o.getNome() + ": " + quantitaPrima + " -> " + o.getQuantita());
                        }
                    }
                } else {
                    System.out.println("\nDal corpo senza vita del mostro non trovi niente che possa tornarti utile...");
                }

            }
        }
    }
}
