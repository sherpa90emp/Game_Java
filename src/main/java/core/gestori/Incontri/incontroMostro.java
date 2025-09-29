package core.gestori.Incontri;

import controller.inputPort;
import core.entita.Mostri.mostro;
import core.interfacce.incontro;
import core.entita.Mostri.goblin;
import core.entita.Mostri.orco;
import core.entita.Mostri.scheletro;
import core.entita.Player.eroe;
import core.tipi.TipoMostriSpawn;

import  java.util.ArrayList;

public class incontroMostro implements incontro<TipoMostriSpawn> {

    private mostro mostroGenerato;

    @Override
    public void esegui(eroe eroe, TipoMostriSpawn tipoM) {
        switch (tipoM) {
            case GOBLIN -> {
                mostroGenerato = new goblin((short) 1, new ArrayList<>());
            }
            case ORCO -> {
                mostroGenerato = new orco((short) 1, new ArrayList<>());
            }
            case SCHELETRO -> {
                mostroGenerato = new scheletro((short) 1, new ArrayList<>());
            }
        }
        System.out.println("È apparso: " +"\n"+ mostroGenerato);
    }

    @Override
    public boolean esegui(eroe eroe, TipoMostriSpawn tipo, inputPort<String> input) {

        return false;
    }

    public mostro getMostroGenerato() {
        return mostroGenerato;
    }

}
