package core.nomi;

public enum NomiGuaritore {
    ELANDRIL ("Elandril di Lórindor"),
    SYLTHARIEL ("Sylthariel di Aelwen"),
    FAELION ("Faelion di Mythralis"),
    CALANDRIEL ("Calandriel di Elenvar"),
    THALORIEN ("Thalorien di Vaeloria");

    private final String nome;

    NomiGuaritore(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static NomiGuaritore getRandomNome() {
        NomiGuaritore[] nomi = values();
        int index = (int) (Math.random() * nomi.length);
        return nomi[index];
    }
}
