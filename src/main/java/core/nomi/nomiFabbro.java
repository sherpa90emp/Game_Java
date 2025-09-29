package core.nomi;

public enum nomiFabbro {
    BJORN ("Bjorn di Skjoldheim"),
    HALDOR ("Haldor di Frostgard"),
    EIRIK ("Eirik di Drakensfjord"),
    SVEN ("Sven di Vargheim"),
    LEIF ("Leif di Niflheimar");

    private final String nome;

    nomiFabbro(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static nomiFabbro getRandomNome() {
        nomiFabbro[] nomi = values();
        int index = (int) (Math.random() * nomi.length);
        return nomi[index];
    }
}
