package core.nomi;

public enum nomiGuaritore {
    ELANDRIL ("Elandril di Lórindor"),
    SYLTHARIEL ("Sylthariel di Aelwen"),
    FAELION ("Faelion di Mythralis"),
    CALANDRIEL ("Calandriel di Elenvar"),
    THALORIEN ("Thalorien di Vaeloria");

    private final String nome;

    nomiGuaritore(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static nomiGuaritore getRandomNome() {
        nomiGuaritore[] nomi = values();
        int index = (int) (Math.random() * nomi.length);
        return nomi[index];
    }
}
