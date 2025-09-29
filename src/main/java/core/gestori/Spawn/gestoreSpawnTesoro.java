package core.gestori.Spawn;

import core.tipi.TipoOggetti;

public class gestoreSpawnTesoro {
    private double percBomba;
    private double percMoneta;
    private double percPozione;

    public gestoreSpawnTesoro(double percBomba, double percMoneta, double percPozione) {
        this.percBomba = percBomba;
        this.percMoneta = percMoneta;
        this.percPozione = percPozione;
    }

    public TipoOggetti spawnOggetti() {
        Double random = Math.random();
        Double sommaPercentuali = 0.0;

        sommaPercentuali += percBomba;
        if (random < sommaPercentuali) return TipoOggetti.ESPLOSIVO;

        sommaPercentuali += percMoneta;
        if (random < sommaPercentuali) return TipoOggetti.VALUTA;

        return TipoOggetti.CONSUMABILE;
    }
}
