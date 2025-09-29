package core.nomi;

public enum nomiMercante {
    KOFI ("Kofi di Zanjara"),
    AMARA ("Amara di Nyumbani"),
    JABARI ("Jabari di Kalimba"),
    ZOLA ("Zola di Sundari"),
    AZIZI ("Azizi di Marula");

    private final String nome;

    nomiMercante(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static nomiMercante getRandomNome() {
        nomiMercante[] nomi = values();
        int index = (int) (Math.random() * nomi.length);
        return nomi[index];
    }
}
