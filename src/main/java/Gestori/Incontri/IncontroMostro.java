package Gestori.Incontri;

import Entita.Mostri.Mostro;
import Interface.Incontro;
import Entita.Mostri.Goblin;
import Entita.Mostri.Orco;
import Entita.Mostri.Scheletro;
import Entita.Player.Eroe;
import Tipi.TipoMostriSpawn;

import  java.util.ArrayList;
import  java.util.Scanner;

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
    public boolean esegui(Eroe eroe, TipoMostriSpawn tipo, Scanner scanner) {

        return false;
    }

    public Mostro getMostroGenerato() {
        return mostroGenerato;
    }

}
