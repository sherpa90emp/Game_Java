package core.interfacce;

import controller.InputPort;
import core.tipi.TipoDanno;

public interface Combattente {

    boolean attacco(Combattente bersaglio, InputPort<String> input);

    void subisciDanno(int danno);

    int difesaPassiva(int danno, TipoDanno tipo);

    void difesaAttiva();

    boolean isDead();

    String getNome();

    short getHp();
}
