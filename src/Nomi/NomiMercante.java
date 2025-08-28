package Nomi;

public enum NomiMercante {
    KOFI ("Kofi di Zanjara"),
    AMARA ("Amara di Nyumbani"),
    JABARI ("Jabari di Kalimba"),
    ZOLA ("Zola di Sundari"),
    AZIZI ("Azizi di Marula");

    private final String nome;

    NomiMercante(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static NomiMercante getRandomNome() {
        NomiMercante[] nomi = values();
        int index = (int) (Math.random() * nomi.length);
        return nomi[index];
    }
}
