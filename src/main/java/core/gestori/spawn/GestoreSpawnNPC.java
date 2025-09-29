package core.gestori.spawn;

import core.tipi.TipoNPC;

public class GestoreSpawnNPC {
    private double percFabbro;
    private double percGuaritore;
    private double percMercante;

    public GestoreSpawnNPC(double percFabbro, double percGuaritore, double percMercante) {
        this.percFabbro = percFabbro;
        this.percGuaritore = percGuaritore;
        this.percMercante = percMercante;
    }

    public TipoNPC spawnNPC() {
        Double random = Math.random();
        Double sommaPercentuali = 0.0;

        sommaPercentuali += percFabbro;
        if (random < sommaPercentuali) return TipoNPC.FABBRO;

        sommaPercentuali += percGuaritore;
        if (random < sommaPercentuali) return TipoNPC.GUARITORE;

        return TipoNPC.MERCANTE;
    }
}
