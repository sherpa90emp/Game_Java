package Interface;

import Tipi.TipoDanno;

import  java.util.Scanner;

public interface Combattente {

    boolean attacco(Combattente bersaglio, Scanner scanner);
    void subisciDanno(int danno);
    int difesaPassiva(int danno, TipoDanno tipo);
    void difesaAttiva();
    boolean isDead();
    String getNome();
    short getHp();
}
