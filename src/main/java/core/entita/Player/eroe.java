package core.entita.Player;

import controller.inputPort;
import core.entita.entita;
import core.interfacce.combattente;
import core.oggetti.oggetto;
import core.tipi.TipoDanno;

import java.util.ArrayList;
import java.util.List;

public abstract class eroe extends entita implements combattente {
    protected short livello;
    protected short hp;
    protected short hpMax;
    protected short difFisicaBase;
    protected short difFisica;
    protected short difMagicaBase;
    protected short difMagica;
    protected ArrayList<oggetto> inventario;
    private List<String> mostriUccisi = new ArrayList<>();
    protected short turniDifesaAttiva = 0;

    public eroe(String nome, short livello, short hp, short difFisica, short difMagica, ArrayList<oggetto> inventario) {
        super(nome);
        this.livello = 1;
        this.hpMax = hp;
        this.hp = hp;
        this.difFisicaBase = difFisica;
        this.difMagicaBase = difMagica;
        this.difFisica = difFisica;
        this.difMagica = difMagica;
        this.inventario = inventario;
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
        if (hp > hpMax) hp = hpMax;
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

    public ArrayList<oggetto> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<oggetto> inventario) {
        this.inventario = inventario;
    }

    public void aggiungiOggetto(oggetto oggetto) {
        inventario.add(oggetto);
    }

    public void rimuoviOggetto(oggetto oggetto) {
        inventario.remove(oggetto);
    }

    public short getHpMax() {
        return hpMax;
    }

    public void setHpMax(short hpMax) {
        this.hpMax = hpMax;
    }

    public short getDifFisicaBase() {
        return difFisicaBase;
    }

    public void setDifFisicaBase(short difFisicaBase) {
        this.difFisicaBase = difFisicaBase;
    }

    public short getDifMagicaBase() {
        return difMagicaBase;
    }

    public void setDifMagicaBase(short difMagicaBase) {
        this.difMagicaBase = difMagicaBase;
    }

    public String stampaInventario() {
        StringBuilder sb = new StringBuilder("Inventario:\n");
        for (oggetto o : inventario) {
            sb.append("- ").append(o).append("\n");
        }
        return sb.toString();
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
    public void difesaAttiva() {
        int difFisPrima = getDifFisica();
        int difMagPrima = getDifMagica();
        setDifFisica((short) (this.difFisicaBase * 1.5));
        setDifMagica((short) (this.difMagicaBase * 1.5));
        this.turniDifesaAttiva = 2;
        System.out.println("Le tue statistiche di difesa aumentano per " + this.turniDifesaAttiva + " turni!");
        System.out.println("Dif.F: " + difFisPrima + " -> " + this.getDifFisica());
        System.out.println("Dif.M: " + difMagPrima + " -> " + this.getDifMagica());
    }

    @Override
    public boolean isDead() {
        return this.hp <= 0;
    }

    public void aggiornaTurno() {
        if (turniDifesaAttiva > 0) {
            turniDifesaAttiva--;
            if (turniDifesaAttiva == 0) {
                setDifFisica(difFisicaBase);
                setDifMagica(difMagicaBase);
                System.out.println("Il potenziamento delle difese è terminato!");
            }
        }
    }

    public List<String> getMostriUccisi() {
        return new ArrayList<>(mostriUccisi);
    }

    public void aggiungiMostriUccisi(String nomeMostro) {
        mostriUccisi.add(nomeMostro);
    }

    public void aumentoLivello() {
        this.livello++;
        System.out.println("\nComplimenti, sei aumentato di livello!");
        System.out.println("\n[Lv. " + (livello - 1) + "]" + " -> " + "[Lv. " + livello + "]");
        potenziamentoStatistiche();
    }

    public abstract void potenziamentoStatistiche();
}


