package Gestori.Spawn;

import Tipi.TipoMostriSpawn;
import Tipi.TipoOggetti;

public class GestoreSpawnDropMostri {
    private double percBomba;
    private double percMoneta;
    private double percPozione;
    private double percNiente;

    public GestoreSpawnDropMostri(TipoMostriSpawn tipo) {
        gestorePercDropMostri(tipo);
    }

    public void gestorePercDropMostri(TipoMostriSpawn tipo) {
        switch (tipo) {
            case GOBLIN -> {
                percBomba = 0.2;
                percMoneta = 0.4;
                percPozione = 0.1;
                percNiente = 0.3;
            }
            case ORCO -> {
                percBomba = 0.4;
                percMoneta = 0.2;
                percPozione = 0.1;
                percNiente = 0.3;
            }
            case SCHELETRO -> {
                percBomba = 0.1;
                percMoneta = 0.2;
                percPozione = 0.4;
                percNiente = 0.3;
            }
        }
    }

    public TipoOggetti dropCasuale() {
        Double random = Math.random();
        Double sommaPercentuali = 0.0;

        sommaPercentuali += percBomba;
        if (random < sommaPercentuali) return TipoOggetti.ESPLOSIVO;

        sommaPercentuali += percMoneta;
        if (random < sommaPercentuali) return TipoOggetti.VALUTA;

        sommaPercentuali += percPozione;
        if (random < sommaPercentuali) return TipoOggetti.CONSUMABILE;

        return TipoOggetti.NIENTE;
    }
}
