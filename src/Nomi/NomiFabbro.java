package Nomi;

public enum NomiFabbro {
    BJORN ("Bjorn di Skjoldheim"),
    HALDOR ("Haldor di Frostgard"),
    EIRIK ("Eirik di Drakensfjord"),
    SVEN ("Sven di Vargheim"),
    LEIF ("Leif di Niflheimar");

    private final String nome;

    NomiFabbro(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static NomiFabbro getRandomNome() {
        NomiFabbro[] nomi = values();
        int index = (int) (Math.random() * nomi.length);
        return nomi[index];
    }
}
