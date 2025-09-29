package core.gestori.Spawn;

import core.tipi.TipoMostriSpawn;

public class gestoreSpawnMostri {
    private double percGoblin;
    private double percOrco;
    private double percScheletro;

    public gestoreSpawnMostri(double percGoblin, double percOrco, double percScheletro) {
        this.percGoblin = percGoblin;
        this.percOrco = percOrco;
        this.percScheletro = percScheletro;
    }

    public TipoMostriSpawn spawnMostro() {
        Double random = Math.random();
        Double sommaPercentuali = 0.0;

        sommaPercentuali += percGoblin;
        if (random < sommaPercentuali) return TipoMostriSpawn.GOBLIN;

        sommaPercentuali += percOrco;
        if (random < sommaPercentuali) return TipoMostriSpawn.ORCO;

        return TipoMostriSpawn.SCHELETRO;
    }
}
