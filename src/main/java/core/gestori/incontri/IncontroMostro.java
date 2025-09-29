package core.gestori.incontri;

import controller.InputPort;
import core.entita.mostri.Mostro;
import core.interfacce.Incontro;
import core.entita.mostri.Goblin;
import core.entita.mostri.Orco;
import core.entita.mostri.Scheletro;
import core.entita.player.Eroe;
import core.tipi.TipoMostriSpawn;

import  java.util.ArrayList;

public class IncontroMostro implements Incontro<TipoMostriSpawn> {

    private Mostro mostroGenerato;

    @Override
    public void esegui(Eroe eroe, TipoMostriSpawn tipoM) {
        switch (tipoM) {
            case GOBLIN -> {
                mostroGenerato = new Goblin((short) 1, new ArrayList<>());
            }
            case ORCO -> {
                mostroGenerato = new Orco((short) 1, new ArrayList<>());
            }
            case SCHELETRO -> {
                mostroGenerato = new Scheletro((short) 1, new ArrayList<>());
            }
        }
        System.out.println("È apparso: " +"\n"+ mostroGenerato);
    }

    @Override
    public boolean esegui(Eroe eroe, TipoMostriSpawn tipo, InputPort<String> input) {

        return false;
    }

    public Mostro getMostroGenerato() {
        return mostroGenerato;
    }

}
