package core.entita.Mostri;

import controller.inputPort;
import core.entita.entita;
import core.interfacce.combattente;
import core.oggetti.oggetto;
import core.tipi.TipoDanno;

import java.util.ArrayList;

public abstract class mostro extends entita implements combattente {
    protected short livello;
    protected short hp;
    protected short difFisica;
    protected short difMagica;
    protected ArrayList<oggetto> drop;

    public mostro(String nome, short livello, short hp, short difFisica, short difMagica, ArrayList<oggetto> drop) {
        super(nome);
        this.livello = livello;
        this.hp = hp;
        this.difFisica = difFisica;
        this.difMagica = difMagica;
        this.drop = drop;
    }

    public short getLivello() {
        return livello;
    }

    public void setLivello(short livello) {
        this.livello = livello;
    }

    public short getHp() {
        return hp;
    }

    public void setHp(short hp) {
        if (hp < 0) hp = 0;
        this.hp = hp;
    }

    public short getDifFisica() {
        return difFisica;
    }

    public void setDifFisica(short difFisica) {
        this.difFisica = difFisica;
    }

    public short getDifMagica() {
        return difMagica;
    }

    public void setDifMagica(short difMagica) {
        this.difMagica = difMagica;
    }

    public ArrayList<oggetto> getDrop() {
        return drop;
    }

    public void setDrop(ArrayList<oggetto> drop) {
        this.drop = drop;
    }

    @Override
    public abstract boolean attacco(combattente bersaglio, inputPort<String> input);

    @Override
    public void subisciDanno(int danno) {
        setHp((short) (this.hp - danno));
    }

    @Override
    public int difesaPassiva(int danno, TipoDanno tipo) {
        int dannoMitigato;
        switch (tipo) {
            case FISICO -> {
                dannoMitigato = danno - this.difFisica;
            }
            case MAGICO -> {
                dannoMitigato = danno - this.difMagica;
            }
            default -> {
                dannoMitigato = danno;
            }
        }
        return Math.max(0, dannoMitigato);
    }

    @Override
    public boolean isDead() {
        return this.hp <= 0;
    }

    @Override
    public void difesaAttiva() {

    }
}
