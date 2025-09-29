package core.interfacce;

import controller.inputPort;
import core.tipi.TipoDanno;

public interface combattente {

    boolean attacco(combattente bersaglio, inputPort<String> input);
    void subisciDanno(int danno);
    int difesaPassiva(int danno, TipoDanno tipo);
    void difesaAttiva();
    boolean isDead();
    String getNome();
    short getHp();
}
