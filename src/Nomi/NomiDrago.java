package Nomi;

public enum NomiDrago {
    INFERNALE ("Drago Infernale di Fuoco"),
    OSCURO ("Drago Oscuro di Ghiaccio"),
    SELVAGGIO ("Drago Selvaggio di Vento"),
    ANTICO ("Drago Antico di Terra"),
    IMPETUOSO ("Drago Impetuoso di Fulmine"),
    SPETTRALE ("Drago Spettrale di Nebbia"),
    FEROCE ("Drago Feroce di Lava"),
    MALEDETTO ("Drago Maledetto degli Inferi"),
    VELENOSO ("Drago Velenoso di Ombra"),
    GLACIALE ("Drago Glaciale della Rovina");

    private final String nome;

    NomiDrago(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static NomiDrago getRandomNome() {
        NomiDrago[] nomi = values();
        int index = (int) (Math.random() * nomi.length);
        return nomi[index];
    }
}
